package com.example.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import retrofit2.http.PUT;

public class MediaCompoment {
    private LifecycleOwner lifecycleOwner;
    private String TAG = MediaCompoment.class.getSimpleName();
    public MediaCompoment(LifecycleOwner lifecycleOwner){
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(new GenericLifecycleObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    onCreate();
                } else if (event == Lifecycle.Event.ON_START) {
                    onStart();
                } else if (event == Lifecycle.Event.ON_RESUME) {
                    onResume();
                } else if (event == Lifecycle.Event.ON_PAUSE) {
                    onPause();
                } else if (event == Lifecycle.Event.ON_STOP) {
                    onStop();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    onDestroy();
                }
            }
        });
    }
    public void onCreate() {
        Log.d(TAG, "onCreate:");
    }

    public void onStart() {
        Log.d(TAG, "onStart:");
    }

    public void onResume() {
        Log.d(TAG, "onResume:");
    }

    public void onPause() {
        Log.d(TAG, "onPause:");
    }

    public void onStop() {
        Log.d(TAG, "onStop:");
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy:");
    }
}
