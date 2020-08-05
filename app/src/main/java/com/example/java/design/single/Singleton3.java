package com.example.java.design.single;

public class Singleton3 {
    private Singleton3(){

    }
    //static 修饰的静态变量在内存中一旦创建，会永久存在
    private static Singleton3 singleton3 = new Singleton3();
    public static Singleton3 getInstance(){
        return singleton3;
    }
    //推荐的方法
}
