package com.lxx.patterns.代理模式.demo3_cglib_proxy;

import java.lang.reflect.InvocationTargetException;

public class TestClass {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过cglib获取代理类(代理类继承自目标类)
        Target proxy = (Target) ProxyFactory.getProxy(new Target());
        //观察结果~
        System.out.println(proxy.getInt(123));
        System.out.println(proxy.getInt(81));
    }
}
