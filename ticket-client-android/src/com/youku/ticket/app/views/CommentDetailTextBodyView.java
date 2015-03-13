package com.youku.ticket.app.views;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CommentDetailBodyModel;
import com.youku.ticket.app.templates.BaseView;

import android.view.View;
import android.widget.TextView;

/**
 * @className CommentDetailTextBodyView
 * @description TODO 评论正文视图
 * @author QIAODI
 * @date 2015年1月9日 下午4:33:04
 */
public class CommentDetailTextBodyView extends BaseView{
  
    private TextView mCommentText;
    
    public CommentDetailTextBodyView(View node) {
        super(node);
        // TODO Auto-generated constructor stub
        mCommentText = (TextView) node.findViewById(R.id.comment_detail_body);
    }

    @Override
    public void setView(Object data) {
        // TODO Auto-generated method stub
        mCommentText.setText(((CommentDetailBodyModel) data).getBodyText());
    }
    
}
