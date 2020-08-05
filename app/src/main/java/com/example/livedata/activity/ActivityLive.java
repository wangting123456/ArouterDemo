package com.example.livedata.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;

public class ActivityLive extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        MainViewModel mainViewModel =  ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getUser().setValue(new User("Acitivity",1));
        mainViewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                User user = (User)o;
                user.getAge();
                user.getName();
            }
        });
      /*  LiveData: 是一个可以感知 Activity 、Fragment生命周期的数据容器。
         当 LiveData 所持有的数据改变时，它会通知相应的界面代码进行更新。
        同时，androidx.lifecycle.LiveData 持有界面代码 Lifecycle 的引用，
        这意味着它会在界面代码（LifecycleOwner）的生命周期处于 started 或 resumed 时作出相应更新，
        而在 LifecycleOwner 被销毁时停止更新。
        LiveData的优点：不用手动控制生命周期，不用担心内存泄露，数据变化时会收到通知。*/
       /* ViewModel 将视图的数据和逻辑从具有生命周期特性的实体（如 Activity 和 Fragment）中剥离开来。
       直到关联的 Activity 或 Fragment 完全销毁时，ViewModel 才会随之消失
       ，也就是说，即使在旋转屏幕导致 Fragment 被重新创建等事件中，视图数据依旧会被保留。
       ViewModels 不仅消除了常见的生命周期问题，而且可以帮助构建更为模块化、更方便测试的用户界面。

        ViewModel的优点也很明显，为Activity 、Fragment存储数据，直到完全销毁。
        尤其是屏幕旋转的场景，常用的方法都是通过onSaveInstanceState()保存数据，再在onCreate()中恢复，真的是很麻烦。
        其次因为ViewModel存储了数据，所以ViewModel可以在当前Activity的Fragment中实现数据共享。
        那么LiveData与ViewModel的组合使用可以说是双剑合璧，而Lifecycles贯穿其中。*/




    }
}
