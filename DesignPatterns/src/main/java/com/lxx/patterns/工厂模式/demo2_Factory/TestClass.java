package com.lxx.patterns.工厂模式.demo2_Factory;

public class TestClass {
    public static void main(String[] args) {
        //只需指定工厂,就可通过getInstance()方法返回相应类型~
        CarFactory cf = new Car_A_Factory();
        //通过getInstance()返回某个Car类型
        Car c = cf.getInstance();
        System.out.println(c.getCar());
        cf = new Car_B_Factory();
        System.out.println(cf.getInstance().getCar());
    }
}
