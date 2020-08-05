package com.example.android.dialogfragment.dialogfragment_advance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.arouterdemo.R;

public class MyDialogFragment extends DialogFragment {
    public  static MyDialogFragment newInstance(String title){
        Bundle data = new Bundle();
        data.putString("title",title);
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.setArguments(data);
        return dialog;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.android_dialogfragment_advance, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString("title");
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(title);
    }

    @Override
    public void onResume() {
        super.onResume();
        //全屏处理
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes(params);
        //指定宽度和高度
        //int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        //int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        //getDialog().getWindow().setLayout(width, height);
    }
}
