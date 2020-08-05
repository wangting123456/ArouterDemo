package com.example.java.design.moshi_gongchangfangfa;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java.design.moshi_gongchangfangfa.demo1.Factory;
import com.example.java.design.moshi_gongchangfangfa.demo1.Shape;
import com.example.java.design.moshi_gongchangfangfa.demo2.AbstractFactory;
import com.example.java.design.moshi_gongchangfangfa.demo2.BalckHuman;
import com.example.java.design.moshi_gongchangfangfa.demo2.Human;
import com.example.java.design.moshi_gongchangfangfa.demo2.MyFactory;
import com.example.java.design.moshi_gongchangfangfa.demo2.WhiteHuman;

/**
 * 工厂方法模式
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.什么是工厂方法模式
          //定义一个用户创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到子类
        //2.工厂方法模式实现
          //通过一个简易计算器来实现工厂方法模式

        //使用工厂方法模型
        //通过传递类型信息，来获取实体类的对象
        Factory factory = new Factory();
        Shape shape = factory.getShape("oval");
        Shape retangle = factory.getShape("retangle");
        shape.draw();
        retangle.draw();

        AbstractFactory abstractFactory = new MyFactory();
        Human white = abstractFactory.createHuman(WhiteHuman.class);
        Human black = abstractFactory.createHuman(BalckHuman.class);
        white.say();
        black.say();

    }
}
