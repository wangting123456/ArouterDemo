package com.example.android.databind.databind_recycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databind.databind_advance.UserBean;
import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindRecycleItemBinding;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.BindViewHolder> {
    private String TAG = SimpleAdapter.class.getSimpleName();
    private List<UserBean> list = new ArrayList<>();

    public SimpleAdapter(List<UserBean> list) {
        this.list = list;
        System.out.println(list.size());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Log.d(TAG,"onAttachedToRecyclerView");
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Log.d(TAG,"onDetachedFromRecyclerView");
    }

    @NonNull
    @Override
    public BindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ActivityDatabindRecycleItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.activity_databind_recycle_item, parent, false);
        BindViewHolder<ActivityDatabindRecycleItemBinding> viewHolder = new BindViewHolder<>(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BindViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder");
       ViewDataBinding binding =  holder.getBinding();
      if(binding instanceof ActivityDatabindRecycleItemBinding){
          ActivityDatabindRecycleItemBinding bind = (ActivityDatabindRecycleItemBinding)binding;
          bind.setUserbean(list.get(position));
          bind.executePendingBindings();
      }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"getItemCount");
        return list.size();
    }

    public class BindViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private T binding;

        public BindViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public T getBinding() {
            return binding;
        }

        public void setBinding(T binding) {
            this.binding = binding;
        }
    }
}
