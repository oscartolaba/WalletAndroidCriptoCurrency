package com.example.oscar.wallet.Views.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.oscar.wallet.Views.Fragments.CategoryExpenseFragment;
import com.example.oscar.wallet.Views.Fragments.CategoryIncomingFragment;

/**
 * Created by oscar on 31/12/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static int TAB_COUNT=2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return CategoryExpenseFragment.newInstance();
            case 1: return CategoryIncomingFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return CategoryExpenseFragment.TITLE;
            case 1: return CategoryIncomingFragment.TITLE;
        }
        return null;
    }

}
