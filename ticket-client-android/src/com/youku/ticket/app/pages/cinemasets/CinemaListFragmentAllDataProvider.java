package com.youku.ticket.app.pages.cinemasets;

import android.content.Context;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.SortType;
import com.youku.ticket.app.templates.BaseDataProvider;
import com.youku.ticket.app.utils.DataExchangeProxy;

public class CinemaListFragmentAllDataProvider extends BaseDataProvider {

    public CinemaListFragmentAllDataProvider(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void requestDataUpdate(Object requestData) {
        // TODO Auto-generated method stub
        DataExchangeProxy.getInstance().requestCinemaList(mEngine, this, (CinemaListRequestData)requestData);
    }

    @Override
    public void onProtocalSuccess(Object paramObject) {
        // TODO Auto-generated method stub
        super.onProtocalSuccess(paramObject);
    }

}
