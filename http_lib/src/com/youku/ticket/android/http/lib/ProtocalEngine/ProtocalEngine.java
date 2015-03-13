/**
 * 
 */
package com.youku.ticket.android.http.lib.ProtocalEngine;

import android.content.Context;

import com.youku.ticket.android.http.lib.HttpUtil.ApnUtil;
import com.youku.ticket.android.http.lib.HttpUtil.HttpObserver;
import com.youku.ticket.android.http.lib.HttpUtil.HttpThread;
import com.youku.ticket.android.http.lib.HttpUtil.RequestPkg;
import com.youku.ticket.android.http.lib.HttpUtil.ResponsePkg;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ContructorObject;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ParserObject;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestMap;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseMap;
import com.youku.ticket.android.http.lib.common.Logger;
import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className ProtocalEngine
 * @description 协议引擎
 * @author LLC
 * @date 2014-12-22 下午5:34:55
 */
public class ProtocalEngine implements HttpObserver {

    private final String TAG = "ProtocalEngine";

    private Context mContext = null;

    public ProtocalEngine(Context context) {
        this.mContext = context;
    }

    /**
     * description: 请求函数
     * 
     * @creater LLC
     * @param aObserver 协议观察者
     * @param command 命令
     * @param obj 请求对象
     * @date 2014-12-25 下午1:40:10
     * @editer
     */
    public void request(ProtocalObserver aObserver, int command, Object obj) {
        try {
            requestProtocal(aObserver, obj, command);
        } catch (InstantiationException e) {
            Exception(aObserver, e);
        } catch (IllegalAccessException e) {
            Exception(aObserver, e);
        }
    }

    private void requestProtocal(ProtocalObserver aObserver, Object obj, int command) throws InstantiationException, IllegalAccessException {

        // 匹配不同功能协议数据构造器
        Class<?> cls = RequestMap.sRequestMap.get(command);
        ContructorObject pObj = (ContructorObject) cls.newInstance();
        pObj.setCommand(command);
        pObj.setObj(obj);

        // 生成请求数据包
        RequestPkg requestPkg = new RequestPkg();
        requestPkg.setCommand(command);
        requestPkg.setUrl(pObj.getUrl());
        requestPkg.setProxy(ApnUtil.getApnProxy(this.mContext));
        requestPkg.setSendData(pObj.getSendData());

        new HttpThread(this, aObserver, requestPkg);
    }

    @Override
    public void OnCompleted(ProtocalObserver aObserver, ResponsePkg responsePkg) {
        try {
            responseProtocal(aObserver, responsePkg);
        } catch (java.lang.Exception e) {
            Exception(aObserver, e);
        }
    }

    private void responseProtocal(ProtocalObserver aObserver, ResponsePkg responsePkg) throws java.lang.Exception {
        // 匹配不同的功能解析器
        Class<?> cls = ResponseMap.sResponseMap.get(responsePkg.getCommand());
        ParserObject pObj = (ParserObject) cls.newInstance();
        aObserver.onProtocalSuccess(pObj.getResponseData(responsePkg.getReceiveData()));
    }

    @Override
    public void Exception(ProtocalObserver aObserver, Exception exception) {
        aObserver.onProtocalError(Integer.valueOf(-1));

        Logger.log(TAG, "异常抛出");
        exception.printStackTrace();
    }

    @Override
    public void OnStoped() {

    }
}
