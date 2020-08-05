package com.example.rxjava.rxjava_normal;

import com.example.android.net.net_retrofit.DouBookBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestApi {
    //@Field()  post请求，用于传送表单数据
    @FormUrlEncoded
    @POST("book/search")
    Observable<MoiveBean> getMoive(@Field("name") String name);

    @FormUrlEncoded
    @POST("book/search/name")
    Observable<String> getSearch(@Field("name") String name);

    @FormUrlEncoded
    @POST("book/search/name")
    Observable<String> register(@Field("username") String username);

    @FormUrlEncoded
    @POST("book/search/name")
    Observable<String> login(@Field("username") String username);
}
