package com.example.java.thread.thread_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadCreateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.创建线程子类
        MyThread myThread = new MyThread();
        myThread.start();

        //2.通过Runnable接口创建线程类
        Thread thread = new Thread(new MyRunnable());
        thread.start();

    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }

    class MyRunnable implements Runnable{
        @Override
        public void run() {

        }
    }
}
