package com.example.java.bingfa.threadpool;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池基础介绍
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.实际开发中问题：
           //a.会使用多线程问题，主线程使用有限制，网络请求这些都是放在子线程
           //b.通过new Thread开启一个子线程，子线程操作完以后通过handler转入主线程，这样我们无法管理我
             //们创建的子线程,无限制的创造子线程，他们之间相互竞争，很有可能由于占用过多资源而出现oom
             //所以java中提供了线程池来管理我们所创建的线程

        //2.线程池的优势
          //a.降低系统资源消耗，通过重用已存在的线程，降低线程创建和销毁造成的消耗
          //b.提高系统响应速度，当有任务到达时，无须创建新线程
          //c.方便线程并发数的管控
          //d.线程池提供定时定期可控线程数等功能
        //3.ThreadPoolExecutor
            ThreadPoolExecutor();
        //4.java中四种线程池类
           //都是直接或者间接配置ThreadPoolExecutor来完成各自功能，可以通过Executors获取
           //第三种：newScheduledThreadPool
             newScheduledThreadPool();

    }
    private void ThreadPoolExecutor(){
        //线程池的创建
        ExecutorService service = new ThreadPoolExecutor(5, 10,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        //可以通过execute和submit两种方式来向线程池提交一个任务。
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute方式");
            }
        });
        //线程池的关闭
        service.shutdown();//或者
        service.shutdownNow();
    }

    /**
     * 创建一个可定时执行或周期执行的线程池
     */
    private void newScheduledThreadPool(){
         //通过Executors.newScheduledThreadPool来创建
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        //延迟一定时间后执行Runnable任务；
        service.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },10, TimeUnit.MILLISECONDS);
        //延迟一定时间后，以间隔period时间的频率周期性地执行任务
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {

            }
        },0,10, TimeUnit.MILLISECONDS);
    }
    private void create(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },10, TimeUnit.MILLISECONDS);
    }
}
