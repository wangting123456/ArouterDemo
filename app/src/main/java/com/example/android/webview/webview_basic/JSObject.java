package com.example.android.webview.webview_basic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

public class JSObject {
    private Context context;
    public JSObject(Context context){
        this.context = context;
    }

    @SuppressLint("JavascriptInterface")
    public String showToast(String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
        return "success";
    }
}
