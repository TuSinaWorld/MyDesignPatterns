package com.lxx.patterns.适配器模式.demo1;

public class PngAdapterJpg implements PngReader{

    JpgReader jpgReader;

    public PngAdapterJpg(JpgReader jpgReader){
        this.jpgReader = jpgReader;
    }

    @Override
    public String readPng() {
        return jpgReader.readJpg();
    }
}
