package com.lxx.patterns.建造者模式.demo1;

public class TestClass {
    public static void main(String[] args) {
        //使用建造者模式构建对象
        Stu stu = Stu.builder()
                .name("Eldon")
                .age(18)
                .gender("Man").build();
        //输出测试
        System.out.println(stu);
    }
}
