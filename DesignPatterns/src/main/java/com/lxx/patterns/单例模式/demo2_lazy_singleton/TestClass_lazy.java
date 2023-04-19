package com.lxx.patterns.单例模式.demo2_lazy_singleton;

public class TestClass_lazy {
    public static void main(String[] args) {
        //依然不可能使用Singleton_Lazy s1 = new Singleton_Lazy();创建~~

        //创建两个单例
        Singleton_Lazy s1 = Singleton_Lazy.newInstance();
        Singleton_Lazy s2 = Singleton_Lazy.newInstance();
        //比较其是否相同判断是否为单例~
        System.out.println(s1.hashCode() == s2.hashCode());

    }
}
