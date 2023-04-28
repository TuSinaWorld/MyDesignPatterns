package com.lxx.patterns.代理模式.demo1_static_proxy;

public class TestClass {
    public static void main(String[] args) {
        TargetInterface sp = new StaticProxy();
        System.out.println(sp.getInt(111));
    }
}
