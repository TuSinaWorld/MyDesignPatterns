package com.lxx.patterns.factory_pattern.demo1_SimpleFactory;

public class CarSimpleFactory {
    //简单工厂获取实例
    //判读输入类型返回对应实例
    public Car getInstance(String s) {
        if(s.equalsIgnoreCase("A")){
            return new Car_A();
        }
        return new Car_B();
    }
}
