package com.example.java.bingfa.reentrantLock;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ReentrantLock
        //ReentrantLock是互斥锁，提供了一些高级功能：
        //1.等待可中断，持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，
        // 这相当于Synchronized来说可以避免出现死锁的情况。
        //2.2.公平锁，多个线程等待同一个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁非公
        // 平锁，ReentrantLock默认的构造函数是创建的非公平锁，可以通过参数true设为公平锁，
        // 但公平锁表现的性能不是很好。
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.setName("myThread1");
        myThread2.setName("myThread2");
        myThread3.setName("myThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    private ReentrantLock lock = new ReentrantLock();

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            lock.lock();
            try {
                for (int i = 0; i < 3; i++) {
                    Log.d("MyThread", Thread.currentThread().getName() + "  i:" + i);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
