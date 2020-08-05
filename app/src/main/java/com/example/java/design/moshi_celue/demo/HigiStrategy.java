package com.example.java.design.moshi_celue.demo;

/**
 * 第二步:具体策略类 高铁出行
 */
public class HigiStrategy implements TravelStrategy{
    @Override
    public void travelAlgorithm() {
        System.out.println("出行坐高铁");
    }
}
