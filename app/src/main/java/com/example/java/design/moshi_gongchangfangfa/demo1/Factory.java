package com.example.java.design.moshi_gongchangfangfa.demo1;

/**
 * 第三步:创建一个工厂，生成基于给定信息的实体类的对象
 */
public class Factory {
    public Shape getShape(String shape){
        if(shape == null){
            return null;
        }
        if("circle".equalsIgnoreCase(shape)){
            return new Circle();
        }else if("retangle".equalsIgnoreCase(shape)){
            return new Retangle();
        }else if ("oval".equalsIgnoreCase(shape)){
            return new Oval();
        }
        return null;
    }
}
