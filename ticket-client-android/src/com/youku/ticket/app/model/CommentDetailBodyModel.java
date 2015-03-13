package com.youku.ticket.app.model;

/**
 * @className CommentDetailBodyModel
 * @description TODO 评论正文·
 * @author QIAODI
 * @date 2015年1月9日 下午4:04:22
 */
public class CommentDetailBodyModel {

    private String mBodyText;

    public String getBodyText() {
        return mBodyText;
    }

    public void setBodyText(String bodyText) {
        this.mBodyText = bodyText;
    }
    
    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param bodyText 评论正文
     */
    public CommentDetailBodyModel(String bodyText) {
        // TODO Auto-generated constructor stub
        this.mBodyText = bodyText;
    }
}
