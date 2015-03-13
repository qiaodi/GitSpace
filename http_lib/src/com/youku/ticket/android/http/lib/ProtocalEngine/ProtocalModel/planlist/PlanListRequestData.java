/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className PlanListRequestData
 * @description 排期列表请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class PlanListRequestData extends RequestDataBase {

    private int cinemaId;//影院id

    private int promId;//影片id

    /**
     * description: 影院id
     * 
     * @creater LLC
     * @param cinemaId
     * @date 2014-12-26 下午2:51:30
     * @editer
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    /**
     * description: 影片id
     * 
     * @creater LLC
     * @param promId
     * @date 2014-12-26 下午2:51:38
     * @editer
     */
    public void setPromId(int promId) {
        this.promId = promId;
    }

    public int getPromId() {
        return promId;
    }

}
