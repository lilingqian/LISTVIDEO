package com.example.lenovo.listvideo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.listvideo.ui.fragment.ImgFragment;
import com.example.lenovo.listvideo.ui.fragment.VideoFragment;

public class TabPageIndicatorAdapter  extends FragmentPagerAdapter {

    /**q
     * Tab标题
     */
    private static final String[] TITLE = new String[]{"图片", "视频"};

    public TabPageIndicatorAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;
        if (position%2==0){

            fragment  = new ImgFragment();

        }else {

            fragment = new VideoFragment();

        }
        return  fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position % TITLE.length];
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }
}
