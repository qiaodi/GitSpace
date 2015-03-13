/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.DistrictInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className DistrictResponseParser
 * @description 城区列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class DistrictListResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_ID = "id";

    private final String LABEL_BODY_NAME = "name";

    private DistrictListResponseData responseData = new DistrictListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<DistrictInfo> districtList = new ArrayList<DistrictInfo>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            JSONObject bodyJsonObj = bodyJsonArr.getJSONObject(i);
            String districtId = bodyJsonObj.getString(LABEL_BODY_ID);
            String districtName = bodyJsonObj.getString(LABEL_BODY_NAME);

            DistrictInfo info = new DistrictInfo();
            info.setDistrictId(districtId);
            info.setDistrictName(districtName);
            districtList.add(info);
        }

        responseData.setDistrictList(districtList);
    }
}
