/**
 * @title BaseActivity.java
 * @package com.example.youkudemo
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午1:58:12
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalEngine;
import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className BaseActivity
 * @description 基础Activity
 * @author LLC
 * @date 2014-12-25 下午1:58:12
 */
public abstract class BaseActivity extends Activity implements ProtocalObserver, OnClickListener, OnItemClickListener {

    protected ProtocalEngine mEngine = new ProtocalEngine(this);

    @SuppressLint("HandlerLeak")
    protected Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            parserMessage(msg);
        }
    };

    /**
     * description: 处理HANDLER MESSAGE
     * 
     * @creater LLC
     * @param msg 消息包
     * @date 2014-12-25 下午2:14:20
     * @editer
     */
    protected void parserMessage(Message msg) {
    }

    /**
     * description: 初始化函数
     * 
     * @creater LLC
     * @date 2014-12-25 下午1:55:44
     * @editer
     */
    protected void init() {
        initView();
        initData();
    }

    /**
     * description: 初始化数据函数
     * 
     * @creater LLC
     * @date 2014-12-25 下午2:00:02
     * @editer
     */
    protected abstract void initData();

    /**
     * description: 初始化View函数
     * 
     * @creater LLC
     * @date 2014-12-25 下午1:59:15
     * @editer
     */
    protected abstract void initView();

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onProtocalProcess(Object paramObject) {

    }
}
