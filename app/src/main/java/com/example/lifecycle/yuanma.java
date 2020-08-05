package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class yuanma extends AppCompatActivity {
    private String TAG = "yuanma";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.为什么要引进 lifecycle
           //mvp:每一次在 Activity 或者 Fragment 销毁的烧开后都要调用 presenter.destory() 方法，这样的代码枯燥，毫无意义。
        //2.Lifycycle 的基本使用
            //26.1.0 以后的版本 AppCompatActivity 实现了LifecycleOwner
           getLifecycle().addObserver(new GenericLifecycleObserver() {
               @Override
               public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                   //当 Activity 的生命周期变化的时候，将会回调 onStateChanged 的方法，状态分别是一一对应的
                   Log.d(TAG, "onStateChanged: event =" + event);
               }
           });
           //3. 当 Activity 生命周期变化的时候，MediaCompoment 自身能够检测到 Activity 的 生命周期变化，从而做相应的处理。
           MediaCompoment mediaCompoment = new MediaCompoment(this);
    }
}
