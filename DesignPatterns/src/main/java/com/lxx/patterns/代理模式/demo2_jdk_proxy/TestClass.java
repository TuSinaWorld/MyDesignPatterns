package com.lxx.patterns.代理模式.demo2_jdk_proxy;

import java.lang.reflect.InvocationTargetException;

public class TestClass {
    //测试类
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获取目标类
        Target tc = new Target();
        //用目标类从代理工厂类获取到代理类
        TargetInterface proxy = (TargetInterface) ProxyFactory.getProxy(tc);
        //执行代理方法并观察过程与结果~~
        System.out.println("result1(num>=100):" + proxy.getInt(122));
        System.out.println("result2(num<100):" + proxy.getInt(88));
    }
}
