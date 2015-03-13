package com.youku.ticket.app.pages.moviesets;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.homepage.YoukuTicketMainActivity;
import com.youku.ticket.app.templates.BaseTabFragment;
import com.youku.ticket.app.utils.ActiivtyStack;
import com.youku.ticket.app.views.EmptyFragment;
import com.youku.ticket.app.views.MenuItemSearch;
import com.youku.ticket.app.views.TicketFragmentPagerAdapter;

/**
 * @className Movie
 * @description TODO 主界面影片Tab页的入口
 * @author QIAODI
 * @date 2014年12月26日 下午5:01:11
 */
public class Movie extends BaseTabFragment {

    private FragmentManager mFragmentManager;

    private final String TAB_TAG = "movie";

    private ViewPager mViPager;

    private FragmentTabHost mTabHost;

    private OnTabChangeListener onTabChangeListener;

    private int[] mIndicatorTxt = { R.string.movie_tab_showing, R.string.movie_tab_coming, R.string.movie_tab_classic};

    private ArrayList<Fragment> mFragmentList;

    private MovieListFragment_Showing mMovieListShowing;

    private MovieListFragment_Coming mMovieListComing;

    private MovieListFragment_Classic mMovieListClassic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getChildFragmentManager();
        YoukuTicketMainActivity.sFragmentStack.put(TAB_TAG, new ActiivtyStack(mFragmentManager));
        mFragmentList = new ArrayList<Fragment>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(R.layout.movie, null);
        mViPager = (ViewPager) mLayoutView.findViewById(R.id.movie_viewpager);
        mTabHost = (FragmentTabHost) mLayoutView.findViewById(android.R.id.tabhost);
        mTabHost.setOnTabChangedListener(onTabChangeListener);
        mTabHost.setup(getActivity(), mFragmentManager, android.R.id.tabcontent);
        for (int i = 0; i < mIndicatorTxt.length; i++) {
            View indicator = getIndicatorView(i);
            mTabHost.addTab(mTabHost.newTabSpec(getActivity().getResources().getString(mIndicatorTxt[i])).setIndicator(indicator), EmptyFragment.class, null);
        }
        mTabHost.setOnTabChangedListener(mOnTabChangeListener);
        mViPager = (ViewPager) mLayoutView.findViewById(R.id.movie_viewpager);
        mViPager.setOnPageChangeListener(mOnPageChangeListener);
        mMovieListShowing = new MovieListFragment_Showing();
        mMovieListComing = new MovieListFragment_Coming();
        mMovieListClassic = new MovieListFragment_Classic();
        mFragmentList.add(mMovieListShowing);
        mFragmentList.add(mMovieListComing);
        mFragmentList.add(mMovieListClassic);
        mViPager.setAdapter(new TicketFragmentPagerAdapter(mFragmentManager, mFragmentList));
        mViPager.setOffscreenPageLimit(mFragmentList.size());
        return mLayoutView;
    }

    private OnTabChangeListener mOnTabChangeListener = new OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            // TODO Auto-generated method stub
            if(tabId.equalsIgnoreCase(getActivity().getResources().getString(mIndicatorTxt[0]))){
                mViPager.setCurrentItem(0);
            }
            else if(tabId.equalsIgnoreCase(getActivity().getResources().getString(mIndicatorTxt[1]))){
                mViPager.setCurrentItem(1);
            }
            else if(tabId.equalsIgnoreCase(getActivity().getResources().getString(mIndicatorTxt[2]))){
                mViPager.setCurrentItem(2);
            }
        }
    };

    private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            mTabHost.setCurrentTab(position);  
            mTabHost.getCurrentTabView().setBackgroundColor(Color.GREEN);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    };

    private View getIndicatorView(int i) {
        // TODO Auto-generated method stub
        TextView tv = new TextView(getActivity());
        tv.setText(this.mIndicatorTxt[i]);
        return tv;
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void CreateActionBarItem(Menu menu) {
        // TODO Auto-generated method stub
        MenuItemSearch item = new MenuItemSearch();
        item.ShowItem(getActivity(), menu);
    }

}
