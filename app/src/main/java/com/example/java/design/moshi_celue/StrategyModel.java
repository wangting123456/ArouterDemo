package com.example.java.design.moshi_celue;

public class StrategyModel {
    private Strategy strategy;
    public StrategyModel(Strategy strategy){
        this.strategy = strategy;
    }
    public void algrouth(){
        if(strategy != null){
            strategy.AlgrouthInterface();
        }
    }
}
