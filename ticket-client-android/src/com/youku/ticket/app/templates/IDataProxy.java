package com.youku.ticket.app.templates;

/**
 * @className IDataProxy
 * @description TODO 数据请求接口
 * @author QIAODI
 * @date 2015年1月9日 下午4:12:17
 */
public interface IDataProxy {

    /**
     * description: TODO 发起数据请求，由具体的Provider具体实现
     * @creater QIAODI
     * @param requestData 
     * @date 2015年1月9日 下午4:10:42
     * @editer 	
     */
    public void requestDataUpdate(Object requestData);
}
