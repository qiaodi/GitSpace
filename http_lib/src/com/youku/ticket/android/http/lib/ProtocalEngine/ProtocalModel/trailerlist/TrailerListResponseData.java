/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.TrailerInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className TrailerListResponseData
 * @description 预告片列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class TrailerListResponseData extends ResponseDataBase {

    private ArrayList<TrailerInfo> trailerList = null;

    /**
     * description: 返回预告片区列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:08:36
     * @editer
     */
    public ArrayList<TrailerInfo> getTrailerList() {
        return trailerList;
    }

    /**
     * description: 设置预告片列表
     * 
     * @creater LLC
     * @param trailerList
     * @date 2014-12-22 下午6:08:49
     * @editer
     */
    public void setTrailerList(ArrayList<TrailerInfo> trailerList) {
        this.trailerList = trailerList;
    }

}
