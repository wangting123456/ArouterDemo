package com.example.rxjava.rxjava_yuanma;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建操作符 ：创建被观察者（Observable）对象&发送事件
        //转换操作符：变换被观察者(Observable)发送的事件。将Observable发送的数据按照一定的规则做一些变换，然后再将变换的数据发射出去。
                       // 变换的操作符有map,flatMap，concatMap,switchMap,buffer,groupBy等等。
        //合并操作符：组合多个被观察者(Observable)&合并需要发送的事件。包含：concatMap(),concat(), merge(),
                      // mergeArray(),concateArray(),reduce(),collect(),startWith(),zip(),count()
        //功能操作符：辅助被观察者(Observable) 发送事件时实现一些功能性需求，如错误处理，线程调度。
        //过滤操作符：用于将Observable发送的数据进行过滤和选择。让Observable返回我们所需要的数据。
                      //过滤操作符有buffer()，filter()，skip()，take()，skipLast()，takeLast()，throttleFirst()，distainctUntilChange()。

        //创建被观察者:
        //Create：使用Create操作符从头开始创建一个Observable，给这个操作符传递一个接受观察者作为参数的函数，
                                //编写这个函数让它的行为表现为一个Observable--恰当的调用观察者的onNext，onError和onCompleted方法
        //just、fromArray、fromIterable:可以将其它种类的对象和数据类型转换为Observable
        //defer: 直到有观察者订阅时才创建Observable
        //empty、Never、Throw
        //1.创建一个不发射任何数据但是正常终止的Observable
        //2.创建一个不发射数据也不终止的Observable
        //3.创建一个不发射数据以一个错误终止的Observable
        //interval
        //创建一个按固定时间间隔发射整数序列的Observable
        //range(1, 10)
        //创建一个发射特定整数序列的Observable（这里是1到10）
        //timer
        //在一个给定的延迟后发射一个特殊的值
    }
}
