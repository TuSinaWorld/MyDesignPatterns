package com.lxx.patterns.adapter_pattern.demo;

public class JpgReaderImpl implements JpgReader {
    @Override
    public String readJpg() {
        return "模拟读取不直接兼容的jpg图片";
    }
}
