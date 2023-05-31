package com.lxx.patterns.adapter_pattern.demo;

public class ComputerImpl implements Computer {
    @Override
    public void readPng(PngReader pngReader) {
        System.out.println("模拟电脑读取...");
        System.out.println(pngReader.readPng());
    }
}
