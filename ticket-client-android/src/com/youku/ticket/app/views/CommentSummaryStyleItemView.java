package com.youku.ticket.app.views;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CommentSummaryStyleItemModel;
import com.youku.ticket.app.templates.BaseView;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @className CommentItemView
 * @description TODO 简略状态下。评论item包含片面片名，影片评分，概要
 * @author QIAODI
 * @date 2014年12月26日 下午4:44:44
 */
public class CommentSummaryStyleItemView extends BaseView{

    private RatingBar comment_score;

    private TextView comment_title;

    private TextView comment_summary;

    public CommentSummaryStyleItemView(View node) {
        // TODO Auto-generated constructor stub
        super(node);
        comment_score = (RatingBar) node.findViewById(R.id.comment_score);
        comment_title = (TextView) node.findViewById(R.id.comment_title);
        comment_summary = (TextView) node.findViewById(R.id.comment_summary);
    }

    @Override
    public void setView(Object data) {
        // TODO Auto-generated method stub
        comment_score.setRating(((CommentSummaryStyleItemModel) data).getCommentScore());
        comment_title.setText(((CommentSummaryStyleItemModel) data).getCommentTitle());
        comment_summary.setText(((CommentSummaryStyleItemModel) data).getCommentSummary());
    }
}
