package com.lxx.patterns.工厂模式.demo2_Factory;

public class Car_A_Factory implements CarFactory{
    //Car工厂的一个实现类
    @Override
    public Car getInstance() {
        return new Car_A();
    }
}
