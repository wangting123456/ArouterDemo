package com.example.android.recycleview.recycleview_spansizelookup;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivty extends AppCompatActivity {
    private RecyclerView recycle;
    private List<SpanModel> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_recycle_basic);
        //1.先来看一个需求
            //该页面中，同时包含列表，2列的网格，3列的网格如何优雅实现

        //2.SpanSizeLookup的作用
           //RecyclerView 可以通过GridLayoutManager实现网格布局，但是很少有人知道，GridLayoutManager
           //还可以用来设置网格中指定Item的列数，类似于合并单元格的功能
           //要实现指定某个item所占列数的功能我们需要用到GridLayoutManager.SpanSizeLookup这个类

        //3.SpanSizeLookup如何使用
          //a.先是定义了一个6列的网络布局，然后通过GridLayoutManager.SpanSizeLookup来动态指定某个Item
              //应该占多少列
          //b.比如getSpanSize返回6，就表示当前position索引处的item占用6列
          //c.比如getSpanSize返回3.就表示当前postion索引处的item占用3列

        recycle = findViewById(R.id.recycle);
        list.add(new SpanModel(1));
        list.add(new SpanModel(2));
        list.add(new SpanModel(3));
        list.add(new SpanModel(4));
        list.add(new SpanModel(5));
        list.add(new SpanModel(6));
        GridLayoutManager layout = new GridLayoutManager(this,6);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                SpanModel model = list.get(position);
                if (model.getType() == 1) {
                    return 6;
                } else if(model.getType() == 2){
                    return 3;
                }else if (model.getType() == 3){
                    return 2;
                }else if (model.getType() == 4){
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recycle.setLayoutManager(layout);

    }

    private class SpanModel{
        private int type;
        public SpanModel(int type){
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
