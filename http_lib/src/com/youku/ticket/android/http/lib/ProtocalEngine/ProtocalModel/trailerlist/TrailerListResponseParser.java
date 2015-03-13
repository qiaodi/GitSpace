/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.TrailerInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className TrailerListResponseParser
 * @description 预告片列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class TrailerListResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_PROMID = "promId";

    private final String LABEL_BODY_VIDEOID = "videoid";

    private final String LABEL_BODY_VIDEOURL = "videourl";

    private final String LABEL_BODY_TITLE = "title";

    private final String LABEL_BODY_SHOWLENGTH = "showLength";

    private final String LABEL_BODY_THUMBURL = "thumburl";

    private TrailerListResponseData responseData = new TrailerListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<TrailerInfo> trailerList = new ArrayList<TrailerInfo>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            JSONObject bodyJsonObj = bodyJsonArr.getJSONObject(i);
            int promId = bodyJsonObj.getInt(LABEL_BODY_PROMID);
            int videoid = bodyJsonObj.getInt(LABEL_BODY_VIDEOID);
            String videourl = bodyJsonObj.getString(LABEL_BODY_VIDEOURL);
            String title = bodyJsonObj.getString(LABEL_BODY_TITLE);
            int showLength = bodyJsonObj.getInt(LABEL_BODY_SHOWLENGTH);
            String thumburl = bodyJsonObj.getString(LABEL_BODY_THUMBURL);

            TrailerInfo info = new TrailerInfo();
            info.setPromId(promId);
            info.setVideoid(videoid);
            info.setVideourl(videourl);
            info.setTitle(title);
            info.setShowLength(showLength);
            info.setThumburl(thumburl);
            trailerList.add(info);
        }

        responseData.setTrailerList(trailerList);
    }
}
