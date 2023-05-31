package com.lxx.patterns.singleton_pattern.demo1_singleton;

import java.io.Serializable;

//模拟序列化后可能遇见的问题
public class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static Singleton demo1Singleton = new Singleton();

    //私有构造方法,防止误调用
    private Singleton(){
        //新增检测,防止反射误调用
        //此判断不受线程影响
        if(demo1Singleton != null){
            throw new RuntimeException("请不要再单例模式中用反射调用构造方法!");
        }
    }


    //获取单例对象
    public static Singleton newInstance(){
        return demo1Singleton;
    }


    //针对反序列化破坏单例做出提防
    public Object readResolve(){
        return demo1Singleton;
    }
}
