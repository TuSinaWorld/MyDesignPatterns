package com.lxx.patterns.代理模式.demo3_cglib_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

//代理实现类
public class ProxyRealization implements MethodInterceptor {
    //o:目标类对象.
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //根据方法名字增强
        if(method.getName().startsWith("get")){
            System.out.println("this is a get method.");
        }
        //根据参数增强
        if(objects.length == 1 && objects[0] instanceof Integer){
            System.out.println("If your num < 100 && instanceof Integer,let num = 100.");
            objects[0] = (Integer)objects[0] >= 100 ? objects[0] : 100;
        }
        //返回结果
        //根据源码注释,使用methodProxy效率更高哦~~
        return methodProxy.invoke(o.getClass().getConstructor().newInstance(),objects);
    }
}
