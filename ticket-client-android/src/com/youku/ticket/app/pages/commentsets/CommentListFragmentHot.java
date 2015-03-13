package com.youku.ticket.app.pages.commentsets;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseDataProvider;
import com.youku.ticket.app.templates.BaseListFragment;

/**
 * @className CommentList_Hot
 * @description TODO 热门评论List
 * @author QIAODI
 * @date 2014年12月26日 下午4:47:05
 */
public class CommentListFragmentHot extends BaseListFragment {

    private View mLayoutView;

    private CommentsListAdapterHot mAdapter = null;

    private FragmentManager mFragmentManager;

    private onOneCommentClickedListener mClickCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mAdapter = new CommentsListAdapterHot(getActivity());
        setListAdapter(mAdapter);
        mFragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayoutView = inflater.inflate(R.layout.common_list, container, false);

        return mLayoutView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println("Click On List Item " + position);
        super.onListItemClick(l, v, position, id);
        if (mClickCallback != null) {
            mClickCallback.onOneCommentClicked(position);
        }
    }

    public void setCommentClickedListener(onOneCommentClickedListener listener) {
        mClickCallback = listener;
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object updateRequesetParams() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return null;
    }

}
