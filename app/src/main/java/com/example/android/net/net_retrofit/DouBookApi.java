package com.example.android.net.net_retrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface DouBookApi {
    /**
     * 根据tag获取图书
     * @param tag  搜索关键字
     * @param count 一次请求的数目 最多100
     *              https://api.douban.com/v2/book/search?tag=文学&start=0&count=30
     */
    @GET("v1/book/search")
    Observable<DouBookBean> getBook(@Query("tag") String tag, @Query("start") String start, @Query("count") int count);


    //@Query() get请求 接上参数; 作用于方法，用于在url后拼接上参数
    @GET("book/search")
    Observable<DouBookBean> getSearchBook(@Query("q") String name);

    // @QueryMap()  get请求 接上参数;作用于方法.用于在url后拼接上参数,参数保存于Map中
    @GET("book/search")
    Observable<DouBookBean> getSearchBook2(@QueryMap Map<String,String> options);

    //@Path()  get请求，替换url中某个字段
    @GET("rank/{id}")
    Observable<DouBookBean> getSearchBook3(@Path("id") String id);

    //@Body()  post请求,指定一个对象作为Http请求体
    @POST("book/search")
    Observable<DouBookBean> getSearchBook4(@Body DouBookBean bean);

    //@Field()  post请求，用于传送表单数据
    @FormUrlEncoded
    @POST("book/search")
    Observable<DouBookBean> getSearchBook5(@Field("name") String name);

    //@FieldMap()  post请求，用于传送表单数据
    @FormUrlEncoded
    @POST("book/search")
    Observable<DouBookBean> getSearchBook6(@FieldMap Map<String,String> map);

    //@Part post请求 用于定义Multipart请求的每和part
     @POST("book/searck")
     @Multipart
     Observable<DouBookBean> getSearchBook7(@Part("des") String des);






}
