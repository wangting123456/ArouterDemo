package com.example.android.basic.fragment_local;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.arouterdemo.R;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_basic_fragment);
        //静态使用
        //动态使用
        // a.针对直接创建fragment，一般可以这样写
        FragmentBasic fragmentBasic = new FragmentBasic();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY", 1);
        fragmentBasic.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentBasic, "fragmentBasic");
        transaction.commit();
        //b.频繁show/hide fragment的这样处理
        showFragment();
        hideFragment();
    }

    boolean isFragmentShow = false;
    FragmentBasic fragmentBasic;

    private void showFragment() {
        if (isFragmentShow) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentBasic == null) {
            fragmentBasic = new FragmentBasic();
            //transaction.setCustomAnimations();
            transaction.replace(R.id.framelayout, fragmentBasic);
        } else {
            transaction.show(fragmentBasic);
        }
        transaction.commit();
        isFragmentShow = true;
    }

    private void hideFragment() {
        if(fragmentBasic != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //transaction.setCustomAnimations();
            transaction.hide(fragmentBasic);
            transaction.commit();
            isFragmentShow = false;
        }

    }
}
