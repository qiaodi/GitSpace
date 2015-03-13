/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist;

import java.util.ArrayList;

import org.json.JSONArray;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className CinemaPlanTimeListResponseParser
 * @description 影院上映时间列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class CinemaPlanTimeListResponseParser extends ResponseParserBase {

    private CinemaPlanTimeListResponseData responseData = new CinemaPlanTimeListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<String> planTimeList = new ArrayList<String>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            String planTime = bodyJsonArr.getString(i);
            planTimeList.add(planTime);
        }

        responseData.setPlanTimeList(planTimeList);
    }
}
