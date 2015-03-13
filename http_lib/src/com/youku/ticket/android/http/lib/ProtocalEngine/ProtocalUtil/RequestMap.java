/**
 * @title RequestMap.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午5:37:50
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil;

import java.util.HashMap;

import android.annotation.SuppressLint;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist.CinemaPlanTimeListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo.CinemaInfoRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist.CityListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist.MovieListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist.PlanListRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema.SearchCinemaRequestProtocol;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist.TrailerListRequestProtocol;
import com.youku.ticket.android.http.lib.common.CommandDef;

/**
 * @className RequestMap
 * @description 请求图表
 * @author LLC
 * @date 2014-12-22 下午5:37:50
 */
public class RequestMap implements CommandDef {

    /**
     * @fields sRequestMap : 请求cls图表
     */
    @SuppressLint("UseSparseArrays")
    public static HashMap<Integer, Class<?>> sRequestMap = new HashMap<Integer, Class<?>>();

    static {
        sRequestMap.put(CITYS_LIST, CityListRequestProtocol.class);
        sRequestMap.put(DISTRICT_LIST, DistrictListRequestProtocol.class);
        sRequestMap.put(MOVIE_LIST, MovieListRequestProtocol.class);
        sRequestMap.put(TRAILER_LIST, TrailerListRequestProtocol.class);
        sRequestMap.put(CINEMA_LIST, CinemaListRequestProtocol.class);
        sRequestMap.put(CINEMAPLANTIME_LIST, CinemaPlanTimeListRequestProtocol.class);
        sRequestMap.put(CINEMA_INFO, CinemaInfoRequestProtocol.class);
        sRequestMap.put(SEARCH_CINEMA, SearchCinemaRequestProtocol.class);
        sRequestMap.put(PLAN_LIST, PlanListRequestProtocol.class);
    }
}
