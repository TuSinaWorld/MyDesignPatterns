package com.lxx.patterns.proxy_pattern.demo3_cglib_proxy;

import net.sf.cglib.proxy.Enhancer;


//代理工厂类
public class ProxyFactory {
    //获取代理类的方法
    public static Object getProxy(Object targetClass){
        Enhancer eh = new Enhancer();
        //设置目标类
        eh.setSuperclass(targetClass.getClass());
        //设置回调对象
        eh.setCallback(new ProxyRealization());
        return eh.create();
    }
}
