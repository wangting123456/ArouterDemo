package com.example.java.generic;

import android.util.Log;

public class InterTestImpl<T> implements InterTest<T>{
    private String TAG = InterTestImpl.class.getSimpleName();
    @Override
    public void show(T t) {
        Log.d(TAG,"t");
    }
}
