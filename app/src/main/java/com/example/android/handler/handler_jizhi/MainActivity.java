package com.example.android.handler.handler_jizhi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.android_handler_jizhi);
        final TextView tvShow = (TextView) findViewById(R.id.tv_show);


        //android中子线程可以更新UI线程的办法
        //主线程定义Handler，子线程里面使用Handler发送消息，主线程的Handler处理消息
        //使用Activity对象的RunOnUiThread
        //创建Handler，传入getMainLooper
        //View.post(Runnable r)

        //第一种 主线程定义Handler，子线程里面使用Handler发送消息，主线程的Handler处理消息
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

        //第二种 使用Activity对象的RunOnUiThread
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvShow.setText("匿名线程");
                    }
                });
            }
        }).start();

        //第三种创建Handler，传入getMainLooper
        new Thread(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvShow.setText("匿名线程");
                    }
                });
            }
        }).start();

        //第四种View.post(Runnable r)
        tvShow.post(new Runnable() {
            @Override
            public void run() {
                tvShow.setText("匿名线程");
            }
        });

    }
}
