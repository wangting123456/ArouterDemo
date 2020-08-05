package com.example.android.view_dispatch.view_dispatch_zongjie;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //事件分发从Activity -> ViewGroup ->View 从上到下ondispatchTouchEvent事件；从下往上调用onTouchEvent()
        //Activity：ondispatchTouchEvent OnTouchEvent
        //ViewGroup：ondispatchTouchEvent onInterceptTouchEvent OnTouchEvent
        //View：ondispatchTouchEvent OnTouchEvent
    }
}
