package com.example.android.view.view_basic.view_zuhekongjian;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.arouterdemo.R;

public class CustomTitleView extends FrameLayout implements View.OnClickListener {
    private Button btn_left;
    private TextView tv_title;

    public CustomTitleView(@NonNull Context context) {
        super(context);
    }

    public CustomTitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title_view, this);
        btn_left = (Button) findViewById(R.id.btn_left);
        tv_title = (TextView) findViewById(R.id.title_tv);
        btn_left.setOnClickListener(this);
    }
    private OnClickListener listener;
    public void setOnClickListener( OnClickListener listener){
      this.listener = listener;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                if(listener != null){
                    listener.onClick(v);
                }
                break;
            default:
                break;
        }
    }
}
