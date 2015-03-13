/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CityInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className CityListResponseParser
 * @description 城市列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class CityListResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_CITYID = "cityId";

    private final String LABEL_BODY_CITYNAME = "cityName";

    private CityListResponseData responseData = new CityListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<CityInfo> cityList = new ArrayList<CityInfo>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            JSONObject bodyJsonObj = bodyJsonArr.getJSONObject(i);
            int cityId = bodyJsonObj.getInt(LABEL_BODY_CITYID);
            String cityName = bodyJsonObj.getString(LABEL_BODY_CITYNAME);

            CityInfo info = new CityInfo();
            info.setCityId(cityId);
            info.setCityName(cityName);
            cityList.add(info);
        }

        responseData.setCityList(cityList);
    }
}
