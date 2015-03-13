package com.youku.ticket.app.pages.commentsets;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CommentDetailBodyModel;
import com.youku.ticket.app.views.CommentDetailTextBodyView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CommentDetailsAdapter extends BaseAdapter{

    private Context mContext;
    
    public CommentDetailsAdapter(Context context) {
        // TODO Auto-generated constructor stub
        mContext = context;
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CommentDetailTextBodyView holder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.comment_detail_body, null);
            holder = new CommentDetailTextBodyView(convertView);
            convertView.setTag(holder);
        }else{
            holder = (CommentDetailTextBodyView) convertView.getTag();
        }
        
        holder.setView(new CommentDetailBodyModel("body text"));
        return convertView;
    }

}
