package com.youku.ticket.app.model;

/**
 * @className CommentSummaryStyleItemModel
 * @description TODO 评论摘要页列表项
 * @author QIAODI
 * @date 2015年1月9日 下午4:05:08
 */
public class CommentSummaryStyleItemModel {

    private String mCommentTitle;

    private String mCommentSummary;

    private float mCommentScore;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param title 评论标题
     * @param summary 评论摘要
     * @param score 评分
     */
    public CommentSummaryStyleItemModel(String title,String summary,float score) {
        // TODO Auto-generated constructor stub
        mCommentTitle = title;
        mCommentSummary = summary;
        mCommentScore = score;
    }    
    
    public float getCommentScore() {
        return mCommentScore;
    }

    public String getCommentSummary() {
        return mCommentSummary;
    }

    public String getCommentTitle() {
        return mCommentTitle;
    }

    public void setCommentScore(float comment_score) {
        this.mCommentScore = comment_score;
    }

    public void setCommentSummary(String comment_summary) {
        this.mCommentSummary = comment_summary;
    }

    public void setCommentTitle(String comment_title) {
        this.mCommentTitle = comment_title;
    }
}
