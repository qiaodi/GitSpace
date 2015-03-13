package com.youku.ticket.app.model;

import android.view.View.OnClickListener;

/**
 * @className MoviesStyleItemModel
 * @description TODO 电影列表项
 * @author QIAODI
 * @date 2015年1月9日 下午4:05:55
 */
public class MoviesStyleItemModel {

    private int mMovieRosterResource;

    private String mMovieName;

    private String mMovieInfo;

    private String mMovieScore;

    private OnClickListener mMovieOperationHandle;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param resource 海报资源
     * @param name 影片名称
     * @param info 影片简介
     * @param score 影片评分
     * @param listener 用户操作响应接口
     */
    public MoviesStyleItemModel(int resource, String name, String info, String score, OnClickListener listener) {
        // TODO Auto-generated constructor stub
        mMovieRosterResource = resource;
        mMovieName = name;
        mMovieInfo = info;
        mMovieScore = score;
        mMovieOperationHandle = listener;
    }

    public int getMovieRosterResource() {
        return mMovieRosterResource;
    }

    public void setMovieRosterResource(int mMovieRosterResource) {
        this.mMovieRosterResource = mMovieRosterResource;
    }

    public String getMovieName() {
        return mMovieName;
    }

    public void setMovieName(String mMovieName) {
        this.mMovieName = mMovieName;
    }

    public String getMovieInfo() {
        return mMovieInfo;
    }

    public void setMovieInfo(String mMovieInfo) {
        this.mMovieInfo = mMovieInfo;
    }

    public String getMovieScore() {
        return mMovieScore;
    }

    public void setMovieScore(String mMovieScore) {
        this.mMovieScore = mMovieScore;
    }

    public OnClickListener getMovieOperationHandle() {
        return mMovieOperationHandle;
    }

    public void setMovieOperationHandle(OnClickListener mMovieOperationHandle) {
        this.mMovieOperationHandle = mMovieOperationHandle;
    }
}
