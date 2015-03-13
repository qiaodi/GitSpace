/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className HttpThread
 * @description Http访问线程
 * @author LLC
 * @date 2014-12-22 下午5:25:47
 */
public class HttpThread implements Runnable {

    private RequestPkg mRequestPkg = null;

    private ProtocalObserver mProtocalObserver = null;

    private HttpObserver mHttpObserver = null;

    public HttpThread(HttpObserver httpObserver, ProtocalObserver observer, RequestPkg requestPkg) {
        this.mHttpObserver = httpObserver;
        this.mProtocalObserver = observer;
        this.mRequestPkg = requestPkg;

        ThreadPoolFactory.getInstance().execute(this);
    }

    @Override
    public void run() {
        try {
            ResponsePkg responsePkg = connect();
            this.mHttpObserver.OnCompleted(this.mProtocalObserver, responsePkg);
        } catch (Exception e) {
            this.mHttpObserver.Exception(this.mProtocalObserver, e);
        }
    }

    private ResponsePkg connect() {
        return new HttpHandler(this.mRequestPkg).getResponse();
    }

}
