package com.lxx.patterns.原型模式.demo_deepClone;

public abstract class Person implements Cloneable{

    private String name;

    private Tool tool;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Tool getTool() {
        return tool;
    }

    //为了实现简略深克隆,加入一点奇奇怪怪的建造者很正常吧?!~~~
    protected Person setTool(Tool tool) {
        this.tool = tool;
        return this;
    }

    //执行方法(随便写写凑合就行了~~)
    abstract void startRun();

    //核心在于该clone方法,不过懒得重写(重写也无非就是复制下参数),直接调用object的实现就好了~~~
    //特别注意:clone默认实现为浅克隆,若要进行深克隆,需要使用递归利用反射赋值给克隆对象啥的,麻烦,但有必要
    //此处深克隆属于超级简略的不可通用实现~~
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return ((Person)super.clone()).setTool(new Tool());
    }
}
