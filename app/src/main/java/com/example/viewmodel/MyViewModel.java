package com.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Item>> list = null;
    public  MutableLiveData<List<Item>> getList(){
        if(list == null){
            list = new MutableLiveData<>();
        }
        loadData();
        return list;
    }

    private void loadData(){

    }

    /**
     * 随着Activity的销毁，自动回调onCleared
     */
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
