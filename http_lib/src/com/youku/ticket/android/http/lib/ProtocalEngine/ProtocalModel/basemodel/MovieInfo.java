/**
 * @title MovieInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午4:33:36
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className MovieInfo
 * @description 影片信息
 * @author LLC
 * @date 2014-12-25 下午4:33:36
 */
public class MovieInfo {

    private int promId;//影片Id

    private String promName;//影片名称

    private int cinemaCount;//当天上映影院数量

    private int planCount;//当天上映场次数量

    private int lowPrice;//int 当天上映影院最低票价

    private String vimg;//海报

    private String trailer;//预告片地址

    private String releasedateMainland;//大陆发行时间

    private String area;//地区

    private String grenre;//类型

    private String[] director;//导演名称

    private String[] performer;//主演名称

    private int showlength;//片长

    private double doubanScore;//豆瓣评分

    private int movieType;//影片类别，详细见影片类别编码描述

    private int trailerVideoid;//预告片视频ID

    private String showDesc;//剧情介绍

    /**
     * description: 影片Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:47:38
     * @editer
     */
    public int getPromId() {
        return promId;
    }

    public void setPromId(int promId) {
        this.promId = promId;
    }

    /**
     * description: 影片名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:47:54
     * @editer
     */
    public String getPromName() {
        return promName;
    }

    public void setPromName(String promName) {
        this.promName = promName;
    }

    /**
     * description: 当天上映影院数量
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:48:22
     * @editer
     */
    public int getCinemaCount() {
        return cinemaCount;
    }

    public void setCinemaCount(int cinemaCount) {
        this.cinemaCount = cinemaCount;
    }

    /**
     * description: 当天上映场次数量
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:48:44
     * @editer
     */
    public int getPlanCount() {
        return planCount;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    /**
     * description: 当天上映影院最低票价
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:48:54
     * @editer
     */
    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * description: 海报
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:49:08
     * @editer
     */
    public String getVimg() {
        return vimg;
    }

    public void setVimg(String vimg) {
        this.vimg = vimg;
    }

    /**
     * description: 预告片地址
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:49:24
     * @editer
     */
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    /**
     * description: 大陆发行时间
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:49:48
     * @editer
     */
    public String getReleasedateMainland() {
        return releasedateMainland;
    }

    public void setReleasedateMainland(String releasedateMainland) {
        this.releasedateMainland = releasedateMainland;
    }

    /**
     * description: 地区
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:50:16
     * @editer
     */
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    /**
     * description: 类型
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:50:25
     * @editer
     */
    public String getGrenre() {
        return grenre;
    }

    public void setGrenre(String grenre) {
        this.grenre = grenre;
    }

    /**
     * description: 导演名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:50:37
     * @editer
     */
    public String[] getDirector() {
        return director;
    }

    public void setDirector(String[] director) {
        this.director = director;
    }

    /**
     * description: 主演名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:50:54
     * @editer
     */
    public String[] getPerformer() {
        return performer;
    }

    public void setPerformer(String[] performer) {
        this.performer = performer;
    }

    /**
     * description: 片长
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:51:04
     * @editer
     */
    public int getShowlength() {
        return showlength;
    }

    public void setShowlength(int showlength) {
        this.showlength = showlength;
    }

    /**
     * description: 豆瓣评分
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:51:21
     * @editer
     */
    public double getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(double doubanScore) {
        this.doubanScore = doubanScore;
    }

    /**
     * description: 影片类别: 0,无 /1,3D/2,IMAX/3,3D.IMAX
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:51:34
     * @editer
     */
    public int getMovieType() {
        return movieType;
    }

    public void setMovieType(int movieType) {
        this.movieType = movieType;
    }

    /**
     * description: 预告片视频ID
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:52:59
     * @editer
     */
    public int getTrailerVideoid() {
        return trailerVideoid;
    }

    public void setTrailerVideoid(int trailerVideoid) {
        this.trailerVideoid = trailerVideoid;
    }

    /**
     * description: 剧情介绍
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:53:12
     * @editer
     */
    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

}
