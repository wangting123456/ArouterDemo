package com.example.android.annotation.annotation_detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.什么是注解
             //1.注解分类：
                //标准 Annotatio：java自带的注解
                //元 Annotation：@Retention, @Target, @Inherited, @Documented 也就是当我们要自定义注解时，需要使用它们。
                //自定义 Annotation：根据需要，自定义的Annotation
             //2.自定义注解分类：
                //@Retention(RetentionPolicy.SOURCE)
                   //源码时注解，一般用来作为编译器标记。Override, Deprecated, SuppressWarnings
                //@Retention(RetentionPolicy.RUNTIME)(重点)
                   //运行时注解，在运行时通过反射去识别的注解。retrofit
                //@Retention(RetentionPolicy.CLASS)
                   //编译时注解，在编译时被识别并处理的注解。Dagger2, ButterKnife, EventBus3

        //二.运行注解案例
            //如下 ContentView
            //解释：
                //a.第一行:@Retention(RetentionPolicy.RUNTIME)
                    //@Retention修饰这是一个什么类型的注解。这里表示该注解是一个运行时注解，这样apt就会知道什么时候去处理
                //b.第二行：@Target({ElementType.TYPE})
                    //@Target用来表示这个注解可以使用在哪些地方。这里ElementType.TYPE 表示这个注解可以用来修饰：Class, interface or enum declaration
                    //当你用ContentView修饰一个方式时会报错
                //c.第三行：public @interface ContentView
                    //这里的interface并不是说ContentView是一个接口,就像申明类用class,什么接口用 interface，申请枚举用enum
                    //申请注解用的就是@interface
                //d.第四行：int value();
                    //表示这个注解里面可以存放什么类型的值@ContentView(R.layout.activity_home)
                    //如果@ContentView("122")这样就会报错

        //三.使用注解代替枚举类
           //如下CurrentState
        //四.使用注解限定类型
           //a.枚举最大的优势是提供了类型安全，为了弥补Android不建议使用枚举的关键，
               //官方推出了两个注解@IntDef @StringDef用来提供编译期的类型检查。

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ContentView{
        int value();
    }

    public @interface CurrentState{
        int STATE_ERROR = -1;
        int STATE_IDLE = 0;
        int STATE_PREPARING = 1;
        int STATE_PREPARED = 2;
        int STATE_PLAYING = 3;
        int STATE_PAUSED = 4;
        int STATE_BUFFERING_PLAYING = 5;
        int STATE_BUFFERING_PAUSED = 6;
        int STATE_COMPLETED = 7;
    }
}
