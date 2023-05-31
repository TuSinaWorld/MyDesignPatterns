package com.lxx.patterns.proxy_pattern.demo3_cglib_proxy;

//目标类
public class Target {
    public Integer getInt(int num) {
        return ++num;
    }
}
