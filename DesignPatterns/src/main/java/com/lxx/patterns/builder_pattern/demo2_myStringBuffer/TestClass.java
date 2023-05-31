package com.lxx.patterns.builder_pattern.demo2_myStringBuffer;

public class TestClass {
    public static void main(String[] args) {
        MyStringBuffer mbf = new MyStringBuffer();
        String s = mbf.append("你好").append(123).append('|').append(12.53).toString();
        System.out.println(s);
    }
}
