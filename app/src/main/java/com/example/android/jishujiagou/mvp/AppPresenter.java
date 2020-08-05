package com.example.android.jishujiagou.mvp;

public class AppPresenter implements AppContract.Presenter {
    private AppContract.View view;
    public AppPresenter(AppContract.View view){
        this.view = view;
    }
    //从网络获取数据
    @Override
    public void getData() {
        //从网络获取数据后，通过接口展示数据
        view.setDataView();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
