package com.example.android.net.net_retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Retrofit基本使用
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.关于Retrofit基本介绍
        //a.Retrofit是Sun公司研发的正对Android网络请求的一种框架，底层基于OkHttp 实现，OkHttp 已经得到
        //google官方的认可。
        //b.Retrofit是由Square公司出品的针对于Android和Java类型安全的Http客户端，如果看源码发现本质
        //是对Http的封装，使用面向接口的方式进行网络请求，利用动态代理类封装了网络接口请求的底层
        //其将请求返回JavaBean.对网络认证REST API进行了很友好的支持。使用Retrofit将会极大的提高我们应用的网络体验
        //c.RxJava + Retrofit + okHttp组合，流行的网络请求框架
        //Retrofit负责请求的数据和结果，使用接口的方式呈现。okhttp负责请求的过程，rxjava负责异步。各种线程之间
        //的切换
        //d.为什么要使用Retrofit
        //请求的方法参数可以注解
        //支持同步，异步，rxjava
        //超级解耦
        //可以配置不同的反序列化工具来解耦

        DouBookModel douBookModel = DouBookModel.getInstance();
        douBookModel.getHostMovie("1", "1", 4)
                .subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DouBookBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DouBookBean bookBean) {

                    }
                });


    }

    /**
     * 描述：第一步:定义一个接口配置网络请求
     */
    public interface WeatherService {
        //  网络接口的使用为查询天气的接口
        @GET("weather_mini")
      //  此处回调返回的可为任意类型Call<T>，再也不用自己去解析json数据啦！！！
        Call<WeatherEntity> getMessage(@Query("city") String city);
    }

    /**
     * 单纯使用Retrofit的联网请求
     */
    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherEntity> call = weatherService.getMessage("北京");
        call.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                //测试数据返回
               WeatherEntity weatherEntity = response.body();
                //Log.e("TAG", "response == " + weatherEntity.getData().getGanmao());
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                Log.e("TAG", "Throwable : " + t);
            }
        });
    }

}
