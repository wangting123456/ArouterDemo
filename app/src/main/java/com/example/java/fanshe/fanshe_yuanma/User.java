package com.example.java.fanshe.fanshe_yuanma;

import android.util.Log;

public class User {
    private String name;
    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        Log.d("Teacher","调用了getName方法，Name：" + name);
        System.out.println("调用了getName方法，Name：" + name);
        return name;
    }

    public int getAge() {
        Log.d("Teacher","调用了getAge方法，Age：" + age);
        System.out.println("调用了getAge方法，Age：" + age);
        return age;
    }

    private void setName(String name) {
        this.name = name;
        Log.d("Teacher","调用了setName方法，name：" + name);
        System.out.println("调用了setName方法,name:" + name);
    }

    private void setAge(int age) {
        this.age = age;
        Log.d("Teacher","调用了setAge方法，age：" + age);
        System.out.println("调用了setAge方法，age:" + age);
    }
}
