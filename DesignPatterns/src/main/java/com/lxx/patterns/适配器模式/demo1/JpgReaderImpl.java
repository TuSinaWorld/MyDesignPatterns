package com.lxx.patterns.适配器模式.demo1;

public class JpgReaderImpl implements JpgReader {
    @Override
    public String readJpg() {
        return "模拟读取不直接兼容的jpg图片";
    }
}
