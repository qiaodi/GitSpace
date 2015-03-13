package com.youku.ticket.app.model;


/**
 * @className CinemaStyleItemModel
 * @description TODO 影院列表项
 * @author QIAODI
 * @date 2015年1月9日 下午4:03:17
 */
public class CinemaStyleItemModel {
    
    private String mCinemaName;
    
    private String mCinemaAddr;
    
    private String mCinemaPrice;
    
    private String mCinemaDistance;

    
    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param cinemaName 影院名称
     * @param cinemaAddr 影院地址
     * @param cinemaDistance 影院距离
     * @param cinemaPrice 影院最低票价
     */
    public CinemaStyleItemModel(String cinemaName,String cinemaAddr,String cinemaDistance,String cinemaPrice) {
        // TODO Auto-generated constructor stub
        mCinemaName = cinemaName;
        mCinemaAddr = cinemaAddr;
        mCinemaDistance = cinemaDistance;
        mCinemaPrice = cinemaPrice;
    }
    
    public String getCinemaName() {
        return mCinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.mCinemaName = cinemaName;
    }

    public String getCinemaAddr() {
        return mCinemaAddr;
    }

    public void setCinemaAddr(String cinemaAddr) {
        this.mCinemaAddr = cinemaAddr;
    }

    public String getCinemaPrice() {
        return mCinemaPrice;
    }

    public void setCinemaPrice(String cinemaPrice) {
        this.mCinemaPrice = cinemaPrice;
    }

    public String getCinemaDistance() {
        return mCinemaDistance;
    }

    public void setCinemaDistance(String cinemaDistance) {
        this.mCinemaDistance = cinemaDistance;
    }
}
