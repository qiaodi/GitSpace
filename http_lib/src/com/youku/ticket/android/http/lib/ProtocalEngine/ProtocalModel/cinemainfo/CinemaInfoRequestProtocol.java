/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className CinemaInfoRequestProtocol
 * @description 影院信息请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class CinemaInfoRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/cinema/cinema_info.json" + getRequestGetData();
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
        CinemaInfoRequestData requestData = (CinemaInfoRequestData) getObj();
        int cinemaId = requestData.getCinemaId();

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("cinemaId");
        sb.append("=");
        sb.append(cinemaId);

        return sb.toString();
    }

}
