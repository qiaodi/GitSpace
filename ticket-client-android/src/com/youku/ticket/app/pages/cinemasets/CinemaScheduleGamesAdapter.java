package com.youku.ticket.app.pages.cinemasets;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CinemaScheduleItemModel;
import com.youku.ticket.app.views.CinemaScheduleItemView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;

public class CinemaScheduleGamesAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    
    private int mTargetDate ;
    
    public CinemaScheduleGamesAdapter(Context context) {
        // TODO Auto-generated constructor stub
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        CinemaScheduleItemView holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cinema_schedule_item, null);
            holder = new CinemaScheduleItemView(convertView);            
            convertView.setTag(holder);
        } else {
            holder = (CinemaScheduleItemView) convertView.getTag();
        }
        
        if(mTargetDate == 1){
           holder.setView(new CinemaScheduleItemModel("12:00","15:00","2D","Room 3","RMB:40", null));
        }
        return convertView;
    }

    public void updateTargetDate(Object tag) {
        // TODO Auto-generated method stub
        mTargetDate = (Integer) tag;
    }

}
