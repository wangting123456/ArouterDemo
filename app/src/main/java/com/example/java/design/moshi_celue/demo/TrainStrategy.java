package com.example.java.design.moshi_celue.demo;

/**
 * 第二步:具体策略类 火车出行
 */
public class TrainStrategy implements TravelStrategy{
    @Override
    public void travelAlgorithm() {
        System.out.println("出行坐火车");
    }
}
