/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className PlanListRequestProtocol
 * @description 排期列表请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class PlanListRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/plan/plan_list.json" + getRequestGetData();
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
        PlanListRequestData requestData = (PlanListRequestData) getObj();
        int cinemaId = requestData.getCinemaId();
        int promId = requestData.getPromId();

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("cinemaId");
        sb.append("=");
        sb.append(cinemaId);

        sb.append("&");
        sb.append("promId");
        sb.append("=");
        sb.append(promId);

        return sb.toString();
    }

}
