package com.youku.ticket.app.pages.moviesets;

import com.youku.ticket.R;
import com.youku.ticket.app.model.MoviesStyleItemModel;
import com.youku.ticket.app.views.MoviesStyleItemView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class MovieListAdapterBase extends BaseAdapter {

    private Context mContext;

    private CallMovieItemOpertation mCallMovieItemOpertation;

    public void setCallMovieItemOpertation(CallMovieItemOpertation mCallMovieItemOpertation) {
        this.mCallMovieItemOpertation = mCallMovieItemOpertation;
    }

    public interface CallMovieItemOpertation {

        void callMovieItemOpertation(int movieID);
    }

    public MovieListAdapterBase(Context context) {
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
        MoviesStyleItemView itemView = null;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.movielist_item, null);
            itemView = new MoviesStyleItemView(convertView);
            convertView.setTag(itemView);
        } else {
            itemView = (MoviesStyleItemView) convertView.getTag();
        }

        itemView.setView(new MoviesStyleItemModel(R.drawable.default_poster, "Name", "Info", "Rating", mOnClickListener));
        return convertView;
    }

    private OnClickListener mOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (mCallMovieItemOpertation != null) {
                mCallMovieItemOpertation.callMovieItemOpertation(0);
            }
        }
    };

}
