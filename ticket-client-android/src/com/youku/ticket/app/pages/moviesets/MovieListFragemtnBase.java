package com.youku.ticket.app.pages.moviesets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.youku.ticket.R;
import com.youku.ticket.app.pages.cinemasets.CinemaListActivity;
import com.youku.ticket.app.pages.moviesets.MovieListAdapterBase.CallMovieItemOpertation;
import com.youku.ticket.app.templates.BaseListFragment;


public abstract class MovieListFragemtnBase extends BaseListFragment {

    public MovieListAdapterBase mAdapter;

    public View mLayoutView;

    public CallMovieItemOpertation mCallMovieItemOpertation;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mAdapter = new MovieListAdapterBase(getActivity());
        setListAdapter(mAdapter);
        mCallMovieItemOpertation = new CallMovieItemOpertation() {
            
            @Override
            public void callMovieItemOpertation(int movieID) {
                // TODO Auto-generated method stub
                movieItemOpertation(movieID);
            }
        };
        mAdapter.setCallMovieItemOpertation(mCallMovieItemOpertation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        mLayoutView = inflater.inflate(R.layout.common_list, container, false);        
        return mLayoutView;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        Log.w(TAG, "onListItemClick position" + position);
        super.onListItemClick(l, v, position, id);
        startMovieDetailActivity(position);
    }
    
    public void startMovieDetailActivity(int movieID){
        Intent intent = new Intent();
        intent.setClass(getActivity(), MovieDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("movieID", movieID);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    
    public void startCinemaListActivity(int movieID){
        Intent intent = new Intent();
        intent.setClass(getActivity(), CinemaListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("movieID", movieID);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); 
    }
    
    public abstract void requestCinemaList();
    
    public abstract void movieItemOpertation(int movieID);
}
