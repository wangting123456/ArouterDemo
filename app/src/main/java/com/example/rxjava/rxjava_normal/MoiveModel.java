package com.example.rxjava.rxjava_normal;

import com.example.android.net.net_retrofit.RetrofitWrapper;

import io.reactivex.Observable;


public class MoiveModel {
    private static MoiveModel moiveModel;
    private RequestApi requestApi;
    public static MoiveModel getInstance(){
        if(moiveModel == null){
            moiveModel = new MoiveModel();
        }
        return moiveModel;
    }

    public MoiveModel(){
        requestApi =  RetrofitWrapper.getInstance("httP:baidu").create(RequestApi.class);
    }

    public Observable<MoiveBean> getMoive(String name){
        Observable<MoiveBean>  observable = requestApi.getMoive(name);
        return observable;
    }

    public Observable<String> getSearch(String name){
        Observable<String>  observable = requestApi.getSearch(name);
        return observable;
    }

    public Observable<String> register(String username){
        Observable<String>  observable = requestApi.register(username);
        return observable;
    }

    public Observable<String> login(){
        Observable<String>  observable = requestApi.login("zhangsan");
        return observable;
    }


}
