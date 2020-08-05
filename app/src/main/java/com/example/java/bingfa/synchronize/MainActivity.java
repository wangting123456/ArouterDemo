package com.example.java.bingfa.synchronize;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_bingfa_basic_main);
        //1.Synchronize用法
        //a.当Synchronize修饰一个方法，或者一个代码块时，能保证同一时刻最多只有一个线程执行该代码段
        //b.可以修饰哪些内容
        //修饰一个代码块，其作用的范围是{}括起来的，作用的对象是调用这个代码块的对象
        //修饰一个方法，作用的范围是整个方法，作用的对象是调用这个方法的对象
        //修饰一个静态方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象
        //修饰一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象
        //2.使用
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.setName("myThread1");
        myThread2.setName("myThread2");
        myThread3.setName("myThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();


        MyThread2 MyThread2_1 = new MyThread2();
        MyThread2 MyThread2_2 = new MyThread2();
        MyThread2 MyThread2_3 = new MyThread2();
        MyThread2_1.setName("MyThreadA");
        MyThread2_2.setName("MyThreadB");
        MyThread2_3.setName("MyThreadC");
        MyThread2_1.start();
        MyThread2_2.start();
        MyThread2_3.start();

        //3.区别：
        //sychonized method：会获取对象中所有synchonized的锁，也就是其他线程不能访问所有加了synchonized的方法
        //不仅仅只是当前运行的方法)，影响了其他线程多其他同步方法的访问，降低了效率
        //sychonized 代码块：只对当前代码块加锁，其他的同步方法不受影响
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            synchronized (this){
                for(int i = 0 ; i < 3;i++){
                    Log.d("MyThread",Thread.currentThread().getName()+"  i:"+i);
                }
            }

        }
    }
       /*   04-28 14:39:06.840 27177-27200/com.demo.json D/MyThread: myThread2  i:0
            04-28 14:39:06.840 27177-27200/com.demo.json D/MyThread: myThread1  i:0
            04-28 14:39:06.840 27177-27201/com.demo.json D/MyThread: myThread2  i:1
            04-28 14:39:06.840 27177-27200/com.demo.json D/MyThread: myThread1  i:1
            04-28 14:39:06.840 27177-27201/com.demo.json D/MyThread: myThread2  i:2
            04-28 14:39:06.840 27177-27200/com.demo.json D/MyThread: myThread1  i:2
            04-28 14:39:06.840 27177-27202/com.demo.json D/MyThread: myThread3  i:0
            04-28 14:39:06.840 27177-27202/com.demo.json D/MyThread: myThread3  i:1
            04-28 14:39:06.840 27177-27202/com.demo.json D/MyThread: myThread3  i:2*/

    class MyThread2 extends Thread{
        @Override
        public void run() {
            super.run();
            test();
        }
    }

    private synchronized void test(){
        for(int i = 0 ; i < 3;i++){
            Log.d("MyThreadtest",Thread.currentThread().getName()+"  i:"+i);
        }
    }

    //04-28 14:47:29.990 31481-31504/com.demo.json D/MyThreadtest: MyThreadA  i:0
    //04-28 14:47:29.990 31481-31504/com.demo.json D/MyThreadtest: MyThreadA  i:1
    //04-28 14:47:29.990 31481-31504/com.demo.json D/MyThreadtest: MyThreadA  i:2
    //04-28 14:47:29.990 31481-31505/com.demo.json D/MyThreadtest: MyThreadB  i:0
    //04-28 14:47:29.990 31481-31505/com.demo.json D/MyThreadtest: MyThreadB  i:1
    //04-28 14:47:29.990 31481-31505/com.demo.json D/MyThreadtest: MyThreadB  i:2
    //04-28 14:47:29.990 31481-31506/com.demo.json D/MyThreadtest: MyThreadC  i:0
    //04-28 14:47:29.990 31481-31506/com.demo.json D/MyThreadtest: MyThreadC  i:1
    //04-28 14:47:29.990 31481-31506/com.demo.json D/MyThreadtest: MyThreadC  i:2
}
