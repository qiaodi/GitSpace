/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

/**
 * @className ResponsePkg
 * @description 响应数据包
 * @author LLC
 * @date 2014-12-22 下午5:26:45
 */
public class ResponsePkg {

    /** 接收数据 */
    private byte[] receiveData;

    private int command;

    public byte[] getReceiveData() {
        return receiveData;
    }

    public void setReceiveData(byte[] receiveData) {
        this.receiveData = receiveData;
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
