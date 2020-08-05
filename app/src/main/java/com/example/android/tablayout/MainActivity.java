package com.example.android.tablayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.AndroidTablayoutMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AndroidTablayoutMainBinding binding;
    private List<String> mListTitle = new ArrayList<>();
    private List<Fragment> mListFragment = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.android_tablayout_main);
        mListTitle.add("首页");
        mListTitle.add("设置");
        mListFragment.add(new Fragment());
        mListFragment.add(new Fragment());
        binding.viewPager.setAdapter(new FragmentPagetAdapter2(getSupportFragmentManager(),mListTitle,mListFragment));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }
}
