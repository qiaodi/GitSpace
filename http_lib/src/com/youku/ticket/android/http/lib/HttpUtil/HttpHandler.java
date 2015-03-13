/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import com.youku.ticket.android.http.lib.common.Logger;

/**
 * @className HttpHandler
 * @description HTTP处理程序
 * @author LLC
 * @date 2014-12-22 下午5:25:13
 */
public class HttpHandler {

    private RequestPkg mRequestPkg = null;

    private HttpTransaction mHttpTransaction = null;

    /**
     * 构造函数
     * 
     * @param requestPkg 请求数据包
     */
    public HttpHandler(RequestPkg requestPkg) {
        this.mRequestPkg = requestPkg;
        String url = requestPkg.getUrl();
        Logger.log("URLData", url);
        this.mHttpTransaction = new HttpTransaction(url, requestPkg.getSendData());
    }

    /**
     * description: 返回响应数据包
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午5:33:24
     * @editer
     */
    public ResponsePkg getResponse() {
        ResponsePkg responsePkg = new ResponsePkg();
        responsePkg.setCommand(this.mRequestPkg.getCommand());
        responsePkg.setReceiveData(this.mHttpTransaction.getReceiveData(this.mRequestPkg.getProxy()));
        return responsePkg;
    }
}
