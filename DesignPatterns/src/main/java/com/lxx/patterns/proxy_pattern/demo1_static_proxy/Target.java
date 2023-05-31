package com.lxx.patterns.proxy_pattern.demo1_static_proxy;

//目标类
public class Target implements TargetInterface {
    @Override
    public Integer getInt(int num) {
        return ++num;
    }
}
