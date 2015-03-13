package com.youku.ticket.app.pages.cinemasets;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseActivity;
import com.youku.ticket.app.templates.BaseDataProvider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import us.feras.ecogallery.EcoGallery;
import us.feras.ecogallery.EcoGalleryAdapterView;
import us.feras.ecogallery.EcoGalleryAdapterView.OnItemSelectedListener;

/**
 * @className CinemaScheduleActivity
 * @description TODO 影院排片表
 * @author QIAODI
 * @date 2014年12月26日 下午4:43:35
 */
public class CinemaScheduleActivity extends BaseActivity {

    private TextView mTxt_CinemaName;

    private RatingBar mRat_CinemaScore;

    private TextView mTxt_CinemaAddr;

    private Button mBtn_CinemaDetails;

    private TextView mTxt_CinemaSaleInformation;

    private Button mBtn_CinemaSale;

    private EcoGallery mSco_Poster;

    private TextView mTxt_TagretMovieName;

    private ListView mList_Cinema_schedule_games;

    private LinearLayout mScr_ScheduleDate;

    private CinemaScheduleGamesAdapter mScheduleGamesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinema_schedule);
        addAppBar(false);
        Bundle bundle = this.getIntent().getExtras();
        bundle.getInt("CinemaID");
        mTxt_CinemaName = (TextView) findViewById(R.id.cinema_name);
        mRat_CinemaScore = (RatingBar) findViewById(R.id.cinema_rating);
        mTxt_CinemaAddr = (TextView) findViewById(R.id.cinema_addr);
        mBtn_CinemaDetails = (Button) findViewById(R.id.cinema_details);
        mTxt_CinemaSaleInformation = (TextView) findViewById(R.id.cinema_sale_information);
        mSco_Poster = (EcoGallery) findViewById(R.id.cinema_posters);
        mSco_Poster.setAdapter(new ImageAdapter(this));
        mSco_Poster.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(EcoGalleryAdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Log.w(TAG, "onItemSelected position " + position);
                switch (position) {
                    case 1:
                        mTxt_TagretMovieName.setText("星际迷航");
                        break;
                    case 2:
                        mTxt_TagretMovieName.setText("猩球崛起");
                        break;
                    default:
                        mTxt_TagretMovieName.setText("威虎山");
                        break;
                }
            }

            @Override
            public void onNothingSelected(EcoGalleryAdapterView<?> parent) {
                // TODO Auto-generated method stub

            }

        });
        mTxt_TagretMovieName = (TextView) findViewById(R.id.cinema_target_movie);
        mScr_ScheduleDate = (LinearLayout) findViewById(R.id.cinema_schedule_date);
        mList_Cinema_schedule_games = (ListView)findViewById(R.id.cinema_schedule_games);
        mScheduleGamesAdapter = new CinemaScheduleGamesAdapter(this);
        mList_Cinema_schedule_games.setAdapter(mScheduleGamesAdapter);
        addTestData();
        setListViewHeightBasedOnChildren(mList_Cinema_schedule_games);
    }

    private void addTestData() {
        // TODO Auto-generated method stub
        mTxt_CinemaName.setText("美嘉欢乐影城");
        mRat_CinemaScore.setRating(4.5f);
        mTxt_CinemaAddr.setText("朝阳区三里屯太古里广场地下一层(三里屯酒吧街南口西侧)");
        mTxt_CinemaSaleInformation.setText("票价:80元起");
        TextView tv = new TextView(this);
        tv.setText("12月24日");
        tv.setPadding(100, 0, 100, 0);
        tv.setTag(0);
        tv.setOnClickListener(mListener);
        mScr_ScheduleDate.addView(tv);
        TextView tv1 = new TextView(this);
        tv1.setText("12月25日");
        tv1.setPadding(100, 0, 100, 0);
        tv1.setTag(1);
        tv1.setOnClickListener(mListener);
        mScr_ScheduleDate.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("12月26日");
        tv2.setPadding(100, 0, 100, 0);
        tv2.setTag(2);
        tv2.setOnClickListener(mListener);
        mScr_ScheduleDate.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("12月27日");
        tv3.setPadding(100, 0, 100, 0);
        tv3.setTag(3);
        tv3.setOnClickListener(mListener);
        mScr_ScheduleDate.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText("12月28日");
        tv4.setPadding(100, 0, 100, 0);
        tv4.setTag(4);
        tv4.setOnClickListener(mListener);
        mScr_ScheduleDate.addView(tv4);
    }

    private OnClickListener mListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Log.w(TAG, "Date " + ((TextView) v).getText() + " tag " + v.getTag());
            updateScheduleList(v.getTag());
        }
    };

    /**
     * @className ImageAdapter
     * @description TODO 用户在滑动到某个影片时，更新相应的数据
     * @author QIAODI
     * @date 2014年12月26日 下午4:43:52
     */
    private class ImageAdapter extends BaseAdapter {

        private Context context;

        ImageAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return 3;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // Not using convertView for sample app simplicity. You should probably use it in real application to get better performance.
            ImageView imageView = new ImageView(context);
            int resId;
            switch (position) {
                case 0:
                    resId = R.drawable.post1;
                    break;
                case 1:
                    resId = R.drawable.hot_movie2;
                    break;
                case 2:
                    resId = R.drawable.post3;
                    break;
                default:
                    resId = R.drawable.post1;
            }
            imageView.setImageResource(resId);
            return imageView;
        }
    }

    protected void updateScheduleList(Object tag) {
        // TODO Auto-generated method stub
        mScheduleGamesAdapter.updateTargetDate(tag);
        mScheduleGamesAdapter.notifyDataSetChanged();
    }
    
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

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return new CinemaScheduleGamesDataProvider(this);
    }
    
}
