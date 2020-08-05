package com.example.java.bianliang;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 基本数据类型存储位置
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.先看一个题目
           //Java中的基本数据类型一定存储在栈中吗？
        //2.答案说明
          //首先说明，"java中的基本数据类型一定存储在栈中的吗？”这句话肯定是错误的。
        //3.局部变量存储位置
           //在方法中声明的变量，就是局部变量
             //a.每当程序调用方法时，系统都会为该方法建立一个方法栈，其所在方法中声明的变量就放在方法栈中，
             //当方法结束系统会释放方法栈，其对应在该方法中声明的变量随着栈的销毁而结束，这就局部变量只能在方法中有效的原因。
             //b.在方法中声明的变量可以是基本类型的变量，也可以是引用类型的变量。
             //c.当声明是基本类型的变量的时，其变量名及值（变量名及值是两个概念）是放在JAVA虚拟机栈中
             //d.当声明的是引用变量时，所声明的变量（该变量实际上是在方法中存储的是内存地址值）是放在JAVA虚拟机的栈中，该变量所指向的对象是放在堆类存中的
        //4.成员变量存储位置
            //在类中声明的变量是成员变量，也叫全局变量
             //a.放在堆中的（因为全局变量不会随着某个方法执行结束而销毁）。
             //b.同样在类中声明的变量即可是基本类型的变量，也可是引用类型的变量。
             //c.当声明的是基本类型的变量其变量名及其值放在堆内存中的

        //5.静态变量存储位置
           //静态变量其实就是常量
           //注意是：存储在JVM的方法区中
           //static变量在类加载时被初始化，存储在JVM的方法区中，整个内存中只有一个static变量的拷贝，
           //可以使用类名直接访问，也可以通过类的实例化对象访问，一般不推荐通过实例化对象访问，通俗的
           //讲static变量属于类，不属于对象，任何实例化的对象访问的都是同一个static变量，任何地放都可以通过类名来访问static变量。
    }
}
