/**
 * @title TrailerInfo.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午5:44:58
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel;

/**
 * @className TrailerInfo
 * @description 预告片信息
 * @author LLC
 * @date 2014-12-25 下午5:44:58
 */
public class TrailerInfo {

    private int promId;//影片Id

    private int videoid;//预告片视频ID

    private String videourl;//预告片地址

    private String title;//标题

    private int showLength;//视频长度(单位是秒)

    private String thumburl;//预告片图片url

    /**
     * description: 影片Id
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:47:00
     * @editer
     */
    public int getPromId() {
        return promId;
    }

    public void setPromId(int promId) {
        this.promId = promId;
    }

    /**
     * description: 预告片视频ID
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:47:14
     * @editer
     */
    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    /**
     * description: 预告片地址
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:47:26
     * @editer
     */
    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    /**
     * description: 标题
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:48:01
     * @editer
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * description: 视频长度(单位是秒)
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:48:13
     * @editer
     */
    public int getShowLength() {
        return showLength;
    }

    public void setShowLength(int showLength) {
        this.showLength = showLength;
    }

    /**
     * description: 预告片图片url
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午5:48:27
     * @editer
     */
    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

}
