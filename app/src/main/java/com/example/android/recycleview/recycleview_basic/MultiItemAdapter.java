package com.example.android.recycleview.recycleview_basic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MultiItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static enum ITEM_TYPE {
        ITEM_TYPE_TEXT, ITEM_TYPE_IMAGE
    }

    private List<String> list = new ArrayList<>();

    public MultiItemAdapter(List<String> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE.ITEM_TYPE_TEXT.ordinal()) {
            View view = inflater.inflate(R.layout.android_recycle_basic_multi_text_item, parent, false);
            return new TextViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.android_recycle_basic_multi_image_item, parent, false);
            return new ImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextViewHolder){
            ((TextViewHolder) holder).tvName.setText(list.get(position));
        } else if(holder instanceof ImageViewHolder){
            ((ImageViewHolder) holder).tvContent.setText(list.get(position));
        }

    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
