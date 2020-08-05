package com.example.android.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagetAdapter2 extends FragmentPagerAdapter {
    private List<String> mListTitle = new ArrayList<>();
    private List<Fragment> mListFragment = new ArrayList<>();
    public FragmentPagetAdapter2(@NonNull FragmentManager fm,List<String> mListTitle,List<Fragment> mListFragment) {
        super(fm);
        this.mListTitle = mListTitle;
        this.mListFragment = mListFragment;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
         super.getPageTitle(position);
         return mListTitle.get(position);
    }
}
