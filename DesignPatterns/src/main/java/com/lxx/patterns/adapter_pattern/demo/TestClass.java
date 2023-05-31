package com.lxx.patterns.adapter_pattern.demo;

public class TestClass {
    //测试类,模拟电脑访问不直接兼容的jpg
    public static void main(String[] args) {
        Computer cp = new ComputerImpl();
        JpgReader jpgReader = new JpgReaderImpl();
        PngAdapterJpg paj = new PngAdapterJpg(jpgReader);
        cp.readPng(paj);
    }
}
