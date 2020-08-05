package com.example.android.ipc.ipc_introduce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //进程间通信
       /* 1.Intent
         Activity，Service，Receiver 都支持在 Intent 中传递 Bundle 数据，而 Bundle 实现了 Parcelable 接口，可以在不同的进程间进行传输。
        在一个进程中启动了另一个进程的 Activity，Service 和 Receiver ，可以在 Bundle 中附加要传递的数据通过 Intent 发送出去。*/
       //2.使用文件
       /* 3.使用Messenger
        Messenger 是以串行的方式处理客户端发来的消息，如果大量消息同时发送到服务端，服务端只能一个一个处理，所以大量并发请求就不适合用Messenger，而且Messenger只适合传递消息，不能跨进程调用服务端的方法。
        AIDL 可以解决并发和跨进程调用方法的问题，要知道Messenger本质上也是AIDL，只不过系统做了封装方便上层的调用而已*/
    }
}
