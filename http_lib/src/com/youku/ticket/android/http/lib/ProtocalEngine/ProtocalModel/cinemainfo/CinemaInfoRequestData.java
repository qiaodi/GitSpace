/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className CinemaInfoRequestData
 * @description 影院信息请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class CinemaInfoRequestData extends RequestDataBase {

    private int cinemaId;//影院ID

    public int getCinemaId() {
        return cinemaId;
    }

    /**
     * description: 影院ID
     * 
     * @creater LLC
     * @param cinemaId
     * @date 2014-12-26 下午12:14:22
     * @editer
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

}
