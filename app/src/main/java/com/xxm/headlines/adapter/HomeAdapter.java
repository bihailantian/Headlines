package com.xxm.headlines.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xxm.headlines.base.BaseFragment;

import java.util.List;

/**
 *主页适配器
 */
public class HomeAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;//fragment集合
    private String[] mTitleList; //标题

    public HomeAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] titleList) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList != null ? mFragmentList.size():0;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList[position];
    }
}
