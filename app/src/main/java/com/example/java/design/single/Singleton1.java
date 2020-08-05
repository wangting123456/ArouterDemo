package com.example.java.design.single;

public class Singleton1 {
    //私有构造函数
    private Singleton1(){

    }
    //私有静态变量
    private static Singleton1 singleton1;
    //暴露的公有静态方法
    public static Singleton1 getInstance(){
        if(singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    //优点：延迟加载，需要的时候才去加载
    //缺点：线程不安全，在多线程情况下很容易出现不同步的问题
}
