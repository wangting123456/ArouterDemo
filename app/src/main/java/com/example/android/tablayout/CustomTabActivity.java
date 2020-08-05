package com.example.android.tablayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.AndroidTablayoutItemBinding;
import com.example.arouterdemo.databinding.AndroidTablayoutMainBinding;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.tabs.TabLayout;

public class CustomTabActivity extends AppCompatActivity {
    private AndroidTablayoutMainBinding binding;
    private List<MainEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.android_tablayout_main);
        list.add(new MainEntity(new Fragment(), "首页", R.drawable.ic_launcher_background, "Index"));
        list.add(new MainEntity(new Fragment(), "音频", R.drawable.ic_launcher_background, "Music"));
        list.add(new MainEntity(new Fragment(), "设置", R.drawable.ic_launcher_background, "Setting"));
        TabLayout tableLayout = binding.tabLayout;
        for (int i = 0; i < list.size();i++) {
            TabLayout.Tab tab = tableLayout.newTab();
            tab.setCustomView(getItemView(list.get(i)));
            tab.getCustomView().setTag(i );
            tab.getCustomView().setOnClickListener(mTabOnClickListener);
            tableLayout.addTab(tab);
        }
        binding.viewPager.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager(), list));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private View.OnClickListener mTabOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            try {
                TabLayout.Tab tab = binding.tabLayout.getTabAt(position);
                if (tab != null) {
                    tab.select();
                }
                binding.viewPager.setCurrentItem(position);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private View getItemView(MainEntity entity) {
        AndroidTablayoutItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(getBaseContext()),
                R.layout.android_tablayout_item, binding.tabLayout, false);
        itemBinding.setEntity(entity);
        itemBinding.getRoot().setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 120));
        return itemBinding.getRoot();

    }
}
