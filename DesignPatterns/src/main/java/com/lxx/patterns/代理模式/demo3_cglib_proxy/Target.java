package com.lxx.patterns.代理模式.demo3_cglib_proxy;

//目标类
public class Target {
    public Integer getInt(int num) {
        return ++num;
    }
}
