package com.youku.ticket.app.pages.commentsets;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.homepage.YoukuTicketMainActivity;
import com.youku.ticket.app.templates.BaseTabFragment;
import com.youku.ticket.app.utils.ActiivtyStack;
import com.youku.ticket.app.views.MenuItemWriteComment;
import com.youku.ticket.app.views.Switch;
import com.youku.ticket.app.views.Switch.OnSwitchListener;
import com.youku.ticket.app.views.TicketFragmentPagerAdapter;

/**
 * @className Comments
 * @description TODO 主界面评论tab页的入口，包含热门评论和新上映影片评论两个fragment
 * @author QIAODI
 * @date 2014年12月26日 下午4:48:11
 */
public class Comments extends BaseTabFragment implements onOneCommentClickedListener{

    private FragmentManager mFragmentManager;

    private final String TAB_TAG = "comments";

    private ViewPager mViPager_comment;

    private ArrayList<Fragment> mFragmentList;

    private CommentListFragmentHot mCommentListHot;

    private Switch mHeaderSwitch;

    private Switch.OnSwitchListener mHeaderSwitchListener;

    private CommentListFragmentNew mCommentListNew;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mFragmentManager = getChildFragmentManager();
        YoukuTicketMainActivity.sFragmentStack.put(TAB_TAG, new ActiivtyStack(mFragmentManager));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayoutView = inflater.inflate(R.layout.comments_tab, container, false);
        mHeaderSwitch = (Switch) mLayoutView.findViewById(R.id.comment_header_switch);
        mHeaderSwitchListener = new OnSwitchListener() {

            @Override
            public boolean onTrySwitching(boolean onOff) {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public boolean onSwitchChanged(boolean onOff) {
                // TODO Auto-generated method stub
                Log.w(TAG,"onSwitchChanged "+onOff);
                mViPager_comment.setCurrentItem(onOff ? 1 : 0);
                return true;
            }
        };
        mHeaderSwitch.setOnSwitchListener(mHeaderSwitchListener);
        initCommentsViewPager();
        //		if(YoukuTicketMainApp.sFragmentStack.get(TAB_TAG).getFragmentSize() == 0){
        //			addListFragment();// default page
        //		}
        return mLayoutView;
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
    }

    /**
     * description: TODO 初始化页面
     * @creater QIAODI
     * @date 2014年12月26日 下午4:50:34
     * @editer 	
     */
    private void initCommentsViewPager() {
        mViPager_comment = (ViewPager) mLayoutView.findViewById(R.id.comments_viewpager);
        mFragmentList = new ArrayList<Fragment>();
        mCommentListHot = new CommentListFragmentHot();
        mCommentListHot.setCommentClickedListener(this);
        mFragmentList.add(mCommentListHot);
        mCommentListNew = new CommentListFragmentNew();
        mCommentListNew.setCommentClickedListener(this);
        mFragmentList.add(mCommentListNew);
        mViPager_comment.setAdapter(new TicketFragmentPagerAdapter(mFragmentManager, mFragmentList));
        mViPager_comment.setCurrentItem(0);
        mViPager_comment.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    
    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int status) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int postion, float scroll_percent, int scroll_px) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageSelected(int postion) {
            // TODO Auto-generated method stub
            mHeaderSwitch.setChecked(postion == 1);
        }

    }
    
    /**
     * description: TODO 根据用户选择的评论ID，进入评论详细页
     * @creater QIAODI
     * @param commentsID
     * @date 2014年12月26日 下午4:52:02
     * @editer 	
     */
    private void startCommentDetailsActivity(int commentsID)
    {
        Intent intent = new Intent();
        intent.setClass(getActivity(), CommentDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("CommentsID", commentsID);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onOneCommentClicked(int commentsID) {
        // TODO Auto-generated method stub
        startCommentDetailsActivity(commentsID);
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void CreateActionBarItem(Menu menu) {
        // TODO Auto-generated method stub
        MenuItemWriteComment item = new MenuItemWriteComment();
        item.ShowItem(getActivity(), menu);
    }

}
