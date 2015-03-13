package com.youku.ticket.app.pages.commentsets;

import com.youku.ticket.R;
import com.youku.ticket.R.drawable;
import com.youku.ticket.R.id;
import com.youku.ticket.R.layout;
import com.youku.ticket.app.model.CommentSummaryStyleItemModel;
import com.youku.ticket.app.views.CommentSummaryStyleItemView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @className CommentsListAdapter_Hot
 * @description TODO 热门评论的适配器
 * @author QIAODI
 * @date 2014年12月26日 下午4:53:27
 */
public class CommentsListAdapterHot extends BaseAdapter {

    private LayoutInflater mInflater = null;

    public CommentsListAdapterHot(Context context) {
        super();
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub  
        return 20;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub  
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub  
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommentSummaryStyleItemView holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.comment_item, null);
            holder = new CommentSummaryStyleItemView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CommentSummaryStyleItemView) convertView.getTag();
        }

        holder.setView(new CommentSummaryStyleItemModel("xxxx", "ssssss", 4.5f));

        return convertView;
    }

}
