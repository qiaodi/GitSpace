/**
 * @title PlanInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-26 下午2:53:55
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className PlanInfo
 * @description 影院排期信息
 * @author LLC
 * @date 2014-12-26 下午2:53:55
 */
public class PlanInfo {

    private int planId;//排期id

    private String sitePlanId;//站点排期id

    private int cityId;//城市id

    private int siteCityId;//站点城市id

    private int siteId;//站点id

    private int cinemaId;//影院id

    private int siteCinemaId;//站点影院id

    private int promId;//影片id

    private int sitePromId;//站点影片id

    private String planDate;//放映日期

    private String currentTime;//当前系统时间

    private String buyEndTime;//购票截止时间

    private String planStartTime;//放映开始时间

    private String planEndTime;//放映截止时间

    private String planLg;//语言

    private String planVersion;//版本

    private int standardPrice;//标准价格(单位:分)

    private int sokuPrice;//搜库价格(单位:分)

    private String hallName;//影厅名称

    private int ticketId;// 票id

    private int agentId;// 平台id

    /**
     * description: 排期id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午2:59:43
     * @editer
     */
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * description: 站点排期id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午2:59:57
     * @editer
     */
    public String getSitePlanId() {
        return sitePlanId;
    }

    public void setSitePlanId(String sitePlanId) {
        this.sitePlanId = sitePlanId;
    }

    /**
     * description: 城市id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:00:11
     * @editer
     */
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /**
     * description: 站点城市id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:00:20
     * @editer
     */
    public int getSiteCityId() {
        return siteCityId;
    }

    public void setSiteCityId(int siteCityId) {
        this.siteCityId = siteCityId;
    }

    /**
     * description: 站点id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:00:30
     * @editer
     */
    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    /**
     * description: 影院id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:00:46
     * @editer
     */
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * description: 站点影院id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:00:57
     * @editer
     */
    public int getSiteCinemaId() {
        return siteCinemaId;
    }

    public void setSiteCinemaId(int siteCinemaId) {
        this.siteCinemaId = siteCinemaId;
    }

    /**
     * description: 影片id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:01:09
     * @editer
     */
    public int getPromId() {
        return promId;
    }

    public void setPromId(int promId) {
        this.promId = promId;
    }

    /**
     * description: 站点影片id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:01:24
     * @editer
     */
    public int getSitePromId() {
        return sitePromId;
    }

    public void setSitePromId(int sitePromId) {
        this.sitePromId = sitePromId;
    }

    /**
     * description: 放映日期
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:01:52
     * @editer
     */
    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    /**
     * description: 当前系统时间
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:02:04
     * @editer
     */
    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * description: 购票截止时间
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:02:19
     * @editer
     */
    public String getBuyEndTime() {
        return buyEndTime;
    }

    public void setBuyEndTime(String buyEndTime) {
        this.buyEndTime = buyEndTime;
    }

    /**
     * description: 放映开始时间
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:02:31
     * @editer
     */
    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * description: 放映截止时间
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:02:40
     * @editer
     */
    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * description: 语言
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:02:56
     * @editer
     */
    public String getPlanLg() {
        return planLg;
    }

    public void setPlanLg(String planLg) {
        this.planLg = planLg;
    }

    /**
     * description: 版本
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:03:07
     * @editer
     */
    public String getPlanVersion() {
        return planVersion;
    }

    public void setPlanVersion(String planVersion) {
        this.planVersion = planVersion;
    }

    /**
     * description: 标准价格(单位:分)
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:03:19
     * @editer
     */
    public int getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(int standardPrice) {
        this.standardPrice = standardPrice;
    }

    /**
     * description: 搜库价格(单位:分)
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:03:34
     * @editer
     */
    public int getSokuPrice() {
        return sokuPrice;
    }

    public void setSokuPrice(int sokuPrice) {
        this.sokuPrice = sokuPrice;
    }

    /**
     * description: 影厅名称
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:03:47
     * @editer
     */
    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * description: 票id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:03:58
     * @editer
     */
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * description: 平台id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 下午3:04:10
     * @editer
     */
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

}
