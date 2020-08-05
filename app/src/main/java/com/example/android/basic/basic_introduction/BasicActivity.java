package com.example.android.basic.basic_introduction;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;

public class BasicActivity extends Activity {
    /**
     * Activity在异常情况下终止onSaveInstanceState
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 异常终止的Activity被重建回调onRestoreInstanceState
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
