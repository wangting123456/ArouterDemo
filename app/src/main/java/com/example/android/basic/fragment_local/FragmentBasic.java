package com.example.android.basic.fragment_local;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentBasic extends Fragment {
    // 当Fragment与Activity发生关联的时候调用
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    //创建该Fragment的视图
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // onViewCreated(View view, Bundle savedInstanceState) 试图创建后调用该方法
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //   onActivityCreated(Bundle) 当Activity的onCreated方法返回时调用
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //  onDestroyView() 与onCreateView方法相对应，当该Fragment的视图被移除时调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //与onAttach方法相对应，当Fragment与Activity取消关联时调用
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
