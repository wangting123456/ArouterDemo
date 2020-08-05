package com.example.java.generic;

/**
 * 定义容器类，用来存放K.V,键值对的类型不确定，所以使用泛型
 * @param <K>
 */
public class Conrainer<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
