package com.example.android.jishujiagou.mvc;


/**
 * 数据model类
 */
public class MeAboutModel implements InterModel{
    @Override
    public void getAboutData(AboutDataListener listener) {
        //开始请求网络
        listener.success();
        listener.failure();
    }
}
