package com.lxx.patterns.proxy_pattern.demo1_static_proxy;

public class TestClass {
    public static void main(String[] args) {
        TargetInterface sp = new StaticProxy();
        System.out.println(sp.getInt(111));
    }
}
