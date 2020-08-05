package com.example.android.net.net_okhttpclient;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //OkHttpClient
        //支持异步阻塞请求和回调.
        //khttp-urlconnection模块实现了 java.net.HttpURLConnection 中的API
        //okhttp-apache模块实现了HttpClient中的API
    }

    /**
     * 使用FormBody传递键值对参数 String 类型的键值对
     */
    private void post() {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder formbody = new FormBody.Builder(); //创建表单请求体
        formbody.add("userNmae", "zhangsan");  //传递键值对参数
        Request request = new Request.Builder()    //创建Request对象
                .url("http://www.baidu.com")
                .post(formbody.build())//传递请求体
                .build();
        //异步
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        //同步
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用RequestBody传递Json或File对象
     */
    private void post2() {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        String jsonStr = "{\"username\":\"lisi\",\"nickname\":\"李四\"}";//json数据.
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    /**
     * 使用RequestBody 传递File对象
     */
    private void post3(){
        OkHttpClient client = new OkHttpClient();
        MediaType fileType = MediaType.parse("File/*");//数据类型为json格式，
        File file = new File("path");//file对象.
        RequestBody body = RequestBody.create(fileType , file );
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

}


