package com.example.java.design.moshi_gongchangfangfa.demo1;

/**
 * 第二步:创建实现接口的实体类
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
