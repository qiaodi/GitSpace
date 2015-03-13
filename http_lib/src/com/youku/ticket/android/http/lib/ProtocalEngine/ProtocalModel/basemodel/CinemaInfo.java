/**
 * @title CinemaInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-26 上午10:18:08
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className CinemaInfo
 * @description 影院信息
 * @author LLC
 * @date 2014-12-26 上午10:18:08
 */
public class CinemaInfo {

    private int cinemaId;//影院id

    private String cinemaName;//影院名称

    private int cityId;//城市Id

    private int districtId;//区域id

    private int planCount;//上映场次

    private int lowPrice;//影院最低票价

    private String address;//影院地址

    private String telphone;//电话

    private double mapLon;//经度

    private double mapLat;//纬度

    private int distance;//距离(单位米)

    /** 2014-12-26 上午12:17:45添加 */
    private String route;//乘车路线

    private String intro;//影院简介

    /**
     * description: 影院id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:06:23
     * @editer
     */
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * description: 影院名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:06:40
     * @editer
     */
    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    /**
     * description: 城市Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:06:52
     * @editer
     */
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /**
     * description: 区域id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:07:04
     * @editer
     */
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    /**
     * description: 上映场次
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:07:13
     * @editer
     */
    public int getPlanCount() {
        return planCount;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    /**
     * description: 影院最低票价
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:07:29
     * @editer
     */
    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * description: 影院地址
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:07:46
     * @editer
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * description: 电话
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:07:58
     * @editer
     */
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * description: 经度
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:08:13
     * @editer
     */
    public double getMapLon() {
        return mapLon;
    }

    public void setMapLon(double mapLon) {
        this.mapLon = mapLon;
    }

    /**
     * description: 纬度
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:08:27
     * @editer
     */
    public double getMapLat() {
        return mapLat;
    }

    public void setMapLat(double mapLat) {
        this.mapLat = mapLat;
    }

    /**
     * description: 距离(单位米)
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:08:39
     * @editer
     */
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * description: 乘车路线
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午12:18:47
     * @editer
     */
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * description: 影院简介
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午12:19:00
     * @editer
     */
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

}
