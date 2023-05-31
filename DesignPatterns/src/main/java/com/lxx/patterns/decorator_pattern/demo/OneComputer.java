package com.lxx.patterns.decorator_pattern.demo;

public class OneComputer extends ComputerDecorator{
    public OneComputer(Computer computer) {
        super(computer);
    }

    @Override
    public void showComputer() {
        System.out.print("One Computer:");
        super.showComputer();
    }
}