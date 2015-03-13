/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import java.net.Proxy;

/**
 * @className RequestPkg
 * @description 请求数据包
 * @author LLC
 * @date 2014-12-22 下午5:26:29
 */
public class RequestPkg {

    /** 发送地址 **/
    private String url = null;

    /** 发送数据 **/
    private byte[] sendData;

    /** 方法 **/
    private String method;

    /** 命令 **/
    private int command;

    /** 代理 */
    private Proxy proxy;

    /**
     * 代理
     * 
     * @return
     */
    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    /**
     * 发送地址
     * 
     * @return
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        System.out.println(url);

        this.url = url;
    }

    /**
     * 发送数据
     * 
     * @return
     */
    public byte[] getSendData() {
        return sendData;
    }

    public void setSendData(byte[] sendData) {
        this.sendData = sendData;
    }

    /**
     * 发送方式
     * 
     * @return
     */
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 命令
     * 
     * @return
     */
    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

}
