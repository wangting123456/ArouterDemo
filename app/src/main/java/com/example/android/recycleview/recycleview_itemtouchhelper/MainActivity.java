package com.example.android.recycleview.recycleview_itemtouchhelper;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databind.databind_advance.UserBean;
import com.example.android.databind.databind_recycle.SimpleAdapter;
import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemTouchHelper
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recycle;
    private List<UserBean> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_recycle_itemtouch);
        //1.需要实现拖拽功能
           //a.长按Item后拖动，与其他Item交换位置
           //b.按住item右面的图标后拖动，与其他item交换位置
           //c.左滑item变透明并缩小，超出屏幕后，其他item补上
           //d.右滑item变透明并缩小，超出屏幕后，其他item补上


        //2.几个重要方法说明
          //a.onMove:当Item被拖拽时候被调用
          //b.onSwiped:当View被滑动删除的时候
          //c.onSelectedChanged:当item被拖拽或侧滑时触发

        //3.上下拖拽时与其他Item交换位置
          //ItemTouchHelper.Callback本身不具备将两个Item互相交换位置的功能，但RecycleView可以，
          //我们可以在item拖动的时候把当前item与另一个item的数据位置交换，再调用notifyItemMoved方法刷新布局

        //4.左右滑出屏幕时其他item补上
          //只要在item滑出屏幕时，将对应的数据删掉，再调用RecyclerView的notifyItemRemoved()方法刷新布局即可

        //5.拖拽效果优化
          //a.在Item拖拽或者侧滑时修改背景颜色ItemTouchHelper.Callback中正好有对应这两个状态的方法，
            // 分别是：onSelectedChanged()、clearView()。
          //b.左右滑动使item透明度变浅且缩小该如何实现呢
        initRecycleView();
    }

    private void initRecycleView(){
        recycle = findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        recycle.setAdapter(new SimpleAdapter(list));
    }
    private void initItemTouch(){

    }
}
