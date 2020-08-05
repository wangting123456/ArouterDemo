package com.example.android.youhua.youhua_oom;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private TextView tvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_youhua_oom_main);
        tvShow = (TextView) findViewById(R.id.tv_show);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟内存泄漏
                tvShow.setText("12212");
            }
        },3000);

       /* 造成内存泄漏原因分析
        上述代码通过内部类的方式创建mHandler对象,此时mHandler会隐式地持有一个外部类对象引用这里就是MainActivity，
        当执行postDelayed方法时，该方法会将你的Handler装入一个Message，并把这条Message推到MessageQueue中，
        MessageQueue是在一个Looper线程中不断轮询处理消息，那么当这个Activity退出时消息队列中还有未处理的消息或者正在处理消息，
        而消息队列中的Message持有mHandler实例的引用，mHandler又持有Activity的引用，
        所以导致该Activity的内存资源无法及时回收，引发内存泄漏。*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解决办法第一种
        if(mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }
}
