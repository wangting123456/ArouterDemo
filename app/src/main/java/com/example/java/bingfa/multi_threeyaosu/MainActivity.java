package com.example.java.bingfa.multi_threeyaosu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.locks.Lock;

/**
 * 多线程三要素
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.三要素分别是：原子性，可见性，有序性
        //2.什么是线程安全：线程安全就是当多个线程访问一个对象时，如果不用考虑这些线程在运行时环境下的调度和交替执行，
          // 也不需要进行额外的同步，或者在调用方进行任何其他的协调操作，调用这个对象的行为都可以获得
          // 正确的结果，那这个对象是线程安全的。
        //3.如果处理多线程并发：
          //锁和同步(同步方法和同步代码库)

    }

}
