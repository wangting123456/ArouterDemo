package com.example.android.window.window_dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.example.arouterdemo.R;

public class CustomDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题第一种
        //设置样式时，使用STYLE_NO_TITLE
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //去除标题第二种
        Window window = getDialog().getWindow();
        if(window!=null){
            window.requestFeature(Window.FEATURE_NO_TITLE);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.android_window_dialog_fragment,container,false);
         return  view;
    }

    public static void showDialog(FragmentActivity activity){
        CustomDialogFragment dialogFragment = new CustomDialogFragment();
        dialogFragment.show(activity.getSupportFragmentManager(),"custom_dialog");
    }
}
