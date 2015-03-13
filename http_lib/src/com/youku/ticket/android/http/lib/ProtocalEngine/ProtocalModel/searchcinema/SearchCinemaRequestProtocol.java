/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className SearchCinemaRequestProtocol
 * @description 搜索影院请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class SearchCinemaRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/cinema/search_cinema.json" + getRequestGetData();
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
        SearchCinemaRequestData requestData = (SearchCinemaRequestData) getObj();

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("cityId");
        sb.append("=");
        sb.append(requestData.getCityId());

        sb.append("&");
        sb.append("queryword");
        sb.append("=");
        sb.append(requestData.getQueryword());

        //每页数量，第几页
        if (requestData.getPageSize() != -1 && requestData.getPageNo() != -1) {
            sb.append("&");
            sb.append("pageSize");
            sb.append("=");
            sb.append(requestData.getPageSize());
            sb.append("&");
            sb.append("pageNo");
            sb.append("=");
            sb.append(requestData.getPageNo());
        }

        //纬度，经度
        if (requestData.getMapLat() != -1 && requestData.getMapLon() != -1) {
            sb.append("&");
            sb.append("mapLat");
            sb.append("=");
            sb.append(requestData.getMapLat());
            sb.append("&");
            sb.append("mapLon");
            sb.append("=");
            sb.append(requestData.getMapLon());
        }

        return sb.toString();
    }

}
