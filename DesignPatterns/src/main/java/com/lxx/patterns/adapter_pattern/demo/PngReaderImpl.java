package com.lxx.patterns.adapter_pattern.demo;

public class PngReaderImpl implements PngReader {
    @Override
    public String readPng() {
        return "模拟读取png图片";
    }
}
