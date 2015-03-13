package com.youku.ticket.app.pages.cinemasets;

import com.youku.ticket.app.templates.BaseDataProvider;

import android.os.Bundle;

public class CinemaListFragmentSelect extends CinemaListFragmentBase {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mAdapter = new CinemaListAdapterBase(getActivity(), CinemaListDataType.SELECT, mTargetMovie);
        setListAdapter(mAdapter);
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
