/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.PlanInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className PlanListResponseData
 * @description 排期列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class PlanListResponseData extends ResponseDataBase {

    private ArrayList<PlanInfo> planList = null;

    /**
     * description: 影院排期列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:04:47
     * @editer
     */
    public ArrayList<PlanInfo> getPlanList() {
        return planList;
    }

    public void setPlanList(ArrayList<PlanInfo> planList) {
        this.planList = planList;
    }

}
