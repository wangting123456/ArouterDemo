package com.example.rxjava.rxjava_normal;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NetRequestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     * 发送网络注册的接口
     */
    private void register(String username) {
        MoiveModel moiveModel = MoiveModel.getInstance();
        moiveModel.register(username)
                .subscribeOn(Schedulers.io()) //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())//回到主线程去处理请求结果
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //注册成功。调用登陆接口
                        login();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //注册失败
                    }
                });
    }

    private void login() {
        MoiveModel moiveModel = MoiveModel.getInstance();
        moiveModel.login()
                .subscribeOn(Schedulers.io()) //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())//回到主线程去处理请求结果
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //登陆成功。调用登陆接口
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //登陆失败
                    }
                });
    }


    /**
     * 网络请求嵌套
     */
    private void netRequestQiantao() {
        MoiveModel moiveModel = MoiveModel.getInstance();
        Observable<String> observable1 = moiveModel.register("zhangsan");
        final Observable<String> observable2 = moiveModel.login();
        observable1.subscribeOn(Schedulers.io()) //（初始被观察者）切换到IO线程进行网络请求1
                .observeOn(AndroidSchedulers.mainThread())//（新观察者）切换到主线程 处理网络请求1的结果
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //第一次网络请求成功
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
                        return observable2;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
    }

    /**
     * 网络请求合并
     */
    private void netRequestHebing() {
        MoiveModel moiveModel = MoiveModel.getInstance();
        Observable<String> observable1 = moiveModel.register("zhangsan");
        Observable<String> observable2 = moiveModel.login();
        Observable.zip(observable1, observable2, new BiFunction<String, String, Object>() {
            @Override
            public Object apply(String s, String s2) throws Exception {
                return s+s2;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        //请求成功
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //请求失败
                    }
                });
    }

    private void interval(){
        //doOnNext 每得到数据之前进行一次网络请求
        //每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）
		//	  * 即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
        Observable.interval(2,1, TimeUnit.MILLISECONDS)

                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        MoiveModel moiveModel = MoiveModel.getInstance();
                        Observable<String> observable1 = moiveModel.register("zhangsan");
                        observable1
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {

                            }
                        });
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {
                      //每隔一秒得到一个Long 值
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 有条件网络请求轮询
     */
    private int i = 0;
    private void repeat(){
        MoiveModel moiveModel = MoiveModel.getInstance();
        Observable<String> observable1 = moiveModel.register("zhangsan");
        observable1.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                // 加入判断条件：当轮询次数 = 5次后，就停止轮询
                i = i+1;
                if (i > 3) {
                    // 此处选择发送onError事件以结束轮询，因为可触发下游观察者的onError（）方法回调
                    return Observable.error(new Throwable("轮询结束"));
                }
                // 若轮询次数＜4次，则发送1Next事件以继续轮询
                // 注：此处加入了delay操作符，作用 = 延迟一段时间发送（此处设置 = 2s），以实现轮询间间隔设置
                return Observable.just(1).delay(2000, TimeUnit.MILLISECONDS);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
    }

    private String memcache = null;//内存中的网络数据
    private String diskcache = null;//磁盘缓存
    /**
     * 从本地内存网络获取数据
     */
    private void getDataFromLocal(){
        Observable observable1 =  Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                if(memcache != null){
                    e.onNext(memcache);
                }else {
                    e.onComplete();;
                }
            }
        });
        Observable observable2 = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                if(diskcache != null){
                    e.onNext(diskcache);
                }else {
                    e.onComplete();
                }
            }
        });

        Observable observable3 = Observable.just("从网络中获取");
        Observable.concat(observable1,observable2,observable3)
                .firstElement()
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                });

    }



}
