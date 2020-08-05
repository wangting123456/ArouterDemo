package com.example.android.tablayout;

import androidx.fragment.app.Fragment;

public class MainEntity {
    private Fragment fragment;
    private String title;
    private int res;
    private String tag;

    public MainEntity(Fragment fragment,String title,int res,String tag){
        this.fragment = fragment;
        this.title = title;
        this.res = res;
        this.tag = tag;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
