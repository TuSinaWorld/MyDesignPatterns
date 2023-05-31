package com.lxx.patterns.proxy_pattern.demo2_jdk_proxy;

import java.lang.reflect.Proxy;

//代理工厂类(按我的习惯是和ProxyRealization写在一起的,
// 但是这样总感觉第一个参数和第三个参数的区别体现不出来,
//故分两个类实现~~
public class ProxyFactory {
    //获取代理类的方法
    public static Object getProxy(Object targetClass) {
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                targetClass.getClass().getInterfaces(),
                //喵的,反射反上瘾,结果改了一长串不如一个new...
                new ProxyRealization(targetClass));
    }
}
