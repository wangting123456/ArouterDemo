package com.example.android.databind.databind_recycle;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databind.databind_advance.UserBean;
import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.ActivityDatabindRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ActivityDatabindRecycleBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_databind_recycle);
        List<UserBean> list = new ArrayList<>();
        UserBean userBean = new UserBean();
        userBean.setName("张三");
        userBean.setAge(23);
        list.add(userBean);
        binding.recycle.setAdapter(new SimpleAdapter(list));
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 8;
                outRect.left = 8;
                outRect.right = 8;
                outRect.top = 8;
            }
        });
    }
}
