package com.youku.ticket.app.pages.cinemasets;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.SortType;
import com.youku.ticket.app.templates.BaseDataProvider;
import com.youku.ticket.app.templates.IDataProxy;

import android.os.Bundle;
import android.util.Log;

public class CinemaListFragmentAll extends CinemaListFragmentBase {

    protected String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mAdapter = new CinemaListAdapterBase(getActivity(), CinemaListDataType.ALL, mTargetMovie);
        setListAdapter(mAdapter);
    }
    
    @Override
    public Object updateRequesetParams(){
        CinemaListRequestData requestData = new CinemaListRequestData();
        requestData.setCityId(440300);
        requestData.setPageSize(10);
        requestData.setPageNo(1);
        requestData.setMapLat(22.537491);
        requestData.setMapLon(114.05975);
        requestData.setSortType(SortType.DISTANCE_ASC);
        return requestData;
    }
    
    @Override
    public void onDataUpdatedCb(final Object response_data) {
        // TODO Auto-generated method stub
        Log.w(TAG,"onDataUpdatedCb");
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                CinemaListResponseData data = (CinemaListResponseData) response_data;
                ArrayList<CinemaInfo> cinemaList = data.getCinemaList();
                mAdapter.setData(cinemaList);
            }
        });
    }

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return new CinemaListFragmentAllDataProvider(getActivity());
    }
}
