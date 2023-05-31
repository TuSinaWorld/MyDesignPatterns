package com.lxx.patterns.factory_pattern.demo2_Factory;

public class Car_B_Factory implements CarFactory{
    //Car工厂的一个实现类
    @Override
    public Car getInstance() {
        return new Car_B();
    }
}
