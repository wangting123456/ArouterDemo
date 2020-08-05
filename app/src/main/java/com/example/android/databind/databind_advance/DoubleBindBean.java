package com.example.android.databind.databind_advance;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class DoubleBindBean extends BaseObservable {
    private String content;

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(com.example.arouterdemo.BR.mainViewModel);
    }
}
