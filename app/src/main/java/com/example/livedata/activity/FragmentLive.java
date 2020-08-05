package com.example.livedata.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;

public class FragmentLive extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.fragment_live,null);
         MainViewModel mainViewModel =  ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getUser().postValue(new User("fragment",1));
        mainViewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                User user = (User)o;
                user.getAge();
                user.getName();
            }
        });
         return view;
    }
}
