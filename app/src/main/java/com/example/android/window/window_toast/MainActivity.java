package com.example.android.window.window_toast;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.Toast构造方法
           //Toast只会弹出一段信息，告诉用户某某事情已经发生了，过一段时间后就会自动消失。它不会阻挡用户的任何操作。

        //2.Toast简单使用
          Toast.makeText(this,"吐司",Toast.LENGTH_SHORT).show();
          //a.当点击有些按钮，需要吐司进行提示时；快速连续点击了多次按钮，Toast就触发了多次
          //b.可能导致Toast就长时间关闭不掉了。又或者我们其实已在进行其他操作了，应该弹出新的Toast提示，
              // 而上一个Toast却还没显示结束

        //3.简单改造避免重复创建:
           //由于不会每次调用的时候都生成新的Toast对象，因此刚才我们遇到的问题在这里就不会出现

        //4.为何会引起内存泄露：
          //如果在 Toast 消失之前，Toast 持有了当前 Activity，而此时，用户点击了返回键，
          //导致 Activity 无法被 GC 销毁, 这个 Activity 就引起了内存泄露。
    }

    private Toast toast;
    public void showToast(Context context,String content){
       if(toast == null){
           toast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
       }else {
           toast.setText(content);
       }
       toast.show();
    }
}
