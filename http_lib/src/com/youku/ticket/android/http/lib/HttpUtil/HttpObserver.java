/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className HttpObserver
 * @description Http观察者
 * @author LLC
 * @date 2014-12-22 下午5:25:32
 */
public abstract interface HttpObserver {

    public abstract void OnCompleted(ProtocalObserver observer, ResponsePkg responsePkg);

    public abstract void Exception(ProtocalObserver observer, Exception exception);

    public abstract void OnStoped();
}
