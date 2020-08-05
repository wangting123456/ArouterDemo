package com.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {
    private MutableLiveData<Item> selectItem = new MutableLiveData<>();

    public MutableLiveData<Item> getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Item item) {
        selectItem.setValue(item);
    }
}
