package com.example.android.databind.databind_onclick;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.arouterdemo.R;
import com.example.livedata.activity.User;

public class MyViewModel extends ViewModel {
    public void onClickView(View view){
        Toast.makeText(view.getContext(),"我被点击了",Toast.LENGTH_SHORT).show();
    }
    public void onClickButton(int id){

    }
    public void onClickButton2(String name){

    }
    public void onClickWithView(User user,View view){

    }
    public String loadString(Context context) {
        // 使用生成的context变量
        return context.getResources().getString(R.string.app_name);
    }
}
