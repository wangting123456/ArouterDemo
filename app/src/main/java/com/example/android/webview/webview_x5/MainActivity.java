package com.example.android.webview.webview_x5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    private X5WebView x5web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_webview_x5web);
        //使用的x5内核，加载速度变很快
        //X5内核是腾讯基于WebKit开源，深度优化的浏览器渲染引擎，搭载在最新一代的手机QQ浏览器上 [2]  ，更快，更便捷。
        //微信、手机QQ、新浪新闻、凤凰新闻、搜狐视频、京东等各类共30多款知名APP成为首批受益者
        x5web = (X5WebView)findViewById(R.id.webView);
        x5web.loadUrl("http://baidu.com");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        x5web.destroy();
    }
}
