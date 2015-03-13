/**
 * @title ResponseMap.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午10:23:38
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil;

import java.util.HashMap;

import android.annotation.SuppressLint;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist.CinemaPlanTimeListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo.CinemaInfoResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist.CityListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist.MovieListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist.PlanListResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema.SearchCinemaResponseParser;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist.TrailerListResponseParser;
import com.youku.ticket.android.http.lib.common.CommandDef;

/**
 * @className ResponseMap
 * @description 响应图表
 * @author LLC
 * @date 2014-12-25 上午10:23:38
 */
public class ResponseMap implements CommandDef {

    /**
     * @fields mResponseMap : 响应cls图表
     */
    @SuppressLint("UseSparseArrays")
    public static HashMap<Integer, Class<?>> sResponseMap = new HashMap<Integer, Class<?>>();

    static {
        sResponseMap.put(CITYS_LIST, CityListResponseParser.class);
        sResponseMap.put(DISTRICT_LIST, DistrictListResponseParser.class);
        sResponseMap.put(MOVIE_LIST, MovieListResponseParser.class);
        sResponseMap.put(TRAILER_LIST, TrailerListResponseParser.class);
        sResponseMap.put(CINEMA_LIST, CinemaListResponseParser.class);
        sResponseMap.put(CINEMAPLANTIME_LIST, CinemaPlanTimeListResponseParser.class);
        sResponseMap.put(CINEMA_INFO, CinemaInfoResponseParser.class);
        sResponseMap.put(SEARCH_CINEMA, SearchCinemaResponseParser.class);
        sResponseMap.put(PLAN_LIST, PlanListResponseParser.class);
    }
}
