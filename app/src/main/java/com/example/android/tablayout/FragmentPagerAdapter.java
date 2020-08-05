package com.example.android.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
    private List<MainEntity> mainEntityList;

    public FragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    public FragmentPagerAdapter(@NonNull FragmentManager fm, List<MainEntity> list) {
        super(fm);
        this.mainEntityList = list;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mainEntityList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mainEntityList.size();
    }

}
