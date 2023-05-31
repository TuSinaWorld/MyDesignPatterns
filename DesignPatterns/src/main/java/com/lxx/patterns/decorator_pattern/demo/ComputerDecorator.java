package com.lxx.patterns.decorator_pattern.demo;

public abstract class ComputerDecorator implements Computer{
    protected Computer decodeComputer;
    public ComputerDecorator(Computer computer){
        this.decodeComputer = computer;
    }
    @Override
    public void showComputer() {
        decodeComputer.showComputer();
    }
}
