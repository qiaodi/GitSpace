package com.youku.ticket.app.pages.homepage;

import com.youku.ticket.R;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * @className HotMovieAdapter
 * @description TODO 热门影片子控件的适配器
 * @author QIAODI
 * @date 2014年12月26日 下午5:00:47
 */
public class HotMovieAdapter extends BaseAdapter {

    private Context mContext;

    private Integer[] mImageIds = { R.drawable.hot_movie1, R.drawable.hot_movie2, R.drawable.hot_movie3, R.drawable.hot_movie4, R.drawable.hot_movie5,
            R.drawable.hot_movie6, };

    private int mItemWidth;

    private int mItemHeight;

    public HotMovieAdapter(Context c) {
        // TODO Auto-generated constructor stub
        mContext = c;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mImageIds.length;
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
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mItemWidth, mItemHeight));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mImageIds[position]);
        return imageView;
    }

    public void setItemViewSize(int width, int height) {
        mItemWidth = width;
        mItemHeight = height;
    }
}
