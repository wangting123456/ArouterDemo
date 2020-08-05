package com.example.android.recycleview.recycleview_viewholder;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.ViewHolder作用
          //a.adapter应当拥有ViewHolder的子类，并且ViewHolder里面应当拥有一些子View,避免时间代价很大的
              // findViewById操作
          //b.们经常使用的也就是onCreateViewHolder()方法和onBindViewHolder()方法。onCreateViewHolder()
              //在RecycleView中需要一个新类型，item的ViewHolder时调用来创建一个ViewHolder。而onBindV
             // iewHolder()方法则当RecyclerView需要在特定位置的item展示数据时调用。

        //2.ViewHolder与复用
          //a.在复写RecycleView的时候，需要我们复写两个方法，onCreateViewHolder()方法和onBindViewHolder()方法
              //这两个方法字面意思是创建ViewHolder，和绑定ViewHolder
          //b.复用机制是怎样的？
              //只有一种ViewType，上下滑动的时候需要的ViewHolder种类是只有一种，但是需要的ViewHolder对象
              // 数量并不止一个。所以在后面创建了9个ViewHolder之后，需要的数量够了，无论怎么滑动，都
              // 只需要复用以前创建的对象就行了。那么逗比程序员们思考一下，为什么会出现这种情况呢

              //看到了下面log之后，第一反应是在这个ViewHolder对象的数量“够用”之后就停止调用onCreate
              // ViewHolder方法，但是onBindViewHolder方法每次都会调用的。
          //c.查看createViewHolder()源码发现，里面并没有限制
          //d.对于ViewHolder对象的数量“够用”之后就停止调用onCreateViewHolder方法，可以查看
              //如果共享池可用于正确的视图类型，则回收程序可以重用共享池中的废视图或分离视图

    }
}
