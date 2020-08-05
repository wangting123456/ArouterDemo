package com.example.android.recycleview.recycleview_snaphelper;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.SnapHelper 作用
          //在某些场景下，卡片列表滑动浏览，希望当滑动停止时，可以将当前卡片停留在屏幕的某个地方，比如停在
            //左边，可以吸引用户焦点，那么可以使用recycleview+snaphelper实现

        //2.SnapHelper类分析
          //a.SnapHelper继承自RecyclerView.OnFlingListener，并重写onFling方法
    }
}
