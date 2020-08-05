package com.example.android.jishujiagou.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends ViewModel {
    private MutableLiveData<ImageBean> mList = new MutableLiveData<>();
    private ImageRepertory imageRepertory;
    private int idx = 0;
    public ImageViewModel(){
        mList = new MutableLiveData<>();
        imageRepertory = new ImageRepertory();
    }
    public MutableLiveData<ImageBean>  getImagemList(){
        return mList;
    }
    public void loadImage(){
        imageRepertory.getImage("js", idx, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ImageBean value) {
                        mList.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
