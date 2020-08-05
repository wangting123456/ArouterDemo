package com.example.java.design.moshi_moban.demo;

public class Human extends HumanMode {
    @Override
    public void getUp() {
        System.out.println("张三 getUp");
    }

    @Override
    public void breakfirst() {
        System.out.println("张三 breakfirst");
    }

    @Override
    public void work() {
        System.out.println("张三 work");
    }

    @Override
    public void sleep() {
        System.out.println("张三 sleep");
    }
}
