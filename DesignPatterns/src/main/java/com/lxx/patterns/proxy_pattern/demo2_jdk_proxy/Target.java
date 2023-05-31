package com.lxx.patterns.proxy_pattern.demo2_jdk_proxy;

//目标类
public class Target implements TargetInterface{
    @Override
    public Integer getInt(int num) {
        return ++num;
    }
}
