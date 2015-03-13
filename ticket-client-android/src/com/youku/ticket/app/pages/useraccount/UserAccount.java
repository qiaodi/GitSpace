package com.youku.ticket.app.pages.useraccount;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.homepage.YoukuTicketMainActivity;
import com.youku.ticket.app.templates.BaseTabFragment;
import com.youku.ticket.app.utils.ActiivtyStack;

/**
 * @className UserAccount
 * @description TODO 主界面用户tab页的主界面
 * @author QIAODI
 * @date 2014年12月26日 下午5:01:31
 */
public class UserAccount extends BaseTabFragment {

    private FragmentManager mFragmentManager;

    private final String TAB_TAG = "user-account";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getChildFragmentManager();
        YoukuTicketMainActivity.sFragmentStack.put(TAB_TAG, new ActiivtyStack(mFragmentManager));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(R.layout.useraccount, null);
        initLoadingIndicator();
        return mLayoutView;
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void CreateActionBarItem(Menu menu) {
        // TODO Auto-generated method stub

    }

}
