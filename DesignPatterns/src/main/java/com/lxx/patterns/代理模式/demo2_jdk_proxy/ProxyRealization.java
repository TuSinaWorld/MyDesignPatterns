package com.lxx.patterns.代理模式.demo2_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理实现类
public class ProxyRealization implements InvocationHandler {

    //目标对象
    private final Object targetClass;

    //构造方法
    public ProxyRealization(Object targetClass){
        this.targetClass = targetClass;
    }

    //代理实现类,话说proxy我都感觉没怎么用过
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据方法名字增强
        if(method.getName().startsWith("get")){
            System.out.println("this is a get method.");
        }
        //根据参数增强
        if(args.length == 1 && args[0] instanceof Integer){
            System.out.println("If your num < 100 && instanceof Integer,let num = 100.");
            args[0] = (Integer)args[0] >= 100 ? args[0] : 100;
        }
        //返回结果
        return method.invoke(targetClass,args);
    }
}
