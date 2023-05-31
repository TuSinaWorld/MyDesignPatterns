package com.lxx.patterns.decorator_pattern.demo;

public class TestClass {
    public static void main(String[] args) {
        ComputerDecorator computerDecorator = new OneComputer(new DellComputer());
        computerDecorator.showComputer();
    }
}
