package com.example.android.youhua.youhua_oom;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class ThreadActivity extends AppCompatActivity {
    private static String TAG = ThreadActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MyThread(this).start();
    }

    private static class MyThread extends Thread{
        private WeakReference<Context> mContext;
        public MyThread(Context context){
            mContext = new WeakReference<>(context);
        }
        @Override
        public void run() {
            super.run();
            if(mContext != null && mContext.get() != null){
                //TODO
                while (true){
                    Log.d(TAG,"11111");
                }
            }
        }
    }
}
