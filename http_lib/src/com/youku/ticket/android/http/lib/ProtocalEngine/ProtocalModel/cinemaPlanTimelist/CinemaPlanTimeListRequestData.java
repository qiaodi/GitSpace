/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className CinemaPlanTimeListRequestData
 * @description 影院上映时间列表请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class CinemaPlanTimeListRequestData extends RequestDataBase {

    private int cinemaId;//影院ID

    private int promId;//影片ID(非必须)

    /**
     * description: 影院ID
     * 
     * @creater LLC
     * @param cinemaId
     * @date 2014-12-26 上午11:53:23
     * @editer
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    /**
     * description: 影片ID(非必须)
     * 
     * @creater LLC
     * @param promId
     * @date 2014-12-26 上午11:53:43
     * @editer
     */
    public void setPromId(int promId) {
        this.promId = promId;
    }

    public int getPromId() {
        return promId;
    }

}
