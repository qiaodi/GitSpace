/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className MovieListRequestData
 * @description 影片列表请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class MovieListRequestData extends RequestDataBase {

    private int cityId = 0;

    private int cinemaId = 0;

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

    /**
     * description: 返回影院Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:14:42
     * @editer
     */
    public int getCinemaId() {
        return cinemaId;
    }

    /**
     * description: 设置影院Id(非必须)
     * 
     * @creater LLC
     * @param cinemaId
     * @date 2014-12-25 下午5:14:56
     * @editer
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

}
