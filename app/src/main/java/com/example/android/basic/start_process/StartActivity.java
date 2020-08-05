package com.example.android.basic.start_process;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    //startActivity是具体怎么一步步启动另外一个Activity;同时包括两个进程间的Activity启动
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }
}
