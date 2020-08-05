package com.example.android.window.window_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Window View 子Window
          //a.弹窗有哪些类型：
               //使用子窗口：PopWindow或者Dialog,条件是宿主程序必须可见
               //采用View系统：SnackBar
               //采用系统窗口：Toast
        //2.什么是Activity
          //a.Activity并不负责试图控制，它只控制生命周期和处理事件，真正控制试图的是Window,一个Activity
              //包含了一个Window,Window才是真正代表一个窗口
          //b.Activity就像一个控制器，统筹试图的添加和显示，以及其他回调方法，来和window，view进行互动
        //3.什么是Window
          //Window是试图的承载器，自己拥有DecorView，而DecorView是View的跟布局
        //4.什么是DecorView
          //DecorView是FrameLayout的子类，它可以被认为是Android视图树的根节点视图
    }
}
