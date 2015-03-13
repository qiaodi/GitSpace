/**
 * @title DistrictInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午3:26:05
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className DistrictInfo
 * @description 城区信息
 * @author LLC
 * @date 2014-12-25 下午3:26:05
 */
public class DistrictInfo {

    private String districtId = "";

    private String districtName = "";

    /**
     * description: 返回城区Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午3:27:32
     * @editer
     */
    public String getDistrictId() {
        return districtId;
    }

    /**
     * description: 设置城区Id
     * 
     * @creater LLC
     * @param districtId
     * @date 2014-12-25 下午3:27:45
     * @editer
     */
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    /**
     * description: 返回城区名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午3:27:58
     * @editer
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * description: 设置城区名称
     * 
     * @creater LLC
     * @param districtName
     * @date 2014-12-25 下午3:28:16
     * @editer
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
