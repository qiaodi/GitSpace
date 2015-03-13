package com.youku.ticket.app.pages.moviesets;

import android.os.Bundle;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseActivity;
import com.youku.ticket.app.templates.BaseDataProvider;

public class MovieDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        addAppBar(false);
        Bundle bundle = this.getIntent().getExtras();
        bundle.getInt("movieID");
    }

    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return new MovieDetailsDataProvider(this);
    }

}
