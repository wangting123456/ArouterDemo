package com.example.android.ipc.ipc_uithread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_ipc_uithread);
        //不要阻塞 UI 线程
        //不要在 UI 线程之外访问 Android UI 工具包

    /*    为解决此问题，Android 提供了几种途径来从其他线程访问 UI 线程：
        Activity.runOnUiThread(Runnable)
        View.post(Runnable)
        View.postDelayed(Runnable, long)*/
        imageView = (ImageView) findViewById(R.id.image);
    }

    public void onClick(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = loadImageFromNetWork();
                //不要在 UI 线程之外访问 Android UI 工具包
                imageView.setImageBitmap(bitmap);
            }
        }).start();
    }

    public void onClick1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork();
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
    public void onClick2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    public void onClick3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetWork();
                imageView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                },200);
            }
        }).start();
    }
    private Bitmap loadImageFromNetWork(){
        Bitmap bitmap = null;
        return bitmap;
    }
}
