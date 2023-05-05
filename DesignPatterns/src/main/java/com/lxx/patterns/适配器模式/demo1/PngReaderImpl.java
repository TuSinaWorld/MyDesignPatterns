package com.lxx.patterns.适配器模式.demo1;

public class PngReaderImpl implements PngReader {
    @Override
    public String readPng() {
        return "模拟读取png图片";
    }
}
