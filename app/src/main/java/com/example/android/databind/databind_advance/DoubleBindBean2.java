package com.example.android.databind.databind_advance;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class DoubleBindBean2 {
    //如果字段比较少，就使用以下
    public ObservableBoolean aBoolean = new ObservableBoolean();
    public ObservableInt value = new ObservableInt();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<UserBean> observableUserBean = new ObservableField<>();
}
