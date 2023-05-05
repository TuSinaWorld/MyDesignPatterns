package com.lxx.patterns.适配器模式.demo1;

public class ComputerImpl implements Computer {
    @Override
    public void readPng(PngReader pngReader) {
        System.out.println("模拟电脑读取...");
        System.out.println(pngReader.readPng());
    }
}
