package com.example.android.recycleview.recycleview_pulltorefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyWtAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> datas = new ArrayList<>();
    private Context context;
    private boolean hasMore;
    private int foot = 1;
    private int normal = 0;
    private boolean fadetips = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public MyWtAdapter(List<String> datas, Context context, boolean hasMore) {
        this.datas = datas;
        this.context = context;
        this.hasMore = hasMore;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == normal) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, null);
            return new NormalViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.footview, null);
            return new FootViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int postion) {
        if(viewHolder instanceof NormalViewHolder){
            NormalViewHolder normalViewHolder =  (NormalViewHolder) viewHolder;
            normalViewHolder.tv.setText(datas.get(postion));
        }else {
            final FootViewHolder footViewHolder =  (FootViewHolder) viewHolder;
            footViewHolder.tips.setVisibility(View.VISIBLE);
            if(hasMore == true){
                fadetips = false;
                if(datas.size() > 0){
                    footViewHolder.tips.setText("正在加载更多");
                }
            }else {
                if(datas.size() > 0){
                    footViewHolder.tips.setText("没有更多数据了");
                }
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        footViewHolder.tips.setVisibility(View.GONE);
                        fadetips = true;
                        hasMore = true;
                    }
                },500);
            }
        }
    }

    public int getRealLastPostion(){
        return datas.size();
    }

    public void updateList(List<String> newData, boolean hasMore){
       if(newData != null){
           datas.addAll(newData);
       }
        this.hasMore = hasMore;
       notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public NormalViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
    public boolean isFadeTips() {
        return fadetips;
    }

    public void resetDatas() {
        datas = new ArrayList<>();
    }
    class FootViewHolder extends RecyclerView.ViewHolder {
        private TextView tips;

        public FootViewHolder(View itemView) {
            super(itemView);
            tips = (TextView) itemView.findViewById(R.id.tips);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return foot;
        } else {
            return normal;
        }
    }
}
