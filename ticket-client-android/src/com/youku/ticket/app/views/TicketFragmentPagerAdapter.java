package com.youku.ticket.app.views;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * @className TicketFragmentPagerAdapter
 * @description TODO viewpager适配器的一般方法
 * @author QIAODI
 * @date 2014年12月26日 下午5:02:49
 */
public class TicketFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentList;

    public TicketFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        // TODO Auto-generated constructor stub
        mFragmentList = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return mFragmentList.get(arg0);
    }

}
