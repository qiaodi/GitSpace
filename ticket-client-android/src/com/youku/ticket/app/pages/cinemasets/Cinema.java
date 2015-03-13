package com.youku.ticket.app.pages.cinemasets;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.cinemasets.CinemaListFragmentBase.CinemaListDataType;
import com.youku.ticket.app.pages.homepage.YoukuTicketMainActivity;
import com.youku.ticket.app.templates.BaseTabFragment;
import com.youku.ticket.app.utils.ActiivtyStack;
import com.youku.ticket.app.views.MenuItemSearch;

/**
 * @className Cinema
 * @description TODO 主界面上的影院tab页
 * @author QIAODI
 * @date 2014年12月26日 下午4:37:19
 */
public class Cinema extends BaseTabFragment {

    private FragmentManager mFragmentManager;

    private final String TAB_TAG = "cinema";

    private RadioGroup mRadioGroup;

    /**
     * @fields mOnCheckedChangeListener : TODO 用来监听用户对全部，选座，团购按钮的点击，根据用户的选择，更新列表内容
     */
    private OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener() {
        
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // TODO Auto-generated method stub
            Log.w(TAB_TAG,"onCheckedChanged checkedId " + checkedId);
            switch (checkedId) {
                case R.id.cinema_radio_all:
                    updateListfragment(CinemaListDataType.ALL);
                    break;
                case R.id.cinema_radio_select:
                    updateListfragment(CinemaListDataType.SELECT);
                    break;
                case R.id.cinema_radio_sales:
                    updateListfragment(CinemaListDataType.SALES);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.w(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mFragmentManager = getChildFragmentManager();
        YoukuTicketMainActivity.sFragmentStack.put(TAG, new ActiivtyStack(mFragmentManager));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.w(TAG, "onCreateView");
        mLayoutView = inflater.inflate(R.layout.cinema, null);
        mRadioGroup = (RadioGroup) mLayoutView.findViewById(R.id.cinema_radio_groups);
        mRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
        updateListfragment(CinemaListDataType.ALL);
        return mLayoutView;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        Log.w(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        Log.w(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        Log.w(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        Log.w(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        Log.w(TAG, "onStop");
        super.onStop();
    }

    /**
     * description: TODO 更新tab页中影院列表的具体内容。
     * @creater QIAODI
     * @param type 
     * @date 2014年12月26日 下午4:38:06
     * @editer 	
     */
    private void updateListfragment(CinemaListDataType type){
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if(type == CinemaListDataType.ALL)
            ft.replace(R.id.cinema_fragment_container, new CinemaListFragmentAll());
        else if(type == CinemaListDataType.SELECT)
            ft.replace(R.id.cinema_fragment_container, new CinemaListFragmentSelect());
        else if(type == CinemaListDataType.SALES)
            ft.replace(R.id.cinema_fragment_container, new CinemaListFragmentSales());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
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
