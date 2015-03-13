package com.youku.ticket.app.pages.homepage;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseTabFragment;
import com.youku.ticket.app.utils.ActiivtyStack;
import com.youku.ticket.app.views.MenuItemSearch;

/**
 * @className Mainpage
 * @description TODO 主界面的默认页（首页）
 * @author QIAODI
 * @date 2014年12月26日 下午4:56:11
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomePage extends BaseTabFragment implements OnGestureListener, OnTouchListener {

    private final String TAB_TAG = "mainpage";

    private ViewFlipper mVi_poster_flipper;

    private GridView mGri_hot_movie;

    private ListView mLi_hot_cinema;

    private Button mBtn_moreCinema;

    private Button mBtn_moreMovie;

    private GestureDetector mDetector;

    private FragmentManager mFragmentManager;

    private Adapter mHotMovieAdapter;

    private Adapter mHotCinemaAdapter;

    private OnItemClickListener mHotMovieOnClick;

    private OnItemClickListener mHotCinemaOnClick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getChildFragmentManager();
        YoukuTicketMainActivity.sFragmentStack.put(TAB_TAG, new ActiivtyStack(mFragmentManager));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(R.layout.mainpage, null);
        mDetector = new GestureDetector(getActivity(), this);

        mVi_poster_flipper = (ViewFlipper) mLayoutView.findViewById(R.id.poster_flipper);
        mVi_poster_flipper.setOnTouchListener(this);
        addTestData();
        initHotMovieView();
        mBtn_moreMovie = (Button) mLayoutView.findViewById(R.id.hot_movie_header_button);
        mBtn_moreMovie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ((YoukuTicketMainActivity) getActivity()).getActivityTabHost().setCurrentTab(1);
            }
        });
        initHotCinemaView();
        mBtn_moreCinema = (Button) mLayoutView.findViewById(R.id.hot_cinema_header_button);
        mBtn_moreCinema.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ((YoukuTicketMainActivity) getActivity()).getActivityTabHost().setCurrentTab(2);
            }
        });
        return mLayoutView;
    }

    /**
     * description: TODO 初始化热门影片子控件
     * @creater QIAODI
     * @date 2014年12月26日 下午4:59:09
     * @editer 	
     */
    private void initHotMovieView() {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        mHotMovieAdapter = new HotMovieAdapter(getActivity());
        ((HotMovieAdapter) mHotMovieAdapter).setItemViewSize(dm.widthPixels / 3, dm.heightPixels / 4);
        mHotMovieOnClick = new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int postion, long id) {
                // TODO Auto-generated method stub
                Log.w(TAG, "onItemClick postion " + postion);
            }
        };
        mGri_hot_movie = (GridView) mLayoutView.findViewById(R.id.hot_movie_gridview);
        mGri_hot_movie.setAdapter((ListAdapter) mHotMovieAdapter);
        mGri_hot_movie.setOnItemClickListener(mHotMovieOnClick);
        ViewGroup.LayoutParams params = mGri_hot_movie.getLayoutParams();
        params.height = dm.heightPixels / 4 * 2;
        mGri_hot_movie.setLayoutParams(params);
    }

    /**
     * description: TODO 初始化热门影院子控件
     * @creater QIAODI
     * @date 2014年12月26日 下午4:59:39
     * @editer 	
     */
    private void initHotCinemaView() {
        mHotCinemaAdapter = new HotCinemaAdapter(getActivity());
        mHotCinemaOnClick = new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int postion, long id) {
                // TODO Auto-generated method stub
                Log.w(TAG, "onItemClick postion " + postion);
            }
        };
        mLi_hot_cinema = (ListView) mLayoutView.findViewById(R.id.hot_cinema_list);
        mLi_hot_cinema.setAdapter((ListAdapter) mHotCinemaAdapter);
        mLi_hot_cinema.setOnItemClickListener(mHotCinemaOnClick);
        setListViewHeightBasedOnChildren(mLi_hot_cinema);
    }

    private void addTestData() {
        // TODO Auto-generated method stub
        mVi_poster_flipper.addView(getImageView(R.drawable.post1));
        mVi_poster_flipper.addView(getImageView(R.drawable.post2));
        mVi_poster_flipper.addView(getImageView(R.drawable.post3));
        mVi_poster_flipper.addView(getImageView(R.drawable.post4));
        mVi_poster_flipper.addView(getImageView(R.drawable.post5));
    }

    private View getImageView(int resID) {
        // TODO Auto-generated method stub
        ImageView imgView = new ImageView(getActivity());
        imgView.setImageResource(resID);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imgView;
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onFling");
        if (e1.getX() - e2.getX() > 120) {
            mVi_poster_flipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.poster_push_left_in));
            mVi_poster_flipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.poster_push_left_out));
            mVi_poster_flipper.showNext();
        } else if (e2.getX() - e1.getX() > 120) {
            mVi_poster_flipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.poster_push_right_in));
            mVi_poster_flipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.poster_push_right_out));
            mVi_poster_flipper.showPrevious();
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onScroll");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onSingleTapUp");
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onTouch View " + v);
        ((ViewGroup) mLayoutView).requestDisallowInterceptTouchEvent(true);
        return mDetector.onTouchEvent(event);
    }

    /**
     * description: TODO 手动设置listview的高度，防止在scollview下只显示有限项的问题
     * @creater QIAODI
     * @param listView
     * @date 2014年12月26日 下午4:57:15
     * @editer 	
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ((MarginLayoutParams) params).setMargins(0, 0, 0, 0);
        listView.setLayoutParams(params);
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }
    
    public void CreateActionBarItem(Menu menu) {
        MenuItemSearch item = new MenuItemSearch();
        item.ShowItem(getActivity(), menu);
    }
}
