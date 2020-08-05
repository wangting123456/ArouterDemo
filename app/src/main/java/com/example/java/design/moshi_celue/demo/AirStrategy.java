package com.example.java.design.moshi_celue.demo;

/**
 * 第二步:具体策略类 飞机出行
 */
public class AirStrategy implements TravelStrategy{
    @Override
    public void travelAlgorithm() {
        System.out.println("出行坐飞机");
    }
}
