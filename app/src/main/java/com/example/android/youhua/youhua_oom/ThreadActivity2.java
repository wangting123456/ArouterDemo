package com.example.android.youhua.youhua_oom;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class ThreadActivity2 extends AppCompatActivity {
    private static String TAG = ThreadActivity2.class.getSimpleName();
    private boolean bThreadSwitch = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MyThread().start();
        //boolean 变量控制线程的开启和停止
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (bThreadSwitch) {
                Log.d(TAG, "11111");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bThreadSwitch = false;
    }
}
