package com.example.java.design.moshi_gongchangfangfa.demo2;

public abstract class AbstractFactory {
    public abstract <T extends Human> T createHuman(Class<T> t);
}
