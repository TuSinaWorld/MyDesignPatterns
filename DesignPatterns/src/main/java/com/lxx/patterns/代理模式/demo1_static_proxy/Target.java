package com.lxx.patterns.代理模式.demo1_static_proxy;

//目标类
public class Target implements TargetInterface {
    @Override
    public Integer getInt(int num) {
        return ++num;
    }
}
