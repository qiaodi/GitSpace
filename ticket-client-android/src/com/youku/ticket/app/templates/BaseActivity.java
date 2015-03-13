package com.youku.ticket.app.templates;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.youku.ticket.R;
import com.youku.ticket.utils.TextDrawable;

/**
 * @className BaseActivity
 * @description TODO activity基类
 * @author QIAODI
 * @date 2015年1月9日 下午4:20:41
 */
public abstract class BaseActivity extends ActionBarActivity implements IDataUpdatedCb {

    protected BaseDataProvider mDataProvider;

    protected final String TAG = this.getClass().getSimpleName();
    
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mDataProvider = creatDataProvider();
        setDataUpdatedCb();
    }

    /**
     * description: TODO 创建数据引擎
     * @creater QIAODI
     * @return 
     * @date 2015年1月30日 下午2:53:19
     * @editer 	
     */
    public abstract BaseDataProvider creatDataProvider();

    private void setDataUpdatedCb() {
        // TODO Auto-generated method stub
        try {
            mDataProvider.setDataUpdatedCb(this);
        } catch (NullPointerException e) {
            Log.e(TAG, "should init mDataProvider in subclass first");
        }
    }

    /**
     * description: TODO 设置activity导航条
     * @creater QIAODI
     * @param isHomePage 是否是一级页面，一级页面显示地点信息，非一级页面显示返回按钮
     * @date 2015年1月20日 下午5:36:44
     * @editer 	
     */
    public void addAppBar(boolean isHomePage) {
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        setNavigationIcon(isHomePage);
    }

    private void setNavigationIcon(boolean isHomePage) {
        // TODO Auto-generated method stub
        if (isHomePage) {
            TextDrawable td = new TextDrawable(getApplicationContext());
            td.setText("巴彦淖尔");
            td.setTextColor(Color.BLACK);
            mToolbar.setNavigationIcon(td);
//            mToolbar.setLogo(R.drawable.actionbar_more_normal);
            mToolbar.setNavigationOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "Navigation OnClick");
                }
            });
        } else {
            mToolbar.setNavigationIcon(R.drawable.actionbar_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "Navigation OnClick");
                    onBackPressed();
                }
            });
        }
    }

    public Toolbar getAppBar() {
        return mToolbar;
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
