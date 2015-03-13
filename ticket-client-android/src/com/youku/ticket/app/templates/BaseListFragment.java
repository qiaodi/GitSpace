package com.youku.ticket.app.templates;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;

/**
 * @className BaseListFragment
 * @description TODO List风格的Fragment（数据容器）
 * @author QIAODI
 * @date 2015年1月9日 下午4:20:10
 */
public abstract class BaseListFragment extends ListFragment implements IDataUpdatedCb {

    protected final String TAG = this.getClass().getSimpleName();
    
    /**
     * @fields mDataProvider : TODO 数据处理中心基类
     */
    protected BaseDataProvider mDataProvider;

    /**
     * @fields mRequestData : TODO 请求数据时的参数
     */
    private Object mRequestData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mDataProvider = creatDataProvider();
        setDataUpdatedCb();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        updatePageData();
    }
    
    /**
     * description: TODO 请求更新页面数据
     * @creater QIAODI
     * @date 2015年1月20日 下午5:30:33
     * @editer 	
     */
    public void updatePageData(){
        mRequestData = updateRequesetParams();
        if(mRequestData != null){
            mDataProvider.requestDataUpdate(mRequestData);
        }else{
            Log.w(TAG,"the request shouldn't null if want updatePageData");
        }
    }
    
    /**
     * description: TODO 更新请求数据时需要的参数
     * @creater QIAODI
     * @return
     * @date 2015年1月20日 下午5:32:56
     * @editer 	
     */
    abstract public Object updateRequesetParams();
    
    /**
     * description: TODO 设置获取数据时的回调
     * @creater QIAODI
     * @date 2015年1月20日 下午5:27:05
     * @editer  
     */
    private void setDataUpdatedCb() {
        // TODO Auto-generated method stub
        try {
            mDataProvider.setDataUpdatedCb(this);
        } catch (NullPointerException e) {
            Log.e(TAG, "should init mDataProvider in subclass first");
        }
    }
    
    /**
     * description: TODO 创建数据引擎
     * @creater QIAODI
     * @return
     * @date 2015年1月30日 下午2:53:53
     * @editer 	
     */
    public abstract BaseDataProvider creatDataProvider();
}
