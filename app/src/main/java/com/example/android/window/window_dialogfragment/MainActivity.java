package com.example.android.window.window_dialogfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.showDialog(this);

        MyDilaogFragment dialog1 = new MyDilaogFragment();
        dialog1.show(getSupportFragmentManager(),"myDialog");

    }
}
