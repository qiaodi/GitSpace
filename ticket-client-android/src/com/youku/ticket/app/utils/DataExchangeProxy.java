package com.youku.ticket.app.utils;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalEngine;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist.CinemaPlanTimeListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo.CinemaInfoRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist.CityListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist.MovieListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist.PlanListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema.SearchCinemaRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist.TrailerListRequestData;
import com.youku.ticket.android.http.lib.common.CommandDef;
import com.youku.ticket.android.http.lib.common.ProtocalObserver;

/**
 * @className DataExchangeProxy
 * @description TODO 向接入层请求数据的封装类
 * @author QIAODI
 * @date 2015年1月9日 下午4:21:13
 */
public final class DataExchangeProxy {

    private static DataExchangeProxy mDataExchangeProxy;
    
    public static DataExchangeProxy getInstance(){
        if(mDataExchangeProxy == null){
            synchronized (DataExchangeProxy.class) {
                mDataExchangeProxy = new DataExchangeProxy();
            }
        }
        return mDataExchangeProxy;
    }
    
    protected DataExchangeProxy() {
        // TODO Auto-generated constructor stub
    }
    
    public void requestCityList(ProtocalEngine engine, ProtocalObserver aObserver, CityListRequestData obj) {
        engine.request(aObserver, CommandDef.CITYS_LIST, obj);
    }

    public void requestDistrictList(ProtocalEngine engine, ProtocalObserver aObserver, DistrictListRequestData obj) {
        engine.request(aObserver, CommandDef.DISTRICT_LIST, obj);
    }
    
    public void requestMovieList(ProtocalEngine engine, ProtocalObserver aObserver, MovieListRequestData obj) {
        engine.request(aObserver, CommandDef.MOVIE_LIST, obj);
    }
    
    public void requestTrailertList(ProtocalEngine engine, ProtocalObserver aObserver, TrailerListRequestData obj) {
        engine.request(aObserver, CommandDef.TRAILER_LIST, obj);
    }
    
    public void requestCinemaList(ProtocalEngine engine, ProtocalObserver aObserver, CinemaListRequestData obj) {
        engine.request(aObserver, CommandDef.CINEMA_LIST, obj);
    }
    
    public void requestCinemaPlanTimeList(ProtocalEngine engine, ProtocalObserver aObserver, CinemaPlanTimeListRequestData obj) {
        engine.request(aObserver, CommandDef.CINEMAPLANTIME_LIST, obj);
    }
    
    public void requestMovieScheduleList(ProtocalEngine engine, ProtocalObserver aObserver, PlanListRequestData obj) {
        engine.request(aObserver, CommandDef.PLAN_LIST, obj);
    }    
    
    public void requestCinemaInfo(ProtocalEngine engine, ProtocalObserver aObserver, CinemaInfoRequestData obj) {
        engine.request(aObserver, CommandDef.CINEMA_INFO, obj);
    }    
    
    public void requestSearchCinema(ProtocalEngine engine, ProtocalObserver aObserver, SearchCinemaRequestData obj) {
        engine.request(aObserver, CommandDef.SEARCH_CINEMA, obj);
    }  
}
