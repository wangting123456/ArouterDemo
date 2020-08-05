package com.example.android.databind.databind_advance;

import android.view.View;
import android.widget.Toast;

public class OnClickHandler {
    public void onClick(View view){
        Toast.makeText(view.getContext(),"我被点击了",Toast.LENGTH_SHORT).show();
    }
}
