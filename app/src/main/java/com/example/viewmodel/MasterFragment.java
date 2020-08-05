package com.example.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class MasterFragment extends Fragment {
    private ShareViewModel shareViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shareViewModel = ViewModelProviders.of(getActivity()).get(ShareViewModel.class);
        shareViewModel.setSelectItem(new Item("zhangsan"));

        //好处：
          //1.Activity不需要做任何事情，甚至不知道这次交互，完美解耦
          //2.Fragment 只需要和ViewModel交互，不需要知道对方Fragmenr是否存在，更不需要持有其引用
          //3.Fragment 生命周期互不影响，甚至 fragment 替换成其他的 也不影响这个系统的运作。
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
