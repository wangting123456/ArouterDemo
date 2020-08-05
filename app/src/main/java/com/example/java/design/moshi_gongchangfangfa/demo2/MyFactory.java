package com.example.java.design.moshi_gongchangfangfa.demo2;

public class MyFactory extends AbstractFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> t) {
        Human human = null;
        try {
             human = (Human) Class.forName(t.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)human;
    }
}
