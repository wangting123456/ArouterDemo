package com.example.android.window.window_dialogfragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.arouterdemo.R;

public class MyDilaogFragment extends DialogFragment {
    int width;
    int height;
    public static MyDilaogFragment newInstance(int width,int height){
        MyDilaogFragment dialog = new MyDilaogFragment();
        Bundle data = new Bundle();
        data.putInt("width",width);
        data.putInt("height",height);
        dialog.setArguments(data);
        return  dialog;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setStyle(STYLE_NO_FRAME, R.style.MyDialog);
         width = getArguments().getInt("width");
         height = getArguments().getInt("height");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.android_window_dialog_fragment,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.gravity = Gravity.CENTER;
        window.setAttributes(param);
        getDialog().getWindow().setLayout(width,height);


    }
}
