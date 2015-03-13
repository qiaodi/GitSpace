/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.PlanInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className PlanListResponseParser
 * @description 城市列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class PlanListResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_PLANID = "planId";

    private final String LABEL_BODY_SITEPLANID = "sitePlanId";

    private final String LABEL_BODY_CITYID = "cityId";

    private final String LABEL_BODY_SITECITYID = "siteCityId";

    private final String LABEL_BODY_SITEID = "siteId";

    private final String LABEL_BODY_CINEMAID = "cinemaId";

    private final String LABEL_BODY_SITECINEMAID = "siteCinemaId";

    private final String LABEL_BODY_PROMID = "promId";

    private final String LABEL_BODY_SITEPROMID = "sitePromId";

    private final String LABEL_BODY_PLANDATE = "planDate";

    private final String LABEL_BODY_CURRENTTIME = "currentTime";

    private final String LABEL_BODY_BUYENDTIME = "buyEndTime";

    private final String LABEL_BODY_PLANSTARTTIME = "planStartTime";

    private final String LABEL_BODY_PLANENDTIME = "planEndTime";

    private final String LABEL_BODY_PLANLG = "planLg";

    private final String LABEL_BODY_PLANVERSION = "planVersion";

    private final String LABEL_BODY_STANDARDPRICE = "standardPrice";

    private final String LABEL_BODY_SOKUPRICE = "sokuPrice";

    private final String LABEL_BODY_HALLNAME = "hallName";

    private final String LABEL_BODY_TICKETID = "ticketId";

    private final String LABEL_BODY_AGENTID = "agentId";

    private PlanListResponseData responseData = new PlanListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<PlanInfo> planList = new ArrayList<PlanInfo>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            JSONObject bodyJsonObj = bodyJsonArr.getJSONObject(i);
            int planId = bodyJsonObj.getInt(LABEL_BODY_PLANID);
            String sitePlanId = bodyJsonObj.getString(LABEL_BODY_SITEPLANID);
            int cityId = bodyJsonObj.getInt(LABEL_BODY_CITYID);
            int siteCityId = bodyJsonObj.getInt(LABEL_BODY_SITECITYID);
            int siteId = bodyJsonObj.getInt(LABEL_BODY_SITEID);
            int cinemaId = bodyJsonObj.getInt(LABEL_BODY_CINEMAID);
            int siteCinemaId = bodyJsonObj.getInt(LABEL_BODY_SITECINEMAID);
            int promId = bodyJsonObj.getInt(LABEL_BODY_PROMID);
            int sitePromId = bodyJsonObj.getInt(LABEL_BODY_SITEPROMID);
            String planDate = bodyJsonObj.getString(LABEL_BODY_PLANDATE);
            String currentTime = bodyJsonObj.getString(LABEL_BODY_CURRENTTIME);
            String buyEndTime = bodyJsonObj.getString(LABEL_BODY_BUYENDTIME);
            String planStartTime = bodyJsonObj.getString(LABEL_BODY_PLANSTARTTIME);
            String planEndTime = bodyJsonObj.getString(LABEL_BODY_PLANENDTIME);
            String planLg = bodyJsonObj.getString(LABEL_BODY_PLANLG);
            String planVersion = bodyJsonObj.getString(LABEL_BODY_PLANVERSION);
            int standardPrice = bodyJsonObj.getInt(LABEL_BODY_STANDARDPRICE);
            int sokuPrice = bodyJsonObj.getInt(LABEL_BODY_SOKUPRICE);
            String hallName = bodyJsonObj.getString(LABEL_BODY_HALLNAME);
            int ticketId = bodyJsonObj.getInt(LABEL_BODY_TICKETID);
            int agentId = bodyJsonObj.getInt(LABEL_BODY_AGENTID);

            PlanInfo info = new PlanInfo();
            info.setPlanId(planId);
            info.setSitePlanId(sitePlanId);
            info.setCityId(cityId);
            info.setSiteCityId(siteCityId);
            info.setSiteId(siteId);
            info.setCinemaId(cinemaId);
            info.setSiteCinemaId(siteCinemaId);
            info.setPromId(promId);
            info.setSitePromId(sitePromId);
            info.setPlanDate(planDate);
            info.setCurrentTime(currentTime);
            info.setBuyEndTime(buyEndTime);
            info.setPlanStartTime(planStartTime);
            info.setPlanEndTime(planEndTime);
            info.setPlanLg(planLg);
            info.setPlanVersion(planVersion);
            info.setStandardPrice(standardPrice);
            info.setSokuPrice(sokuPrice);
            info.setHallName(hallName);
            info.setTicketId(ticketId);
            info.setAgentId(agentId);
            planList.add(info);
        }

        responseData.setPlanList(planList);
    }
}
