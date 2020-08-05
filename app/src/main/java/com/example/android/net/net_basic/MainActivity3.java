package com.example.android.net.net_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * TCP和UDP详细介绍
 */
public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.TCP和UDP的区别
          //1.TCP和UDP的区别
            //①UDP协议：
              //面向无连接
              //每个数据报的大小在限制在64k内
              //因为是面向无连接，所以是不可靠协议
              //不需要建立连接，速度快
            //②TCP协议：
              //必须建立连接，形成传输数据的通道
              //在连接中可进行大数据量传输
              //通过三次握手完成连接，是可靠协议
              //必须建立连接，效率会稍低
           //注：三次握手：
              //第一次：我问你：在么？
              //第二次：你回答：在。
              //第三次：我反馈：哦，我知道你在。

        //二.Socket介绍
          //1.Socket简单介绍
            //Socket就是为网络服务提供的一种机制
            //通信的两端都有Socket
            //网络通信其实就是Socket间的通信
            //数据在两个Socket间通过IO传输
            //玩Socket主要就是记住流程，代码查文档就行
            //Socket的简单使用的话应该都会，两个端各建立一个Socket，服务端的叫ServerSocket，然后建立连接即可。

        //三.UDP协议传输数据

        //四.TCP 协议传输数据

        //五.三次握手建立连接
          //1.三次握手原理图
           //第一次：发送SNY=1表示此次握手是请求建立连接的，然后seq生成一个客户端的随机数X
           //第二次：发送SNY=1,ACK=1表示是回复请求建立连接的，然后ack=客户端的seq+1（这样客户端收到后就能确认是之前想要连接的那个服务端），然后把服务端也生成一个代表自己的随机数seq=Y发给客户端。
           //第三次：ACK=1。 seq=客户端随机数+1，ack=服务端随机数+1（这样服务端就知道是刚刚那个客户端了）
    }
}
