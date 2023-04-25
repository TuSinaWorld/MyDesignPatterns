package com.lxx.patterns.原型模式.demo_deepClone;

//测试类,稍显繁琐?
// 这叫严谨(一本正经)
public class TestClass {
    public static void main(String[] args) {
        //获取容器中的原型~正常生存环境可不能这么玩
        Person a = GetPerson.map.get("A");
        //获取原型的克隆~
        Person a1 = GetPerson.getPerson("A");
        Person a2 = GetPerson.getPerson("A");
//        Person b = GetPerson.map.get("B");
//        Person b1 = GetPerson.getPerson("B");
//        Person b2 = GetPerson.getPerson("B");
        a.startRun();
        a1.startRun();
        a2.startRun();
        //测试完成,结果非常完美~~这不是deepclone这是啥ヾ(≧▽≦*)o
        //重点的原型模式概念?deep clone都了解了怎么可能还不熟悉?!

//        System.out.println("======================");
//        b.startRun();
//        b1.startRun();
//        b2.startRun();

    }
}
