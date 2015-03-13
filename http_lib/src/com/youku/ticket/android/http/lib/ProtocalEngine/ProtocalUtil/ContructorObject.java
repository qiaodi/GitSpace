/**
 * 
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil;

import com.youku.ticket.android.http.lib.common.UrlDef;

/**
 * @className ContructorObject
 * @description 构造器对象
 * @author LLC
 * @date 2014-12-25 上午10:28:13
 */
public class ContructorObject {

    private Object obj = null;

    private int command = 0;

    public ContructorObject() {

    }

    /**
     * description: 设置请求对象
     * 
     * @creater LLC
     * @param obj
     * @date 2014-12-22 下午5:53:52
     * @editer
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * description: 返回请求对象
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午3:56:45
     * @editer
     */
    public Object getObj() {
        return obj;
    }

    /**
     * description: 设置命令
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-22 下午5:53:00
     * @editer
     */
    public void setCommand(int command) {
        this.command = command;
    }

    /**
     * description: 返回命令
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:04:25
     * @editer
     */
    public int getCommand() {
        return command;
    }

    /**
     * description: 服务器地址
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:18:19
     * @editer
     */
    public String getUrl() {
        return UrlDef.getServerUrl();
    }

    public byte[] getSendData() {
        return null;
    }
}
