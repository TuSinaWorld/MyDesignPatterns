package org.ycframework.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.annotation.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class YcAnnotationConfigApplicationContext implements YcApplicationContext{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Map<String,BeanSetting> beanSettingMap = new ConcurrentHashMap<>();
    private final Map<String,Object> beanObject = new ConcurrentHashMap<>();

    public YcAnnotationConfigApplicationContext(Class<?>... componentClasses){
        ArrayList<String> myPackage = new ArrayList<>();
        /**
         * 扫描所有类并确认所有配置类的路径
         */
        for (Class<?> componentClass : componentClasses) {
            if (componentClass.isAnnotationPresent(YcComponentScan.class) && componentClass.isAnnotationPresent(YcConfiguration.class)) {
                if(componentClass.getAnnotation(YcComponentScan.class).value() != null && componentClass.getAnnotation(YcComponentScan.class).value().length != 0){
                    /**
                     * 保存@YcComponentScan中的所有路径
                     */
                    Collections.addAll(myPackage, componentClass.getAnnotation(YcComponentScan.class).value());
                }else {
                    myPackage.add(componentClass.getPackage().getName());
                }
            }
        }
        /**
         * 开始扫描!
         */
        findBeans(myPackage);
        doDi();
    }

    private void doDi() {
        beanObject.forEach((beanId,object) -> {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if(declaredField.isAnnotationPresent(YcAutowired.class)){
                    String value = declaredField.getAnnotation(YcAutowired.class).value();
                    Object valueObject = getBean(value);
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(object,valueObject);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    /**
     * 查看所有bean
     */
    public void showBeanMap(){
        for (String s : beanSettingMap.keySet()) {
            System.out.println(s);
            System.out.println(beanSettingMap.get(s));
        }
    }

    /**
     * 获取bean的方法~~
     * @param beanId
     * @return
     */
    public Object getBean(String beanId){
        /**
         * 若已经存在实例化对象,则直接调用
         */
        if(beanObject.containsKey(beanId)){
            return beanObject.get(beanId);
        }
        /**
         * 若未存在实例化对象,则以情况判断:
         * (若beanSettingMap不存在此beanId则此bean不存在)
         */
        if(beanSettingMap.containsKey(beanId)){
            BeanSetting beanSetting = beanSettingMap.get(beanId);
            try {
                /**
                 * 若此bean为@Bean生成
                 */
                if (beanSetting.isUseMethod()) {
                    /**
                     * 多例情况,此方法比懒加载调用次数多,放前面有利于性能
                     */
                    if (beanSetting.isUseScope()) {
                        Object invoke;
                        /**
                         * 请注意:AppConfig配置类一样可以是单例/多例!而此类下带有@Bean注解实例化时,会使用此类的实例化对象!
                         * 此函数是为了在AppConfig类未被主动调用时自动设置其合适的类型且返回@Bean方法所需的实例化对象.
                         */
                        invoke = getObject(beanSetting);
                        return invoke;
                    }
                    /**
                     * 懒加载情况
                     */
                    if (beanSetting.isUseLazy()) {
                        Object invoke;
                        /**
                         * 请注意:AppConfig配置类一样可以是单例/多例!而此类下带有@Bean注解实例化时,会使用此类的实例化对象!
                         * 此函数是为了在AppConfig类未被主动调用时自动设置其合适的类型且返回@Bean方法所需的实例化对象.
                         */
                        invoke = getObject(beanSetting);
                        beanObject.put(beanId,invoke);
                        return invoke;
                    }
                }
                /**
                 * 若此bean为非@Bean生成
                 */
                else {
                    /**
                     * 多例情况,此方法比懒加载调用次数多,放前面有利于性能
                     */
                    if (beanSetting.isUseScope()) {
                        return beanSetting.getCls().getConstructor().newInstance();
                    }
                    /**
                     * 懒加载情况
                     */
                    if (beanSetting.isUseLazy()) {
                        Object o = beanSetting.getCls().getConstructor().newInstance();
                        beanObject.put(beanId,o);
                        return o;
                    }
                }
            }catch(Exception e){
                throw new RuntimeException("错误!"+e);
            }
        }
        logger.error("未找到该bean...");
        return null;
    }

    /**
     * 请注意:AppConfig配置类一样可以是单例/多例!而此类下带有@Bean注解实例化时,会使用此类的实例化对象!
     * 此函数是为了在AppConfig类未被主动调用时自动设置其合适的类型且返回@Bean方法所需的实例化对象.
     * @param beanSetting
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     */
    private Object getObject(BeanSetting beanSetting) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Object invoke;
        if(beanObject.containsKey(toLowerCase(beanSetting.getCls().getSimpleName()))) {
            invoke = beanSetting.getMd().invoke(beanObject.get(toLowerCase(beanSetting.getCls().getSimpleName())), null);
        }else {
            Object o = beanSetting.getCls().getConstructor().newInstance();
            invoke = beanSetting.getMd().invoke(o,null);
            if(beanSettingMap.containsKey(toLowerCase(beanSetting.getCls().getSimpleName())) &&
                    beanSettingMap.get(toLowerCase(beanSetting.getCls().getSimpleName())).isUseLazy()){
                beanObject.put(toLowerCase(beanSetting.getCls().getSimpleName()),o);
            }
        }
        return invoke;
    }

    /**
     * 适配多个路径扫描
     * @param packageNames
     */
    private void findBeans(ArrayList<String> packageNames){
        for(String packageName : packageNames){
            findBean(packageName);
        }
    }

    /**
     * 扫描功能
     * @param packageName
     */
    private void findBean(String packageName) {
        String packagePath = packageName.replaceAll("\\.", "/");
        //服务器启动时，扫描塔所有的classes，查找@YcWebServlet的class，存到map中
        //jvm类加载器
        try {
            Enumeration<URL> files = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (files.hasMoreElements()) {
                URL url = files.nextElement();
                logger.info("正在扫描的包路径为:" + url.getFile());
                //查找此包下面的文件
                findPackageClasses(url.getFile(), packageName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 扫描功能
     * @param packagePath
     * @param packageName
     */
    private void findPackageClasses(String packagePath,String packageName) {
        if (packagePath.startsWith("/")) {
            packagePath = packagePath.substring(1);
        }
        //取这个路径下所有的字节码文件
        File file = new File(packagePath);
        File[] classFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".class") || pathname.isDirectory();
            }
        });
        if (classFiles != null) {
            for (File cf : classFiles) {
                if (cf.isDirectory()) {
                    findPackageClasses(cf.getAbsolutePath(), packageName + "." + cf.getName());
                } else {
                    //是字节码文件，则利用类加载器加载这个 class文件
                    ClassLoader uc = new URLClassLoader(new URL[]{});
                    try {
                        Class<?> cls=uc.loadClass(packageName+"."+cf.getName().replaceAll(".class",""));
                        //logger.info("加载了一个类:"+cls.getName());
                        if(cls.isAnnotationPresent(YcComponent.class) || cls.isAnnotationPresent(YcRepository.class)
                           ||cls.isAnnotationPresent(YcService.class) || cls.isAnnotationPresent(YcController.class)){
//                            beanMap.put(toLowerCase(cls.getSimpleName()),cls);
                            /**
                             * 若扫描到托管类,则运行此函数将其执行保存/实例化操作
                             */
                            extracted(cls);
                        }
                        /**
                         * 若扫描到设置类,则运行此函数将其执行保存/实例化操作
                         */
                        else if(cls.isAnnotationPresent(YcConfiguration.class)){
                            extracted(cls);
                            /**
                             * 同时扫描其中是否存在@Bean类
                             */
                            for (Method method : cls.getDeclaredMethods()) {
                                /**
                                 * 若扫描到@Bean类,则运行此函数将其执行保存/实例化操作
                                 */
                                if(method.isAnnotationPresent(YcBean.class)){
                                    extracted(cls,method);
                                }
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 扫描托管类保存(非单例)/实例化(仅单例)功能
     * @param cls
     */
    private void extracted(Class<?> cls) {
        String simpleName = toLowerCase(cls.getSimpleName());
        BeanSetting beanSetting = new BeanSetting();
        beanSetting.setBeanId(simpleName);
        beanSetting.setCls(cls);
        /**
         * 懒加载标识
         */
        if(cls.isAnnotationPresent(YcLazy.class)){
            beanSetting.setUseLazy(true);
        }
        /**
         * 多例标识
         */
        else if (cls.isAnnotationPresent(YcScope.class) && cls.getAnnotation(YcScope.class).value().equals("prototype")) {
            beanSetting.setUseScope(true);
        }
        /**
         * 单例则直接实例化并装载进实例化map中去
         */
        else{
            /**
             * 检测已经被实例化的单例,避免重复实例化
             */
            if(beanObject.containsKey(simpleName)){
                return;
            }
            try {
                beanObject.put(simpleName,cls.getConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        beanSettingMap.put(simpleName,beanSetting);
    }

    /**
     * @Bean类保存(非单例)/实例化(仅单例)功能
     * @param cls
     * @param m
     */
    private void extracted(Class<?> cls,Method m) {
        String simpleName = toLowerCase(m.getName());
        BeanSetting beanSetting = new BeanSetting();
        beanSetting.setBeanId(simpleName);
        beanSetting.setCls(cls);
        beanSetting.setMd(m);
        /**
         * @Bean类独有注解,用于标识其与扫描类的区别
         */
        beanSetting.setUseMethod(true);
        /**
         * 懒加载标识
         */
        if(m.isAnnotationPresent(YcLazy.class)){
            beanSetting.setUseLazy(true);
        }
        /**
         * 多例标识
         */
        else if (m.isAnnotationPresent(YcScope.class) && m.getAnnotation(YcScope.class).value().equals("prototype")) {
            beanSetting.setUseScope(true);
        }
        /**
         * 单例则直接实例化并装载进实例化map中去
         */
        else {
            /**
             * 检测已经被实例化的单例,避免重复实例化
             */
            if(beanObject.containsKey(simpleName)){
                return;
            }
            try {
                Object invoke = m.invoke(cls.getConstructor().newInstance(), null);
                beanObject.put(simpleName,invoke);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        beanSettingMap.put(simpleName,beanSetting);
    }

    /**
     * 首字母小写
     * @param upperCase
     * @return
     */
    private String toLowerCase(String upperCase){
        if(upperCase == null || upperCase.equals(""))
            throw new RuntimeException("错误的字符串!");
        String upper = upperCase.substring(0, 1);
        String rightString = upperCase.substring(1);
        if(Character.isUpperCase(upper.charAt(0))){
            String s = upper.toLowerCase();
            return s+rightString;
        }
        return upperCase;
    }
}
