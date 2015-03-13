/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo;

import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className CinemaInfoResponseParser
 * @description 影院信息响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class CinemaInfoResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_CINEMAID = "cinemaId";

    private final String LABEL_BODY_CINEMANAME = "cinemaName";

    private final String LABEL_BODY_TELPHONE = "telphone";

    private final String LABEL_BODY_MAPLON = "mapLon";

    private final String LABEL_BODY_MAPLAT = "mapLat";

    private final String LABEL_BODY_DISTRICTID = "districtId";

    private final String LABEL_BODY_ROUTE = "route";

    private final String LABEL_BODY_ADDRESS = "address";

    private final String LABEL_BODY_INTRO = "intro";

    private CinemaInfoResponseData responseData = new CinemaInfoResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        JSONObject bodyJsonObj = this.jsonObject.getJSONObject(TAG_BODY);

        int cinemaId = bodyJsonObj.getInt(LABEL_BODY_CINEMAID);
        String cinemaName = bodyJsonObj.getString(LABEL_BODY_CINEMANAME);
        String telphone = bodyJsonObj.getString(LABEL_BODY_TELPHONE);
        double mapLon = bodyJsonObj.getDouble(LABEL_BODY_MAPLON);
        double mapLat = bodyJsonObj.getDouble(LABEL_BODY_MAPLAT);
        int districtId = bodyJsonObj.getInt(LABEL_BODY_DISTRICTID);
        String route = bodyJsonObj.getString(LABEL_BODY_ROUTE);
        String address = bodyJsonObj.getString(LABEL_BODY_ADDRESS);
        String intro = bodyJsonObj.getString(LABEL_BODY_INTRO);

        CinemaInfo cinemaInfo = new CinemaInfo();
        cinemaInfo.setCinemaId(cinemaId);
        cinemaInfo.setCinemaName(cinemaName);
        cinemaInfo.setTelphone(telphone);
        cinemaInfo.setMapLon(mapLon);
        cinemaInfo.setMapLat(mapLat);
        cinemaInfo.setDistrictId(districtId);
        cinemaInfo.setRoute(route);
        cinemaInfo.setAddress(address);
        cinemaInfo.setIntro(intro);

        responseData.setCinemaInfo(cinemaInfo);
    }
}
