package com.youku.ticket.app.pages.cinemasets;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseListFragment;
import com.youku.ticket.app.templates.IDataProxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @className CinemaListFragment
 * @description TODO 影院列表fragment
 * @author QIAODI
 * @date 2014年12月26日 下午4:41:33
 */
public abstract class CinemaListFragmentBase extends BaseListFragment {

    public CinemaListAdapterBase mAdapter;
    
    public View mLayoutView;

    /**
     * @className CinemaListDataType
     * @description TODO 对应 全部，选座，团购三种查询方式
     * @author QIAODI
     * @date 2014年12月26日 下午4:41:55
     */
    public enum CinemaListDataType {
        ALL, SELECT, SALES
    };

    public int mTargetMovie = -1;

    
    public CinemaListFragmentBase() {
        // TODO Auto-generated constructor stub
    }

    public CinemaListFragmentBase(int targetMovie) {
        // TODO Auto-generated constructor stub
        mTargetMovie = targetMovie;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        mLayoutView = inflater.inflate(R.layout.common_list, container, false);
        return mLayoutView;
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
//        testReqCinemaList();
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.w(TAG, "onListItemClick position" + position);
        super.onListItemClick(l, v, position, id);
        startCinemaScheduleActivity(position);
    }

    /**
     * description: TODO 切换到影院排片表
     * @creater QIAODI
     * @param cinemaID
     * @date 2014年12月26日 下午4:42:51
     * @editer 	
     */
    public void startCinemaScheduleActivity(int cinemaID) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), CinemaScheduleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("CinemaID", cinemaID);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
