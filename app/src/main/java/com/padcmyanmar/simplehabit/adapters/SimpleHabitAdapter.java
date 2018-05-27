package com.padcmyanmar.simplehabit.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 5/17/2018.
 */

public class SimpleHabitAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragment;
    private List<String> mTabTitle;



    public SimpleHabitAdapter(FragmentManager fm) {
        super(fm);
        mFragment=new ArrayList<>();
        mTabTitle=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position) ;
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle.get(position);
    }

    public void addTab(String tabTitle,Fragment fragment){
        mTabTitle.add(tabTitle);
        mFragment.add(fragment);
        notifyDataSetChanged();
    }
}
