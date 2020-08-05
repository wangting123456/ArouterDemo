package com.example.android.recycleview.recycleview_linearlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.LayoutManager的作用
          //a.LayoutManager的职责是摆放Item的位置，并且负责决定何时回收和复用Item
          //b.RecyclerView 允许自定义规定去放置子View,这个规则的控制着就是LayoutManager，一个
            // RecyclerView 如果想展示内容，就必须设置一个 LayoutManager

        //2.LayoutManager样式
          //a.LinearLayoutManager:水平或者垂直的Item视图
          //b.GridLayoutManager:网格Item视图
          //c.StaggeredGridLayoutManager:交错的网格Item视图
    }
}
