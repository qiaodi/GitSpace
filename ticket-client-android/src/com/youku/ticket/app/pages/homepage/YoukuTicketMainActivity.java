package com.youku.ticket.app.pages.homepage;

import java.util.HashMap;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.cinemasets.Cinema;
import com.youku.ticket.app.pages.commentsets.Comments;
import com.youku.ticket.app.pages.homepage.HomePage;
import com.youku.ticket.app.pages.moviesets.Movie;
import com.youku.ticket.app.pages.useraccount.UserAccount;
import com.youku.ticket.app.templates.BaseActivity;
import com.youku.ticket.app.templates.BaseDataProvider;
import com.youku.ticket.app.utils.ActiivtyStack;
import com.youku.ticket.utils.UserLocation;

import junit.framework.Assert;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

/**
 * @className YoukuTicketMainApp
 * @description TODO 应用程序入口
 * @author QIAODI
 * @date 2014年12月26日 下午4:31:28
 */
public class YoukuTicketMainActivity extends BaseActivity {

    private FragmentTabHost mTabHost;

    private String[] mTabTag = { "mainpage", "movie", "cinema", "comments", "user-account" };

    private int[] mIndicatorTxt = { R.string.tabitem_home, R.string.tabitem_movie, R.string.tabitem_cinema, R.string.tabitem_comments, R.string.tabitem_user_account };

    private Class[] mTabClass = { HomePage.class, Movie.class, Cinema.class, Comments.class, UserAccount.class };

    /**
     * @fields sFragmentStack : TODO
     *         每个Tab页分别对一个stack，用于保存页面的切换流程，也用于判断back键的处理逻辑
     */
    public static HashMap<String, ActiivtyStack> sFragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_linear);
        addAppBar(true);
        Assert.assertEquals(mTabTag.length, mIndicatorTxt.length);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setOnTabChangedListener(onTabChangeListener);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        sFragmentStack = new HashMap<String, ActiivtyStack>();
        for (int i = 0; i < mIndicatorTxt.length; i++) {
            View indicator = getIndicatorView(i);
            mTabHost.addTab(mTabHost.newTabSpec(mTabTag[i]).setIndicator(indicator), mTabClass[i], null);
        }
        //		UserLocation.getInstance().initManager(this);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        UserLocation.getInstance().updateLocationInformation(this);
        //		UserLocation.getInstance().recordLocation(true);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //		UserLocation.getInstance().recordLocation(false);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        //		UserLocation.getInstance().deinitManager();
    }

    private View getIndicatorView(int i) {
        View v = getLayoutInflater().inflate(R.layout.tab_indicator, null);
        TextView tv = (TextView) v.findViewById(R.id.textView1);
        tv.setText(this.mIndicatorTxt[i]);
        return v;
    }

    /**
     * description: TODO 用于获得TabHost实例
     * 
     * @creater QIAODI
     * @return FragmentTabHost
     * @date 2014年12月26日 下午4:32:45
     * @editer
     */
    public FragmentTabHost getActivityTabHost() {
        return mTabHost;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Log.w(TAG, "mTabHost.getCurrentTabTag() " + mTabHost.getCurrentTabTag());
            if (sFragmentStack.get(mTabHost.getCurrentTabTag()).getFragmentSize() > 0) {
                sFragmentStack.get(mTabHost.getCurrentTabTag()).popActivity(sFragmentStack.get(mTabHost.getCurrentTabTag()).currentActivity());
                return false;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * @fields onTabChangeListener : TODO tab页切换的监听
     */
    private OnTabChangeListener onTabChangeListener = new OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            // TODO Auto-generated method stub
            Log.w(TAG, "onTabChanged to:" + tabId);
        }
    };

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return null;
    }
}
