package com.example.android.view.view_invalidate;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.requestLayout、invalidate与postInvalidate作用与区别
          //a.invalidate() postInvalidate() invalidate无效，试图无效重新绘制
              //共同点：都是调用OnDraw()方法，然后达到重绘View的目的
              //区别：invalidate用于主线程，postInvalidate用于子线程，
                      //通过handler发送消息，在handleMessage中((View) msg.obj).invalidate()，
          //requestLayout()
            //a.也可以达到重绘View的目的，但是会先调用onLayout()重现排版，再调用onDraw()方法
            //b.当view确定自身已经不再适合现有的区域时，该view本身调用这个方法要求parent view（父类的视图）
               // 重新调用他的onMeasure、onLayout来重新设置自己位置。

    }
}
