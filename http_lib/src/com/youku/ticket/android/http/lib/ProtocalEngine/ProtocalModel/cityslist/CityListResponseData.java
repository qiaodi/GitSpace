/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CityInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className CityListResponseData
 * @description 城市列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class CityListResponseData extends ResponseDataBase {

    private ArrayList<CityInfo> cityList = null;

    /**
     * description: 返回城市列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:08:36
     * @editer
     */
    public ArrayList<CityInfo> getCityList() {
        return cityList;
    }

    /**
     * description: 设置城市列表
     * 
     * @creater LLC
     * @param cityList
     * @date 2014-12-22 下午6:08:49
     * @editer
     */
    public void setCityList(ArrayList<CityInfo> cityList) {
        this.cityList = cityList;
    }

}
