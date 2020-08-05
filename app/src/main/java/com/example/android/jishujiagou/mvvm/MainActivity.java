package com.example.android.jishujiagou.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;
import com.example.arouterdemo.databinding.AndroidJiagouMvvmBinding;

public class MainActivity extends AppCompatActivity {
    private AndroidJiagouMvvmBinding binding;
    private ImageViewModel imageViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.android_jiagou_mvvm);
        binding.setPresenter(new Presenter());
        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        imageViewModel.getImagemList().observe(this, new Observer<ImageBean>() {
            @Override
            public void onChanged(ImageBean imageBean) {

            }
        });
    }
    public class Presenter {
        public void onClick(View view){
            switch (view.getId()) {
                case R.id.btn_load:
                    imageViewModel.loadImage();
                    break;
                default:
                    break;
            }
        }
    }
}
