package com.example.android.jishujiagou.mvp;

public interface AppContract {
    interface View extends BaseView {
        void setDataView();
    }

    interface Presenter extends BasePresenter {
        void getData();
    }
}
