package com.yc.bean;

import org.ycframework.annotation.YcAutowired;
import org.ycframework.annotation.YcComponent;
import org.ycframework.annotation.YcLazy;

@YcComponent
public class Pear {
    private Integer id = 0;
    private Double price = 0.0;
    private String name = "";

    @YcAutowired("apple")
    private Apple apple;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pear(Integer id, Double price, String name, Apple apple) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.apple = apple;
    }

    @Override
    public String toString() {
        return "Pear{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", apple=" + apple +
                '}';
    }

    public Pear() {
    }
}
