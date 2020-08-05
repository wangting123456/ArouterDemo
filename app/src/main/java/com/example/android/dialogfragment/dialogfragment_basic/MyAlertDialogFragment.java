package com.example.android.dialogfragment.dialogfragment_basic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.arouterdemo.R;

public class MyAlertDialogFragment extends DialogFragment {

    public  static MyAlertDialogFragment newInstance(String title){
        Bundle data = new Bundle();
        data.putString("title",title);
        MyAlertDialogFragment dialog = new MyAlertDialogFragment();
        dialog.setArguments(data);
        return dialog;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
         super.onCreateDialog(savedInstanceState);
        String title = getArguments().getString("title");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage("确定删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
       AlertDialog dialog = builder.create();

       //设置Dialog的宽度和高度,宽度为屏宽，位置靠近底部
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(R.color.colorAccent);
        window.getDecorView().setPadding(0,0,0,0);
        WindowManager.LayoutParams param = window.getAttributes();
        param.gravity = Gravity.BOTTOM;
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        param.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(param);
        return dialog;
    }
}
