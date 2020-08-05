package com.example.android.net.net_retrofit;


import rx.Observable;

public class DouBookModel {
    private static DouBookModel douBookModel;
    private  DouBookApi douBookApi;

    public static DouBookModel getInstance(){
        if(douBookModel == null){
            douBookModel = new DouBookModel();
        }
        return douBookModel;
    }
    public DouBookModel(){
         douBookApi =   RetrofitWrapper.getInstance("baseurl").create(DouBookApi.class);
    }

    public Observable<DouBookBean> getHostMovie(String tag, String start, int count){
      Observable<DouBookBean> book = douBookApi.getBook(tag,start,count);
      return book;
    }
}
