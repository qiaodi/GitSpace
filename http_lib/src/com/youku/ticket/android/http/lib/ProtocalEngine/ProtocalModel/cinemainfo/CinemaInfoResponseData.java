/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className CinemaInfoResponseData
 * @description 影院信息响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class CinemaInfoResponseData extends ResponseDataBase {

    private CinemaInfo cinemaInfo;

    /**
     * description: 影院信息
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午12:16:12
     * @editer
     */
    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

}
