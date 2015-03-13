package com.youku.ticket.app.templates;

import com.youku.ticket.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * @className BaseTabFragment
 * @description TODO Tab页风格的Fragment（布局容器）
 * @author QIAODI
 * @date 2015年1月9日 下午4:19:34
 */
public abstract class BaseTabFragment extends Fragment implements IDataUpdatedCb {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * @fields mDataProvider : TODO 数据处理中心基类..暂时没有继承类使用
     */
    protected BaseDataProvider mDataProvider;

    /**
     * @fields mLayoutView : TODO xml布局
     */
    protected View mLayoutView;

    private ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setDataUpdatedCb();
        setHasOptionsMenu(true);
    }

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        CreateActionBarItem(menu);
    }

    /**
     * description: TODO 由各Tab根据UI需求具体实现
     * @creater QIAODI
     * @param menu
     * @date 2015年1月20日 下午5:35:06
     * @editer 	
     */
    abstract public void CreateActionBarItem(Menu menu);
    
    /**
     * description: TODO 初始化载入界面
     * @creater QIAODI
     * @date 2015年1月20日 下午5:35:41
     * @editer 	
     */
    public void initLoadingIndicator() {
        // TODO Auto-generated method stub
        mProgressBar = (ProgressBar) mLayoutView.findViewById(R.id.loading);
        if (mProgressBar != null) mProgressBar.setIndeterminate(false);
    }

    /**
     * description: TODO 显示载入动画
     * @creater QIAODI
     * @date 2015年1月20日 下午5:35:57
     * @editer 	
     */
    public void showLoadingIndicator() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.VISIBLE);
    }

    /**
     * description: TODO 隐藏载入动画
     * @creater QIAODI
     * @date 2015年1月20日 下午5:36:13
     * @editer 	
     */
    public void hideLoadingIndicator() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.GONE);
    }
}
