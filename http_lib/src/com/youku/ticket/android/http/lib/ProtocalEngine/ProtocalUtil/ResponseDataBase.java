/**
 * @title ResponseDataBase.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:50:00
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.RespHeadInfo;

/**
 * @className ResponseDataBase
 * @description 响应数据基础类
 * @author LLC
 * @date 2014-12-25 上午11:50:00
 */
public class ResponseDataBase {

    private RespHeadInfo headInfo;

    public ResponseDataBase() {
        headInfo = new RespHeadInfo();
    }

    /**
     * description: 返回响应头
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 上午11:51:41
     * @editer
     */
    public RespHeadInfo getHeadInfo() {
        return headInfo;
    }

    /**
     * description: 设置响应头
     * 
     * @creater LLC
     * @param headInfo
     * @date 2014-12-25 上午11:51:55
     * @editer
     */
    public void setHeadInfo(RespHeadInfo headInfo) {
        this.headInfo = headInfo;
    }
}
