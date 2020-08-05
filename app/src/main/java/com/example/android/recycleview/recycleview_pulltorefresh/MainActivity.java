package com.example.android.recycleview.recycleview_pulltorefresh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 上拉刷新，下拉加载
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mList = null;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyWtAdapter myWtAdapter;
    private GridLayoutManager mLayoutManager;
    private int lastVisibleItem = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_recycleview_pull);
        initData();
        initView();
        initRefreshLayout();
        initRecycleView();
    }
    private void initData(){
        mList = new ArrayList<>();
        for (int i = 0;i < 40;i++){
            mList.add("条目:"+i);
        }
    }

    private void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
    }

    @SuppressLint("ResourceAsColor")
    private void initRefreshLayout(){
        //上拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                myWtAdapter.resetDatas();
                updateRecycleView(0, 10);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
    }

    private void initRecycleView(){
        myWtAdapter = new MyWtAdapter(getDatas(0,10),this,getDatas(0,10).size() > 0 ? true:false);
        mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(myWtAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("WANGTING","onScrollStateChanged");
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    if(myWtAdapter.isFadeTips() == false && lastVisibleItem + 1 == myWtAdapter.getItemCount()){
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                updateRecycleView(myWtAdapter.getItemCount(),myWtAdapter.getItemCount()+10);
                            }
                        },500);
                    }
                    if(myWtAdapter.isFadeTips() == true && lastVisibleItem + 2 == myWtAdapter.getItemCount()){
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                updateRecycleView(myWtAdapter.getItemCount(),myWtAdapter.getItemCount()+10);
                            }
                        },500);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("WANGTING","onScrolled");
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
    //0 10
    private List<String> getDatas(int firstIndex, int lastIndex){
        List<String> newData = new ArrayList<>();
        for (int i = firstIndex;i < lastIndex;i++){
            if(i < mList.size()){
                newData.add(mList.get(i));
            }
        }
        return newData;
    }

    private void updateRecycleView(int fromIndex,int toIndex){
        List<String> data = getDatas(fromIndex,toIndex);
        if(data.size() > 0){
            myWtAdapter.updateList(data,true);
        }else {
            myWtAdapter.updateList(null,false);
        }
    }

}
