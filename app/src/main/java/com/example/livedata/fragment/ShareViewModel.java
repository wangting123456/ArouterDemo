package com.example.livedata.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {
    private  MutableLiveData<Item> selectItem;
    public MutableLiveData<Item> getSelectItem(){
        if(selectItem == null){
            selectItem = new MutableLiveData<>();
        }
        return selectItem;
    }
    public void setSelectItem(Item item){
        selectItem.setValue(item);
    }
}
