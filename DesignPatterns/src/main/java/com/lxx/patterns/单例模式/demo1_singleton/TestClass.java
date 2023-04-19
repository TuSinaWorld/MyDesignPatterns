package com.lxx.patterns.单例模式.demo1_singleton;

public class TestClass {

    //主方法,测试对象是否为单例
    public static void main(String[] args) {
        //由于私有构造方法,Singleton singleton = new Singleton();无法执行也不允许执行
        //尝试创建两次单例对象:
        Singleton s1 = Singleton.newInstance();
        Singleton s2 = Singleton.newInstance();
        //比较两者hash码,确认对象是否为同一个
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
