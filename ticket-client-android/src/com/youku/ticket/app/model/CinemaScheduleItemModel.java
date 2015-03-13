package com.youku.ticket.app.model;

import android.view.View.OnClickListener;

/**
 * @className CinemaScheduleItemModel
 * @description TODO 影院排片表列表项
 * @author QIAODI
 * @date 2015年1月9日 下午4:00:53
 */
public class CinemaScheduleItemModel {

    private String mStartTime;

    private String mEndTime;

    private String mStyle;

    private String mRoom;

    private String mPrice;

    private OnClickListener mBuyTicketHandler;

    /** 
     * @param startTime 影片开始时间
     * @param endTime 影片结束时间
     * @param style 影片格式
     * @param room 放映房间
     * @param price 影片价格
     * @param listener 买票按钮响应
     */
    public CinemaScheduleItemModel(String startTime, String endTime, String style, String room, String price, OnClickListener listener) {
        // TODO Auto-generated constructor stub
        mStartTime = startTime;
        mEndTime = endTime;
        mStyle = style;
        mRoom = room;
        mPrice = price;
        mBuyTicketHandler = listener;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String mStartTime) {
        this.mStartTime = mStartTime;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String mEndTime) {
        this.mEndTime = mEndTime;
    }

    public String getStyle() {
        return mStyle;
    }

    public void setStyle(String mStyle) {
        this.mStyle = mStyle;
    }

    public String getRoom() {
        return mRoom;
    }

    public void setRoom(String mRoom) {
        this.mRoom = mRoom;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public OnClickListener getListener() {
        return mBuyTicketHandler;
    }

    public void setListener(OnClickListener mListener) {
        this.mBuyTicketHandler = mListener;
    }
}
