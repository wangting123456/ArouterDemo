package com.example.android.net.net_httpurlconnection;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpURLConnection 是jdk里面提供的Api, 故优先使用该API;
    }

    private String get(String url) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL mUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) mUrl.openConnection();
            httpURLConnection.setRequestMethod("get");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            int code = httpURLConnection.getResponseCode();
            if (code == 200) {
                InputStream is = httpURLConnection.getInputStream();
                String respose = null;
                respose = getStringFromInputStream(is);
                return respose;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getStringFromInputStream(InputStream is) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int len = -1;
            while (((len = is.read(buffer)) != -1)) {
                os.write(buffer, 0, len);
            }
            is.close();
          String data =  os.toString();
          os.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  String post(String url, String content) {
        HttpURLConnection conn = null;
        try {
            // 创建一个URL对象
            URL mURL = new URL(url);
            // 调用URL的openConnection()方法,获取HttpURLConnection对象
            conn = (HttpURLConnection) mURL.openConnection();
            // 设置请求方法为post
            conn.setRequestMethod("POST");
            // 设置读取超时为5秒
            conn.setReadTimeout(5000);
            // 设置连接网络超时为10秒
            conn.setConnectTimeout(10000);
            // 设置此方法,允许向服务器输出内容
            conn.setDoOutput(true);

            // post请求的参数
            String data = content;
            // 获得一个输出流,向服务器写数据,默认情况下,系统不允许向服务器输出内容
            // 获得一个输出流,向服务器写数据
            OutputStream out = conn.getOutputStream();
            out.write(data.getBytes());
            out.flush();
            out.close();

            // 调用此方法就不必再使用conn.connect()方法
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                InputStream is = conn.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();// 关闭连接
            }
        }
        return null;
    }




}
