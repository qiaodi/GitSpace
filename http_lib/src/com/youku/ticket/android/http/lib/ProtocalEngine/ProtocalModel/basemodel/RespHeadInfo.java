/**
 * @title RespResultInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午10:34:34
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className RespResultInfo
 * @description 响应头信息
 * @author LLC
 * @date 2014-12-25 上午10:34:34
 */
public class RespHeadInfo {

    //服务方名称
    private String provider = "youku";

    //错误代码
    private int code = -1;

    //错误描述
    private String desc = "网络异常";

    /**
     * description: 返回服务方名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 上午10:41:25
     * @editer
     */
    public String getProvider() {
        return provider;
    }

    /**
     * description: 设置服务方名称
     * 
     * @creater LLC
     * @param provider
     * @date 2014-12-25 上午10:41:40
     * @editer
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * description: 返回错误代码
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 上午10:41:55
     * @editer
     */
    public int getCode() {
        return code;
    }

    /**
     * description: 设置错误代码
     * 
     * @creater LLC
     * @param code
     * @date 2014-12-25 上午10:42:07
     * @editer
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * description: 返回错误描述
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 上午10:42:20
     * @editer
     */
    public String getDesc() {
        return desc;
    }

    /**
     * description: 设置错误描述
     * 
     * @creater LLC
     * @param desc
     * @date 2014-12-25 上午10:42:31
     * @editer
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
