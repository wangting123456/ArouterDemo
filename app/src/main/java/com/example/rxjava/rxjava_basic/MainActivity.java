package com.example.rxjava.rxjava_basic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends Activity {
    private String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG,"subscribe");
                Log.d(TAG,"currentThread name:"+Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        Observer<Integer>  observer =  new Observer<Integer>(){
            @Override
            public void onSubscribe(Disposable d) {
              Log.d(TAG,"onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
              Log.d(TAG,"onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
              Log.d(TAG,"onError:"+e.getMessage());
            }

            @Override
            public void onComplete() {
              Log.d(TAG,"onComplete");
            }
        };
        observable.subscribe(observer);

       //输出结果
       //onSubscribe
        //subscribe
        //currentThread name: main
        //onNext: 1
        //onNext: 2
        //onNext: 3
        //onComplete

        /*observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread());*/

          //RxJava调度/切换
          //a.主要作用：指定被观察者(Observable)/观察者(Observer)工作线程类型
          //b.为什么要进行线程调度：若被观察者/观察者在主线程被创建，那么他们的工作(生产事件/接收&响应事件)就会发生在主线程
                 //因为创建被观察者/观察者的线程的线程 = 主线程
                 //生产事件/接收&响应事件)就会发生在主线程
          //c.冲突：
            //对于一般的需求场景，需要在子线程中实现耗时操作，然会回到主线程实现UI操作
            //应用到RxJava模型中，可以理解为：被观察者Observable 在子线程中生产事件（如实现耗时操作等等）
            //观察者Observer在主线程接收&响应事件即实现UI操作）
          //d.解决方案：
            //为了解决上述冲突，即实现真正的异步操作，我们需要对RxJava实现线程的调度。
            //采用RxJava内部的调度器Scheduler ，通过功能性操作符subscribeOn（） & observeOn（）实现
          //e.如何调用代码
              //Observer(观察者)的onSubscribe()方法运行在当前线程中
              //Observable(被观察者)中的subscribe()运行在subscribeOn()指定的线程中
               //Observer（观察者）的onNext()和onComplete()等方法运行在observeOn()指定的线程中。
               //线程控制（也称为调度 / 切换），即讲解功能性操作符中的：subscribeOn（） & observeOn（）
               //功能性操作符subscribeOn（） & observeOn（）作用
              //线程控制，即指定 被观察者 （Observable） / 观察者（Observer） 的工作线程类型
              //observable
             // 1. 指定被观察者 生产事件的线程
             //    .subscribeOn(Schedulers.io())
             // 2. 指定观察者 接收 & 响应事件的线程
             //    .observeOn(AndroidSchedulers.mainThread())


    }
}
