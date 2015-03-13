/**
 * @title CityInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:04:23
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className CityInfo
 * @description 城市信息
 * @author LLC
 * @date 2014-12-22 下午6:04:23
 */
public class CityInfo {

    //城市名称
    private String cityName = "";

    //城市ID
    private int cityId = 0;

    /**
     * description: 返回城市名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:05:32
     * @editer
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * description: 设置城市名称
     * 
     * @creater LLC
     * @param cityName
     * @date 2014-12-22 下午6:05:53
     * @editer
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * description: 返回城市ID
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:06:04
     * @editer
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * description: 设置城市ID
     * 
     * @creater LLC
     * @param cityId
     * @date 2014-12-22 下午6:06:34
     * @editer
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
