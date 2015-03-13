/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className CinemaPlanTimeListResponseData
 * @description 影院上映时间列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class CinemaPlanTimeListResponseData extends ResponseDataBase {

    private ArrayList<String> planTimeList;//上映时间列表

    /**
     * description: 上映时间列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:59:47
     * @editer
     */
    public ArrayList<String> getPlanTimeList() {
        return planTimeList;
    }

    public void setPlanTimeList(ArrayList<String> planTimeList) {
        this.planTimeList = planTimeList;
    }

}
