package com.example.android.jishujiagou.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AppContract.View{
    private AppContract.Presenter presenter = new AppPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getData();
    }

    @Override
    public void setDataView() {
        //对应的数据展示
    }
}
