package com.lxx.patterns.原型模式.demo_deepClone;

import java.util.HashMap;
import java.util.Map;

//想了半天都不知道叫啥名字好
//随便叫吧(～￣▽￣)～
public class GetPerson {
    //存放原型类的map
    //话说能用static节省代码为什么不用~~~~
    //(≧∇≦)ﾉ
    //猜猜为什么会是public~~
    //自然是用作对比了~~~正式代码可不能这么玩~~
    public static Map<String,Person> map = new HashMap<>();
    //极简代码风~~~
    //初始化啦~~
    static {
        Person personA = new PersonA();
        Person personB = new PersonB();
        //让区分度upup,不然怎么凸显我是deep clone   ヾ(≧▽≦*)o
        map.put(personA.getName(),personA.setTool(personA.getTool().addLength()));
        map.put(personB.getName(),personB.setTool(personB.getTool().reduceLength()));
    }

    //获取克隆类~~
    public static Person getPerson(String name){
        Person p = null;
        try {
            p = (Person) map.get(name).clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
}
