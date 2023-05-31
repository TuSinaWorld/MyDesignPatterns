package com.lxx.patterns.singleton_pattern.demo2_lazy_singleton;

import java.io.Serializable;

//模拟序列化后可能遇见的问题
public class Singleton_Lazy implements Serializable {

    private static final long serialVersionUID = 1L;

    //为了避免空指针异常,需设置为volatile类型~~
    private static volatile Singleton_Lazy demo2Singleton;

    //依然是私有构造方法,原因依旧是防止误创建~
    private Singleton_Lazy(){
        //防止反射重复使用构造方法创造单例~
        if(demo2Singleton != null){
            throw new RuntimeException("请勿通过反射机制重复创建单例!");
        }
    }

    //获取单例方法
    public static Singleton_Lazy newInstance(){
        //使用双重检查锁机制避免多线程情况下单例的重复创建~~
        if(demo2Singleton == null){
            synchronized (Singleton_Lazy.class){
                if(demo2Singleton == null){
                    return (demo2Singleton = new Singleton_Lazy());
                }
            }
        }
        return demo2Singleton;
    }

    //针对反序列化破坏单例做出提防
    public Object readResolve(){
        return demo2Singleton;
    }

}
