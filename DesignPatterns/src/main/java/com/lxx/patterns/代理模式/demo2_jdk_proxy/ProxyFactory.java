package com.lxx.patterns.代理模式.demo2_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

//代理工厂类(按我的习惯是和ProxyRealization写在一起的,
// 但是这样总感觉第一个参数和第三个参数的区别体现不出来,
//故分两个类实现~~
public class ProxyFactory {
    //获取代理类的方法
    public static Object getProxy(Object targetClass) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                targetClass.getClass().getInterfaces(),
                //之前脑抽把代理实现类叫Proxy...差点没给我报错报麻...
                (InvocationHandler) ProxyRealization.class.getConstructors()[0].newInstance(targetClass));
    }
}
