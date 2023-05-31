package com.lxx.patterns.prototype_pattern.demo_deepClone;


//理论上一个实现类就够了,不过这样我演示不出来容器的意义...
//那就决定是你了!PersonB!
public class PersonB extends Person{

    //构造方法中把名字啥的放一放
    public PersonB(){
        this.setName("B");
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
