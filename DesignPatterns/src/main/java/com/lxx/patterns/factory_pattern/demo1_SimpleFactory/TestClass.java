package com.lxx.patterns.factory_pattern.demo1_SimpleFactory;

public class TestClass {
    //测试类,严格来说简单工厂不算设计模式,但还是写出于此.
    public static void main(String[] args) {
        CarSimpleFactory csf = new CarSimpleFactory();
        Car car = csf.getInstance("A");
        System.out.println(car.getCar());
        car = csf.getInstance("B");
        System.out.println(car.getCar());
    }
}
