package com.example.java.fanshe.fanshe_use2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 操作成员方法
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.反射调用公有方法
        try {
            Class class2 =  Class.forName("com.example.java.fanshe.fanshe_use2.Teacher");
            //指定构造函数
            Constructor constructor = class2.getDeclaredConstructor(String.class,Integer.TYPE);
            //根据指定的构造函数来获取对象
            Object object = constructor.newInstance("zhangsan",23);

            //指定方法名称来获取对应的公开的Method实例
            Method method = class2.getMethod("getName");
            method.invoke(object);
            //调用了getName方法，Name：zhangsan

            Method method2 = class2.getMethod("getAge");
            method2.invoke(object);

            Method method3 = class2.getMethod("setName", String.class);
            method3.invoke(object,"lisi");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
