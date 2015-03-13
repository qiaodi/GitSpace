/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className DistrictListRequestData
 * @description 城区列表请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class DistrictListRequestData extends RequestDataBase {

    private int cityId = 0;

    /**
     * description: 返回城市Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午3:33:41
     * @editer
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * description: 设置城市Id
     * 
     * @creater LLC
     * @param cityId
     * @date 2014-12-25 下午3:33:56
     * @editer
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
