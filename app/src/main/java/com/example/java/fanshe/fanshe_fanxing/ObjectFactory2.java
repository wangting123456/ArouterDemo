package com.example.java.fanshe.fanshe_fanxing;

public class ObjectFactory2 {
    public static <T> T getInstance(Class<T> cls) {
        try {
            return  cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
