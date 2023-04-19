package com.lxx.patterns.单例模式.demo1_singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static Singleton demo1Singleton = new Singleton();

    //私有构造方法,防止误调用
    private Singleton(){
        //新增检测,防止反射误调用
        //此判断不受线程影响
        if(demo1Singleton != null){
            throw new RuntimeException("请不要再单例模式中用反射调用构造方法!");
        }
    }




    //针对反序列化破坏单例做出提防
    public Object readResolve(){
        return demo1Singleton;
    }
}
