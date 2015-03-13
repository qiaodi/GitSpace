/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className TrailerListRequestData
 * @description 预告片列表请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class TrailerListRequestData extends RequestDataBase {

    private int promId = 0;

    /**
     * description: 返回影片ID
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:51:46
     * @editer
     */
    public int getPromId() {
        return promId;
    }

    /**
     * description: 设置影片ID
     * 
     * @creater LLC
     * @param promId
     * @date 2014-12-25 下午5:51:38
     * @editer
     */
    public void setPromId(int promId) {
        this.promId = promId;
    }

}
