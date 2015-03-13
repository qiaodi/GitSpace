package com.youku.ticket.app.pages.commentsets;

import com.youku.ticket.R;
import com.youku.ticket.R.drawable;
import com.youku.ticket.R.id;
import com.youku.ticket.R.layout;
import com.youku.ticket.app.model.CommentSummaryStyleItemModel;
import com.youku.ticket.app.views.CommentSummaryStyleItemView;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @className CommentsListAdapter_New
 * @description TODO 新映影片的适配器
 * @author QIAODI
 * @date 2014年12月26日 下午4:53:49
 */
public class CommentsListAdapterNew extends BaseAdapter {

    private final String TAG = this.getClass().toString();

    private LayoutInflater mInflater = null;

    /**
     * @className ViewHolder
     * @description TODO 一个新映影片的布局
     * @author QIAODI
     * @date 2014年12月26日 下午4:54:06
     */
    private class ViewHolder {

        ImageView movie_poster;

        TextView movie_name;

        Button more_comments;

        CommentSummaryStyleItemView comment1;

        CommentSummaryStyleItemView comment2;

        CommentSummaryStyleItemView comment3;
    }

    public CommentsListAdapterNew(Context context) {
        super();
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub  
        return 3;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.comment_new_item, null);
            holder = new ViewHolder();
            holder.movie_poster = (ImageView) convertView.findViewById(R.id.comment_header_poster);
            holder.movie_name = (TextView) convertView.findViewById(R.id.comment_header_name);
            holder.more_comments = (Button) convertView.findViewById(R.id.comment_header_more);
            holder.more_comments.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "more comments button onClick position " + position);
                }
            });
            View vi_comment1 = convertView.findViewById(R.id.comment_1);
            holder.comment1 = new CommentSummaryStyleItemView(vi_comment1);
            vi_comment1.setTag(0);
            vi_comment1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "comment onClick position " + position + " commentID " + v.getTag());
                    if (mOnCommentClickedListener != null) {
                        mOnCommentClickedListener.onOneCommentClicked((Integer) v.getTag());
                    }
                }
            });

            View vi_comment2 = convertView.findViewById(R.id.comment_2);
            holder.comment2 = new CommentSummaryStyleItemView(vi_comment2);
            vi_comment2.setTag(1);
            vi_comment2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "comment onClick position " + position + " commentID " + v.getTag());
                    if (mOnCommentClickedListener != null) {
                        mOnCommentClickedListener.onOneCommentClicked((Integer) v.getTag());
                    }
                }
            });

            View vi_comment3 = convertView.findViewById(R.id.comment_3);
            holder.comment3 = new CommentSummaryStyleItemView(vi_comment3);
            vi_comment3.setTag(2);
            vi_comment3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Log.w(TAG, "comment onClick position " + position + " commentID " + v.getTag());
                    if (mOnCommentClickedListener != null) {
                        mOnCommentClickedListener.onOneCommentClicked((Integer) v.getTag());
                    }
                }
            });

            addTestData(holder);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private void addTestData(ViewHolder holder) {
        holder.movie_name.setText("xxxxx");

        holder.comment1.setView(new CommentSummaryStyleItemModel("xxxx", "ssssss", 4.5f));
        holder.comment2.setView(new CommentSummaryStyleItemModel("xxxx", "ssssss", 4.5f));
        holder.comment3.setView(new CommentSummaryStyleItemModel("xxxx", "ssssss", 4.5f));
    }

    private onOneCommentClickedListener mOnCommentClickedListener;

    public void setOnCommentClickedListener(onOneCommentClickedListener listener) {
        mOnCommentClickedListener = listener;
    }
}
