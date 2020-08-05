package com.example.android.dialogfragment.dialogfragment_advance;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.arouterdemo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建DialogFragment 有两种方法
        //1.复写OnCreateView
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance("名字");
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreen);
        dialogFragment.show(getSupportFragmentManager(),"MyDialogFragment");
    }
}
