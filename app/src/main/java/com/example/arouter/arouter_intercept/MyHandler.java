package com.example.arouter.arouter_intercept;


import android.os.Handler;
import android.os.Looper;

public class MyHandler extends Handler {
    private static MyHandler handler = new MyHandler(Looper.getMainLooper());

    public static MyHandler getInstance() {
        return handler;
    }

    public MyHandler(Looper looper) {
        super(looper);
    }

    public static void runOnUiThread(Runnable runnable) {
        if(Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            handler.post(runnable);
        }

    }
}
