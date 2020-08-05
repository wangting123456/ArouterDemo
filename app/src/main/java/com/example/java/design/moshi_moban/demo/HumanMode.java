package com.example.java.design.moshi_moban.demo;

public abstract class HumanMode {
    public abstract void getUp();
    public abstract void breakfirst();
    public abstract void work();
    public abstract void sleep();
    public final void lifeday(){
        getUp();
        breakfirst();
        work();
        sleep();
    }
}
