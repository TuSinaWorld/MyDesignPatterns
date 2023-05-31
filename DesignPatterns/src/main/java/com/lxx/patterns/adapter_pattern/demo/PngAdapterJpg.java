package com.lxx.patterns.adapter_pattern.demo;

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
