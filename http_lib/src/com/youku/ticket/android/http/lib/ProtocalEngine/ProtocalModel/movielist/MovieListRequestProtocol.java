/**
 * @title CityListRequestProtocol.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestProtocolBase;

/**
 * @className MovieListRequestProtocol
 * @description 影片列表请求协议构造器
 * @author LLC
 * @date 2014-12-22 下午6:09:46
 */
public class MovieListRequestProtocol extends RequestProtocolBase {

    @Override
    public String getUrl() {
        return super.getUrl() + "v1/base/movie/movie_list.json" + getRequestGetData();
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
        MovieListRequestData requestData = (MovieListRequestData) getObj();
        int cityId = requestData.getCityId();
        int cinemaId = requestData.getCinemaId();

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("cityId");
        sb.append("=");
        sb.append(cityId);

        if (cinemaId != 0) {
            sb.append("&");
            sb.append("cinemaId");
            sb.append("=");
            sb.append(cinemaId);
        }

        return sb.toString();
    }
}
