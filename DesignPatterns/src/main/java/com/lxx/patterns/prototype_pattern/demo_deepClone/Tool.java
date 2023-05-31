package com.lxx.patterns.prototype_pattern.demo_deepClone;

public class Tool implements Cloneable{
    private Integer length = 10;

    //别问,问就是懒,这建造者模式越用越上瘾
    //只要知道重点是原型模式就行了~~~

    //增加长度,增加深clone和浅clone的区分度?算我无聊加的?
    public Tool addLength(){
        length *= 2;
        return this;
    }

    //减少长度
    public Tool reduceLength(){
        length /= 2;
        return this;
    }

    public Integer getLength() {
        return length;
    }


    //懒,直接Object clone解决一切~~
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
