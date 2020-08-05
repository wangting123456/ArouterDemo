package com.example.livedata;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.LiveData 是一个数据持有类
          //a.数据可以被观察者订阅
          //b.能够感知组件的生命周期(Activity ,Fragment,Service)等组件
          //c.只有组件在激活状态才会通知观察者进行数据更新
          //d.组件指的是实现了LifecycleOwner接口Fragment、Activity。

        //二.为什么需要LiveData
          //a.能够保证数据和UI统一：LiveDate采用了观察者模式，LiveData是被观察者，当有数据变化时，会通知UI更新
          //b.减少内存泄漏：因为LiveData能感受组件生命周期，当组件处于销毁状态时，观察者对象会被清除掉
                             //当Activity停止时不会引起崩溃：组件处于非激活状态，不会收到LivaData中数据变化的通知
                             //组件和数据相关的内容能时时更新
          //c.针对configuration change时:不需要额外的处理来保存数据我们知道，当你把数据存储在组件中时，当configuration change（比如语言、屏幕方向变化）时，组件会被recreate，
              // 然而系统并不能保证你的数据能够被恢复的。当我们采用LiveData保存数据时，因为数据和组件分离了。
              // 当组件被recreate，数据还是存在LiveData中，并不会被销毁。
          //d.资源共享：通过继承LiveData类，然后将该类定义成单例模式，在该类封装监听一些系统属性变化，
                     // 然后通知LiveData的观察者，这个在继承LiveData中会看到具体的例子。


        //三.LiveData使用

        //四.LiveData源码分析


    }
}
