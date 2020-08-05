package com.example.rxjava.rxjava_yuanma;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static java.lang.Thread.sleep;

public class IndexActivity extends AppCompatActivity {
    private String TAG = IndexActivity.class.getSimpleName();
    private Disposable mDisposable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Observable中文意思就是被观察者，通过create方法生成对象，里面放的参数ObservableOnSubscribe<T>，
         * 可以理解为一个计划表，泛型T是要操作对象的类型，重写subscribe方法，里面写具体的计划，本文的例子就是推送连载1、
         * 连载2和连载3，在subscribe中的ObservableEmitter<String>对象的Emitter是发射器的意思。ObservableEmitter有三种发
         * 射的方法，分别是void onNext(T value)、void onError(Throwable error)、void onComplete()，onNext方法可以无限调用，
         * Observer（观察者）所有的都能接收到，onError和onComplete是互斥的，Observer（观察者）只能接收到一个，OnComplete可
         * 以重复调用，但是Observer（观察者）只会接收一次，而onError不可以重复调用，第二次调用就会报异常。
         *
         */
        Observable novel=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });

        /**
         * 通过new创建接口，并实现其内部的方法，看方法其实就应该差不多知道干嘛的，onNext、onError、
         * onComplete都是跟被观察者发射的方法一一对应的，这里就相当于接收了。onSubscribe（Disposable d）
         * 里面的Disposable对象要说一下，Disposable英文意思是可随意使用的，这里就相当于读者和连载小说的
         * 订阅关系，如果读者不想再订阅该小说了，可以调用 mDisposable.dispose()取消订阅，此时连载小说更
         * 新的时候就不会再推送给读者了。
         *
         */
        Observer<String> reader=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable=d;
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)){
                    mDisposable.dispose();
                    return;
                }
                Log.e(TAG,"onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError="+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()");
            }
        };
        novel.subscribe(reader);//一行代码搞定
        /**
         * RxJava2.0的异步和链式编程
         * 前言里面有提到，RxJava是支持异步的，但是RxJava是如何做到的呢？这里就需要Scheduler。Scheduler，
         * 英文名调度器，它是RxJava用来控制线程。当我们没有设置的时候，RxJava遵循哪个线程产生就在哪个线程消
         * 费的原则，也就是说线程不会产生变化，始终在同一个。然后我们一般使用RxJava都是后台执行，前台调用，
         * 本着这个原则，我们需要调用observeOn(AndroidSchedulers.mainThread())，observeOn是事件回调的线程，
         * AndroidSchedulers.mainThread()一看就知道是主线程，subscribeOn(Schedulers.io())，subscribeOn是事件
         * 执行的线程，Schedulers.io()是子线程，这里也可以用Schedulers.newThread()，只不过io线程可以重用空闲的线程
         * ，因此多数情况下 io() 比 newThread() 更有效率。
         */

        /**
         * subscribe的方法重载
         */

        /**
         * 应用场景
         * 与Retrofit联用
         * Rxpermissions等类库的使用
         * 所有用到异步的地方
         */
    }

    private void demo(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(123);
                sleep(3000);
                emitter.onNext(456);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG,integer+"onnext");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG,"error");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG,"complete");
                    }
                });
    }

    private int[] drawableRes;
    private void demo2(){
        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(ObservableEmitter<Drawable> emitter) throws Exception {
                for (int i=0;i<drawableRes.length;i++){
                    Drawable drawable=getResources().getDrawable(drawableRes[i]);
                    //第6个图片延时3秒后架子
                    if (i==5){
                        sleep(3000);
                    }
                    //复制第7张图片到sd卡
                    if (i==6){
                        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
                        //saveBitmap(bitmap,"test.png", Bitmap.CompressFormat.PNG);
                    }
                    //上传到网络
                    if (i==7){
                        //updateIcon(drawable);
                    }
                    emitter.onNext(drawable);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Drawable>() {
                    @Override
                    public void accept(Drawable drawable) throws Exception {
                        //回调后在UI界面上展示出来
                    }
                });
    }
}
