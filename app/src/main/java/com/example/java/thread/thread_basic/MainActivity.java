package com.example.java.thread.thread_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.什么是线程
          //a.在一个进程内部又可以执行多个任务，而这每一个任务我们就可以看成是一个线程。
          //b.线程是程序使用CPU的基本单位。注意：线程是依赖于进程存在的。
        //2.多线程的意义
          //a.提高应用程序的使用率

        //3.并行和并发
          //a.前者是逻辑上同时发生，指在某一个时间内同时运行多个程序。
          //b.后者是物理上同时发生，指在某一个时间点同时运行多个程序。

        //4.JVM启动线程
          //4.1 Java程序运行原理
             //a.java命令会启动java虚拟机，启动JVM，等于启动了一个应用程序，也就是启动了一个进程
             //b.该进程会启动一个主线程，去调用main方法
          //4.2JVM的启动是多线程的吗
            //JVM启动至少启动了垃圾回收线程和主线程，所以是多线程的。
    }
}
