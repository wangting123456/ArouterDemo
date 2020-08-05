package com.example.livedata.activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<User> liveData;

    public MutableLiveData getUser(){
        if(liveData == null){
            liveData = new MutableLiveData<>();
        }
        return liveData;
    }

    public void setUser(User user){
        liveData.setValue(user);
    }
}
