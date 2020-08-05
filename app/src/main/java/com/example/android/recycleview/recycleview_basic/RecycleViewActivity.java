package com.example.android.recycleview.recycleview_basic;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.PUT;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_recycle_basic_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        //1.RecycleView的结构
          //a.RecycleView.Adapter:处理数据集合，并负责绑定视图
          //b.ViewHolder:持有所有的用于绑定数据/需要操作的View
          //c.LayoutManager:负责摆放视图等相关操作
          //d.ItemDecoration:负责绘制Item附近的分割线
          //e.ItemAnimotor:为Item的一般操作添加动画效果，如增删条目等

        //2.RecycleView简单用法
        LinearLayoutManager linear = new LinearLayoutManager(this);
        //设置LinearLayoutManager
        recyclerView.setLayoutManager(linear);
        //设置ItemDecoration
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.left = 4;
                outRect.top = 4;
                outRect.right = 4;
                outRect.bottom = 4;
            }
        });
        MultiItemAdapter adapter = new MultiItemAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.addAll(new ArrayList<String>());
        adapter.notifyDataSetChanged();
    }

    public static class MultiItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private Context context;
        private LayoutInflater inflater;
        private ArrayList<String> mList;
        public static enum ITEM_TYPE{
            ITEM_IMAGE,ITEM_TEXT
        }
        public MultiItemAdapter(Context context){
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        public void addAll(List<String> list){
            if(mList == null){
                mList = new ArrayList<>();
            }else {
                mList.clear();
            }
            mList.addAll(list);
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if(viewType == ITEM_TYPE.ITEM_TEXT.ordinal()){
               View view = inflater.inflate(R.layout.android_recycle_basic_multi_text_item,parent,false);
               return new TextViewHolder(view);
            }else {
                View view = inflater.inflate(R.layout.android_recycle_basic_multi_image_item,parent,false);
                return new ImageViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof TextViewHolder){
                ((TextViewHolder) holder).tvName.setText(mList.get(position));
            } else if(holder instanceof ImageViewHolder){
                ((ImageViewHolder) holder).tvContent.setText(mList.get(position));
            }
        }

        @Override
        public int getItemViewType(int position) {
             super.getItemViewType(position);
             return position/2 == 0?ITEM_TYPE.ITEM_TEXT.ordinal():ITEM_TYPE.ITEM_IMAGE.ordinal();
        }

        @Override
        public int getItemCount() {
            return mList == null?0:mList.size();
        }

        public static class TextViewHolder extends RecyclerView.ViewHolder{
            TextView tvName;
            public TextViewHolder(@NonNull View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
        public static class ImageViewHolder extends RecyclerView.ViewHolder{
            TextView tvContent;
            public ImageViewHolder(@NonNull View itemView) {
                super(itemView);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }

    }
}
