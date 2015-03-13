package com.youku.ticket.app.templates;

import android.content.Context;
import android.util.Log;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalEngine;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ErrorCode;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;
import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className BaseDataProvider
 * @description TODO 视图的数据处理中心
 * @author QIAODI
 * @date 2015年1月9日 下午4:12:55
 */
public abstract class BaseDataProvider implements ProtocalObserver, IDataProxy {

    protected final String TAG = this.getClass().getSimpleName();

    protected ProtocalEngine mEngine;

    public BaseDataProvider(Context context) {
        // TODO Auto-generated constructor stub
        mEngine = new ProtocalEngine(context);
    }

    protected IDataUpdatedCb mDataUpdatedCb;

    public void setDataUpdatedCb(IDataUpdatedCb dataUpdatedCb) {
        this.mDataUpdatedCb = dataUpdatedCb;
    }

    @Override
    public void onProtocalSuccess(Object paramObject) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onProtocalSuccess");
        if (((ResponseDataBase) paramObject).getHeadInfo().getCode() == ErrorCode.OK) {
            if (mDataUpdatedCb != null) {
                mDataUpdatedCb.onDataUpdatedCb(paramObject);
            }
        }
    }

    @Override
    public void onProtocalError(Object paramObject) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProtocalProcess(Object paramObject) {
        // TODO Auto-generated method stub

    }

}
