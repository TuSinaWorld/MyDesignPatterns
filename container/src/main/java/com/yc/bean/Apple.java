package com.yc.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.annotation.YcComponent;
import org.ycframework.annotation.YcLazy;
import org.ycframework.annotation.YcRepository;
import org.ycframework.annotation.YcScope;

@YcRepository
@YcLazy
//@YcScope("prototype")
public class Apple {

    private int id;
    private Logger logger = LoggerFactory.getLogger(Apple.class);

    public Apple() {
        System.out.println("构造方法(Apple)");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}
