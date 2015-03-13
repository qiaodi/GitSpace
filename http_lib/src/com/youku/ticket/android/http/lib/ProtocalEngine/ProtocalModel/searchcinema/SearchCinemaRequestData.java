/**
 * @title CityListRequestData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.RequestDataBase;

/**
 * @className SearchCinemaRequestData
 * @description 搜索影院请求数据
 * @author LLC
 * @date 2014-12-22 下午6:13:35
 */
public class SearchCinemaRequestData extends RequestDataBase {

    private int cityId = -1;//城市ID

    private String queryword;//查询关键字

    private int pageSize = -1;//每页数量,和pageNo一起使用（非必须）

    private int pageNo = -1;//第几页,和pageSize一起使用（非必须）

    private double mapLat = -1;//纬度,和mapLon一起使用,用于根据坐标远近排序影院（非必须）

    private double mapLon = -1;// 经度,和mapLat一起使用,用于根据坐标远近排序影院（非必须）

    /**
     * description: 城市ID
     * 
     * @creater LLC
     * @param cityId
     * @date 2014-12-26 上午10:23:55
     * @editer
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    /**
     * description: 查询关键字
     * 
     * @creater LLC
     * @param queryword
     * @date 2014-12-26 下午1:22:15
     * @editer
     */
    public void setQueryword(String queryword) {
        this.queryword = queryword;
    }

    public String getQueryword() {
        return queryword;
    }

    /**
     * description: 每页数量,和pageNo一起使用（非必须）
     * 
     * @creater LLC
     * @param pageSize
     * @date 2014-12-26 上午10:26:08
     * @editer
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * description: 第几页,和pageSize一起使用（非必须）
     * 
     * @creater LLC
     * @param pageNo
     * @date 2014-12-26 上午10:26:31
     * @editer
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    /**
     * description: 纬度,和mapLon一起使用,用于根据坐标远近排序影院（非必须）
     * 
     * @creater LLC
     * @param mapLat
     * @date 2014-12-26 上午10:27:23
     * @editer
     */
    public void setMapLat(double mapLat) {
        this.mapLat = mapLat;
    }

    public double getMapLat() {
        return mapLat;
    }

    /**
     * description: 经度,和mapLat一起使用,用于根据坐标远近排序影院（非必须）
     * 
     * @creater LLC
     * @param mapLon
     * @date 2014-12-26 上午10:27:49
     * @editer
     */
    public void setMapLon(double mapLon) {
        this.mapLon = mapLon;
    }

    public double getMapLon() {
        return mapLon;
    }

}
