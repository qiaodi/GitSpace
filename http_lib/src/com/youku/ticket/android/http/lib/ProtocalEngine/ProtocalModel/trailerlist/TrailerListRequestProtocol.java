/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className TrailerListRequestProtocol
 * @description 预告片列表请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class TrailerListRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/trailer/trailer_list.json" + getRequestGetData();
    }

    /**
     * description: 返回请求get数据
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午3:59:15
     * @editer
     */
    private String getRequestGetData() {
        TrailerListRequestData requestData = (TrailerListRequestData) getObj();

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("promId");
        sb.append("=");
        sb.append(requestData.getPromId());
        return sb.toString();
    }
}
