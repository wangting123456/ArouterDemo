package com.example.java.bingfa.multi_thread_bingfa;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 多线程并发案例
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.多线程并发案例
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.setName("1");
        myThread2.setName("2");
        myThread3.setName("3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        //2.线程安全问题的产生原因
            //a.多线程运行，共享数据，有多条语句操作共享数据
            //b.把多个语句操作共享数据的代码给锁起来，让任意时刻只能有一个线程执行即可。
        //3.同步代码块解决线程安全问题
            //该对象如同锁
            //同步的好处:同步的出现解决了多线程的安全问题。
            //同步的弊端:当线程相当多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，
                         // 无形中会降低程序的运行效率。
        synchronized (this){
            //共享数据的操作
        }
    }
   public class MyThread extends Thread{
        private  int num = 100;
        @Override
        public void run() {
            super.run();
            while (true){
                if(num > 0){
                    try {
                        Thread.sleep(100);
                        Log.d("MyThread",Thread.currentThread().getName()+""+(num --));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
