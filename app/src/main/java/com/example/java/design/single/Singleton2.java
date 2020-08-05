package com.example.java.design.single;

public class Singleton2 {
    //私有构造函数
    private Singleton2(){

    }
    //私有静态对象
    private static Singleton2 singleton2;
    //公有的同步静态方法
    public static synchronized Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    //优点：解决了线程不安全的问题
    //缺点：效率有点低，每次调用实例都要判断同步锁，一般不建议使用
}
