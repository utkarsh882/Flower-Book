package com.easternts.flowerworld.settingslayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by SVF 15213 on 18-07-2016.
 */
public class AboutUsVPAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public AboutUsVPAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new AboutUsDetailsFragment();
            case 1:
                return new AboutUsContactUsFragment();
            case 2:
                return new AboutUsFollowUsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
