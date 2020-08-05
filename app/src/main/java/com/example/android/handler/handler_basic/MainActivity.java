package com.example.android.handler.handler_basic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private TextView tvShow;
    private Looper mLooper;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Toast.makeText(MainActivity.this, "接收到Handler的消息", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_handler_basic);

        //1.Handler 常见使用方式
        tvShow = (TextView) findViewById(R.id.tv_show);
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //子线程中发送异步消息
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });


        //2.在子线程中使用Handler
        /*发现子线程中定义Handler对象出错，难道Handler的定义和初始化只能在主线程之中？答案不是这样的。
          在初始化Handler之前应该调用Looper.prepare
         */
        /*Handler的工作依赖于Looper,而Looper与消息队列又属于某一个线程。其他线程不能访问，因此Handler就是
         与其他线程绑定在一起，因此要使用Handler，必须保证Handler所创建的线程必须有Looper，并且已经启动循环，
         因为子线程中默认是没有Looper的，所以就报错了
        */
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Handler mHandler = new Handler() {
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                if (msg.what == 1) {
                                    Log.i(TAG, "在子线程中定义Handler，接收并处理消息");
                                }
                            }
                        };
                    }
                }).start();
            }
        });

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Handler mHandler = new Handler() {
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                if (msg.what == 1) {
                                    Log.i(TAG, "在子线程中定义Handler，接收并处理消息");
                                }
                            }
                        };
                    }
                }).start();
                //获取Looper对象
                mLooper = Looper.myLooper();
                Looper.loop();
                //在适当的时候退出消息循环，防止内存泄漏
                mLooper.quit();
            }
        });


        //3.Handler的post方法和View的post方法
        mHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        //View的post方法，其实发现其调用的就是activity中默认保存的handler的post方法
        tvShow.post(new Runnable() {
            @Override
            public void run() {

            }
        });


        //4.避免子线程手动创建Looper
        /**
         * 下面这种方式是非常危险的
         * 在子线程中如果手动创建Looper,那么在所有的事情结束以后，应该调用quit方法终止消息循环，否则子线程一直
         * 处于等待状态。而如果quit，这个线程就会立马结束
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler mHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 1) {
                            Log.d(TAG, "在子线程中初始化Handler并接收消息");
                        }
                    }
                };
                Looper.loop();
                //Looper.myLooper().quit(); 事情处理完应该被调用
            }
        }).start();


        //5.解决Handler内存泄露
        //问题代码
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟内存泄露
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 2000);
            }
        });
        /* a.有延迟消息，需要在Activity销毁的时候，清楚Message
           b.匿名内部类导致的内存泄漏，改为匿名静态内部类，并且对上下文或者Activity使用弱引用
        */
        /*造成内存泄漏原因分析:
          上述代码通过内部类的方式创建mHandler对象,此时mHandler会隐式地持有一个外部类对象引用这里就是MainActivity，
          当执行postDelayed方法时，该方法会将你的Handler装入一个Message，并把这条Message推到MessageQueue中，
          MessageQueue是在一个Looper线程中不断轮询处理消息，那么当这个Activity退出时消息队列中还有未处理的消息或者正在处理消息，
          而消息队列中的Message持有mHandler实例的引用，
          mHandler又持有Activity的引用，所以导致该Activity的内存资源无法及时回收，引发内存泄漏
         */
          //解决方法1
          //在Activity退出的时候移除消息队列中所有的消息和Runnable
          //解决方法2
          //使用静态内部类+若引用解决内存泄漏，将Handler生命为静态的内部类，前面说过，静态内部类不会持有外部类的引用
          //而静态对象则只会持有当前类的弱引用。声明为静态后，handler将会持有一个Activity的弱引用，而弱引用会很容易被gc回收，
          // 这样就能解决Activity结束后，gc却无法回收的情况。

          innerClass.postDelayed(sRunnable,3000);


    }
//弱引用
//File IO流
//动画
//自定义View
    private Handler handler = new Handler();
    private InnerClass innerClass = new InnerClass(this);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(handler != null){
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
    }



    //静态的匿名内部类不会持有外部类的引用
    private static final Runnable sRunnable = new Runnable(){
        @Override
        public void run(){

            //...
        }
    };
    //声明一个静态的Handler内部类，并持有外部类的弱引用
    private static class InnerClass extends Handler{
        private WeakReference<MainActivity> mActivity;
        public InnerClass(MainActivity mainActivity){
            mActivity = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity activity =  mActivity.get();
           if(activity != null){

           }
        }
    }


}
