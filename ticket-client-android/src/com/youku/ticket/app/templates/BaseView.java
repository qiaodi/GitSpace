package com.youku.ticket.app.templates;

import android.view.View;

/**
 * @className BaseView
 * @description TODO ViewHolder类的基类
 * @author QIAODI
 * @date 2015年1月9日 下午4:14:10
 */
public abstract class BaseView {

    /**
     * <p>Title: </p>
     * <p>Description: </p> 包含内部子控件初始化
     * @param node 布局文件对应的ViewGroup
     */
    public BaseView(View node) {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * description: TODO 根据数据刷新
     * @creater QIAODI
     * @param data
     * @date 2015年1月9日 下午4:16:50
     * @editer 	
     */
    abstract public void setView(Object data);
}
