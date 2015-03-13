/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className SearchCinemaResponseParser
 * @description 搜索影院响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class SearchCinemaResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_PAGESIZE = "pageSize";

    private final String LABEL_BODY_PAGECOUNT = "pageCount";

    private final String LABEL_BODY_COUNT = "count";

    private final String LABEL_BODY_PAGENO = "pageNo";

    private final String TAG_BODY_DATALIST = "dataList";

    private final String LABEL_BODY_DATALIST_CINEMAID = "cinemaId";

    private final String LABEL_BODY_DATALIST_CINEMANAME = "cinemaName";

    private final String LABEL_BODY_DATALIST_CITYID = "cityId";

    private final String LABEL_BODY_DATALIST_DISTRICTID = "districtId";

    private final String LABEL_BODY_DATALIST_PLANCOUNT = "planCount";

    private final String LABEL_BODY_DATALIST_LOWPRICE = "lowPrice";

    private final String LABEL_BODY_DATALIST_ADDRESS = "address";

    private final String LABEL_BODY_DATALIST_TELPHONE = "telphone";

    private final String LABEL_BODY_DATALIST_MAPLON = "mapLon";

    private final String LABEL_BODY_DATALIST_MAPLAT = "mapLat";

    private final String LABEL_BODY_DATALIST_DISTANCE = "distance";

    private SearchCinemaResponseData responseData = new SearchCinemaResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<CinemaInfo> cinemaList = new ArrayList<CinemaInfo>();

        JSONObject bodyJsonObj = this.jsonObject.getJSONObject(TAG_BODY);
        int pageSize = bodyJsonObj.getInt(LABEL_BODY_PAGESIZE);
        int pageCount = bodyJsonObj.getInt(LABEL_BODY_PAGECOUNT);
        int count = bodyJsonObj.getInt(LABEL_BODY_COUNT);
        int pageNo = bodyJsonObj.getInt(LABEL_BODY_PAGENO);

        JSONArray dataList = bodyJsonObj.getJSONArray(TAG_BODY_DATALIST);

        for (int i = 0; i < dataList.length(); i++) {
            JSONObject dataJsonObj = dataList.getJSONObject(i);
            int cinemaId = dataJsonObj.getInt(LABEL_BODY_DATALIST_CINEMAID);
            String cinemaName = dataJsonObj.getString(LABEL_BODY_DATALIST_CINEMANAME);
            int cityId = dataJsonObj.getInt(LABEL_BODY_DATALIST_CITYID);
            int districtId = dataJsonObj.getInt(LABEL_BODY_DATALIST_DISTRICTID);
            int planCount = dataJsonObj.getInt(LABEL_BODY_DATALIST_PLANCOUNT);
            int lowPrice = dataJsonObj.getInt(LABEL_BODY_DATALIST_LOWPRICE);
            String address = dataJsonObj.getString(LABEL_BODY_DATALIST_ADDRESS);
            String telphone = dataJsonObj.getString(LABEL_BODY_DATALIST_TELPHONE);
            double mapLon = dataJsonObj.getDouble(LABEL_BODY_DATALIST_MAPLON);
            double mapLat = dataJsonObj.getDouble(LABEL_BODY_DATALIST_MAPLAT);
            int distance = dataJsonObj.getInt(LABEL_BODY_DATALIST_DISTANCE);

            CinemaInfo info = new CinemaInfo();
            info.setCinemaId(cinemaId);
            info.setCinemaName(cinemaName);
            info.setCityId(cityId);
            info.setDistrictId(districtId);
            info.setPlanCount(planCount);
            info.setLowPrice(lowPrice);
            info.setAddress(address);
            info.setTelphone(telphone);
            info.setMapLon(mapLon);
            info.setMapLat(mapLat);
            info.setDistance(distance);
            cinemaList.add(info);
        }

        responseData.setPageSize(pageSize);
        responseData.setPageCount(pageCount);
        responseData.setCount(count);
        responseData.setPageNo(pageNo);
        responseData.setCinemaList(cinemaList);
    }
}
