package com.example.java.thread.thread_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadControlActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.线程调度
            //a.线程调度问题
               //应用程序在执行程序的时候依赖于线程去抢占cpu的时间片
            //b.线程有两种调度模型
               //分时调度模型：所有线程轮流使用CPU的使用权
               //抢占式调度模型：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个，
                  // 优先级高的线程获取的 CPU 时间片相对多一些。Java使用的是抢占式调度模型

        //2.线程控制
           //1.sleep
            //a.sleep():作用
              //1.在指定的毫米内，让当前正在执行的线程休息。
              //2.让其他线程继续有机会执行，但这并不释放对象锁。也就是如果有Synchronized同步块，其他线程仍然不能访问共享数据
            //b.sleep()如何让低优先级线程执行
              //但当高优先级的线程sleep(5000)后，低优先级就有机会执行了。
            //c.sleep(0)的作用
              //由于java采用抢占式的线程调度算法，因此可能会出现某条线程常常获取到CPU控制权的情况，为了
              //让某些优先级比较低的线程也能获取到CPU控制权，可以使用Thread.sleep(0)手动触发一次操作系统分配时间片的操作

           //2.join
             //a.join:等待该线程执行完毕以后，其他线程才能执行
             //b.作用：t1.start();
                      //t1.join();
                      //t2.start();
                  //先启动t1，直到t1结束，才开始执行t2

           //3.yield
              //a.礼让线程yield：暂停当前正在执行的线程对象，并执行其他线程
              //b.线程礼让原理：暂停当前线程，让cpu去执行其他线程，个暂定的时间是相当短暂的;当我某一
                  //个线程暂定完毕以后,其他的线程还没有抢占到cpu的执行权 ;那么这个是时候当前的线程会
                  //和其他的线程再次抢占cpu的执行权
           //4.setDaemon
             //a.设置为守护线程：该方法必须在启动线程前调用
             //b.jvm会线程程序中存在的线程类型,如果线程全部是守护线程,那么jvm就停止。
           //5.线程控制之终端
             //a.stop():停止线程的运行
             //b.interrupt()：当线程调用wait(),sleep(long time)方法的时候处于阻塞状态,可以通过这个方法清除阻塞
           //6.start()开启线程

        //3.wait和sleep的区别
           //a.等待时wait会释放锁，而sleep一直持有锁
           //b.sleep来自Thread类，和wait来自Object类

        //4.结束线程
           //线程对象属于一次性消耗品，如果线程执行到run完毕，线程就正常结束，结束后的线程就报废了
           //不能再次start，只能新建一个线程对象
           //a.使用退出标志终止线程
           //b.使用interrupt()终止线程
    }

    class ThreadSafe extends Thread{
        @Override
        public void run() {
            super.run();
            while (!isInterrupted()){//非阻塞过程中通过判断中断标志来退出
                try {
                    Thread.sleep(5000);//阻塞过程捕获中断异常来退出
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;//捕获到异常之后，执行break跳出循环。
                }
            }
        }
    }

}
