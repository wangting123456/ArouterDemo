package com.example.android.net.net_retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Subscriber;

/**
 * retrofit源码分析
 */
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public interface WeatherService{
        @GET("weather_mini")
        //此处回调返回的可为任意类型Call<T>，再也不用自己去解析json数据啦！！！
        Call<WeatherEntity> getMessage(@Query("city") String city);

    }
    public interface RxWeatherService{

        @GET("weather_mini")
        Observable<WeatherEntity> getMessage2(@Query("city") String city);
    }

    /**
     * 单纯使用Retrofit的联网请求
     */
    private void retrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("baseurl")//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .build();
        WeatherService weatherService = retrofit.create(WeatherService .class);
        Call<WeatherEntity> call = weatherService.getMessage("北京");
        call.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                //测试数据返回
                WeatherEntity weatherEntity = response.body();
                //Log.e("TAG", "response == " +  weatherEntity.getData().getGanmao());
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                Log.d("TAG", "Throwable : " + t);
            }
        });
    }

    /**
     * Retrofit+Rxjava
     */
    private void retrofit_rxjava(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("baseurl")//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build();
        RxWeatherService rxjavaService = retrofit.create(RxWeatherService .class);
        rxjavaService.getMessage2("北京")
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<WeatherEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("TAG", "onSubscribe : ");
                    }

                    @Override
                    public void onNext(WeatherEntity value) {
                        Log.d("TAG", "onNext : ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "onError : ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "onComplete : ");
                    }
                });
    }
}
