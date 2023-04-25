package com.lxx.patterns.原型模式.demo_deepClone;

public class PersonA extends Person{

    //构造方法中把名字啥的放一放
    public PersonA(){
        this.setName("A");
        this.setTool(new Tool());
    }

    //调用方法执行啥巴拉巴拉的
    //就是个提示罢了
    @Override
    public void startRun() {
        System.out.println("该方法自身参数:[class:" + this.getClass().getSimpleName() + ",hashcode:" + this.hashCode() + ",name:" + this.getName() + "]");
        System.out.println("该方法调用类Tool的参数:[hashcode:" +  this.getTool().hashCode() + ",length:" + this.getTool().getLength() + "]");
    }
}
