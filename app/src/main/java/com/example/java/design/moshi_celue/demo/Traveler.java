package com.example.java.design.moshi_celue.demo;

/**
 * 第三步:环境类实现
 */
public class Traveler {
    private TravelStrategy travelStrategy;
    public Traveler(){

    }

    /**
     * 设置出行策略
     */
    public void setTravelStrage(TravelStrategy travelStrage){
        travelStrategy = travelStrategy;
    }

    /**
     * 出行
     */
    public void travel(){
        travelStrategy.travelAlgorithm();
    }
}
