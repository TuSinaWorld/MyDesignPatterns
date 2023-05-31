package com.lxx.patterns.builder_pattern.demo2_myStringBuffer;

//此类只是非常非常简单的StringBuffer模拟,并未实现StringBuffer的大多数功能
//比如StringBuffer使用char []数组实现,且保持一直为同一对象,此类特性本类均为实现
//若想了解,请看StringBuffer底层源码~~
public class MyStringBuffer {
    //定义MyStringBuffer的属性,这里只是简陋实现故只使用String
    private String value;

    //构造函数:获取新类同时初始化value
    public MyStringBuffer(){
        this.value = "";
    }

    //简陋实现,未实现针对不同属性不同处理方法~~
    //使用泛型,保证不同属性均可添加
    public <T> MyStringBuffer append(T t){
        //非常简陋的实现,真正StringBuffer底层使用的是System.arraycopy()方法,可以自行查看
        value += ((String.valueOf(t)));
        //建造者模式核心:return this;
        return this;
    }

    //toSting用于取出里面字符串,难得的跟StringBuffer相差不大的方法...虽然也有区别...
    @Override
    public String toString() {
        return value;
    }
}
