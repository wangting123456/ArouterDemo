package com.example.android.annotation.annotation_detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AdvanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.@Retention
            //a.@Retention(RetentionPolicy.SOURCE):源码注解
            //b.@Retention(RetentionPolicy.RUNNING):运行时注解
            //c.@Retention(RetentionPolicy.CLASS):编译时注解
        //2.@Target(ElementType.TYPE)
            //a.@Target(ElementType.TYPE):类，接口，注解，枚举
            //b.@Target(ElementType.FIELD):字段，枚举的常量
            //c.@Target(ElementType.METHOD):方法
            //d. @Target(ElementType.PARAMETER):方法的参数
            //e.@Target(ElementType.CONSTRUCTOR):构造函数
            //f. @Target(ElementType.LOCAL_VARIABLE):局部变量
            //g.@Target(ElementType.ANNOTATION_TYPE):注解
            //h.@Target(ElementType.package):包
        //3.@Inherited
            //当你的注解(Test)定义到类A上，此时，有个B类继承A，且没使用该注解。但是扫描的时候，会把A类设置的注解，扫描到B类上。
        //4.注解的默认值
            //TestAni
    }

    @Inherited
    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.TYPE)
    public @interface Test {
        //...
    }


    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.TYPE)
    public @interface TestAni{
        int id();//注解参数
        String name() default "zhangsan";

    }

    @TestAni(id = 1) //name 有默认值可以不写
    public class A{

    }
}
