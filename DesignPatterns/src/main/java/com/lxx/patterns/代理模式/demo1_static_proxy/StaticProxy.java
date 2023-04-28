package com.lxx.patterns.代理模式.demo1_static_proxy;

public class StaticProxy implements TargetInterface{

    TargetInterface tg = new Target();

    @Override
    public Integer getInt(int num) {
        System.out.println("这是个增强,具体懒得写(～￣▽￣)～");
        return tg.getInt(num);
    }
}
