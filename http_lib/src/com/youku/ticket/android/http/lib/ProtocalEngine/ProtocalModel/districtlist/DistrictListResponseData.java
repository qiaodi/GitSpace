/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.DistrictInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className DistrictListResponseData
 * @description 城区列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class DistrictListResponseData extends ResponseDataBase {

    private ArrayList<DistrictInfo> districtList = null;

    /**
     * description: 返回城区列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:08:36
     * @editer
     */
    public ArrayList<DistrictInfo> getDistrictList() {
        return districtList;
    }

    /**
     * description: 设置城区列表
     * 
     * @creater LLC
     * @param districtList
     * @date 2014-12-22 下午6:08:49
     * @editer
     */
    public void setDistrictList(ArrayList<DistrictInfo> districtList) {
        this.districtList = districtList;
    }

}
