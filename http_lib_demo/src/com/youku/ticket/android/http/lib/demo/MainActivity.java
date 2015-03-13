/**
 * @title MainActivity.java
 * @package com.example.youkudemo
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午1:42:48
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.demo;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CityInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.DistrictInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.MovieInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.PlanInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.TrailerInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist.CinemaPlanTimeListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemaPlanTimelist.CinemaPlanTimeListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo.CinemaInfoRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemainfo.CinemaInfoResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cinemalist.CinemaListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist.CityListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist.CityListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.districtlist.DistrictListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist.MovieListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist.MovieListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist.PlanListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.planlist.PlanListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema.SearchCinemaRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema.SearchCinemaResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist.TrailerListRequestData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.trailerlist.TrailerListResponseData;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ErrorCode;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.SortType;
import com.youku.ticket.android.http.lib.common.CommandDef;

/**
 * @className MainActivity
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午1:42:48
 */
public class MainActivity extends BaseActivity {

    private StringBuffer sb = new StringBuffer();

    private TextView mTxt_citys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }

    @Override
    protected void initView() {
        mTxt_citys = (TextView) findViewById(R.id.txt);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onProtocalSuccess(Object paramObject) {
        if (paramObject instanceof CityListResponseData) {
            receiveCityList(paramObject);
            return;
        }

        if (paramObject instanceof DistrictListResponseData) {
            receiveDistrictList(paramObject);
            return;
        }

        if (paramObject instanceof MovieListResponseData) {
            receiveMovieList(paramObject);
            return;
        }

        if (paramObject instanceof TrailerListResponseData) {
            receiveTrailerList(paramObject);
            return;
        }

        if (paramObject instanceof CinemaListResponseData) {
            receiveCinemaList(paramObject);
            return;
        }

        if (paramObject instanceof CinemaPlanTimeListResponseData) {
            receiveCinemaPlanTimeList(paramObject);
            return;
        }

        if (paramObject instanceof CinemaInfoResponseData) {
            receiveCinemaInfo(paramObject);
            return;
        }

        if (paramObject instanceof SearchCinemaResponseData) {
            receiveSearchCinema(paramObject);
            return;
        }

        if (paramObject instanceof PlanListResponseData) {
            receivePlanList(paramObject);
            return;
        }

    }

    @Override
    public void onProtocalError(Object paramObject) {
        mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
    }

    @Override
    protected void parserMessage(Message msg) {
        super.parserMessage(msg);
        switch (msg.what) {
            case HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS:
                mTxt_citys.setText(sb.toString());
                break;
            case HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL:
                mTxt_citys.setText("数据访问失败");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        sendCommand(CommandDef.PLAN_LIST);
    }

    private void sendCommand(int command) {
        switch (command) {
            case CommandDef.CITYS_LIST:
                sendCityList(command);
                break;
            case CommandDef.DISTRICT_LIST:
                sendDistrictList(command);
                break;
            case CommandDef.MOVIE_LIST:
                sendMovieList(command);
                break;
            case CommandDef.TRAILER_LIST:
                sendTrailerList(command);
                break;
            case CommandDef.CINEMA_LIST:
                sendCinemaList(command);
                break;
            case CommandDef.CINEMAPLANTIME_LIST:
                sendCinemaPlanTimeList(command);
                break;
            case CommandDef.CINEMA_INFO:
                sendCinemaInfo(command);
                break;
            case CommandDef.SEARCH_CINEMA:
                sendSearchCinema(command);
                break;
            case CommandDef.PLAN_LIST:
                sendPlanList(command);
                break;
        }
    }

    /**********************************************************************************************************
     ********************************************* 华丽分割线************************************************
     **********************************************************************************************************/

    /**
     * description: 发送城市列表
     * 
     * @creater LLC
     * @param commandDef
     * @date 2014-12-25 下午2:20:17
     * @editer
     */
    private void sendCityList(int command) {
        mEngine.request(this, command, new CityListRequestData());
    }

    /**
     * description: 接收城市列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveCityList(Object paramObject) {
        CityListResponseData data = (CityListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<CityInfo> cityList = data.getCityList();
            for (CityInfo cityInfo : cityList) {
                sb.append(cityInfo.getCityId());
                sb.append(":");
                sb.append(cityInfo.getCityName());
                sb.append("\n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送城区列表
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendDistrictList(int command) {
        DistrictListRequestData requestData = new DistrictListRequestData();
        requestData.setCityId(110000);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收城区列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveDistrictList(Object paramObject) {
        DistrictListResponseData data = (DistrictListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<DistrictInfo> districtList = data.getDistrictList();
            for (DistrictInfo districtInfo : districtList) {
                sb.append(districtInfo.getDistrictId());
                sb.append(":");
                sb.append(districtInfo.getDistrictName());
                sb.append("\n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送影片列表
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendMovieList(int command) {
        MovieListRequestData requestData = new MovieListRequestData();
        requestData.setCityId(440300);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收影片列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveMovieList(Object paramObject) {
        MovieListResponseData data = (MovieListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<MovieInfo> movieList = data.getMovieList();
            for (MovieInfo movieInfo : movieList) {
                sb.append("  影片：" + movieInfo.getPromName());
                sb.append("  大陆发行时间：" + movieInfo.getReleasedateMainland());
                sb.append("  豆瓣评分：" + movieInfo.getDoubanScore());
                sb.append("  剧情介绍：" + movieInfo.getShowDesc());
                sb.append("  \n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送预告片列表
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendTrailerList(int command) {
        TrailerListRequestData requestData = new TrailerListRequestData();
        requestData.setPromId(186788);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收预告片列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveTrailerList(Object paramObject) {
        TrailerListResponseData data = (TrailerListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<TrailerInfo> trailerList = data.getTrailerList();
            for (TrailerInfo trailerInfo : trailerList) {
                sb.append(trailerInfo.getTitle());
                sb.append(":");
                sb.append(trailerInfo.getVideourl());
                sb.append(":");
                sb.append(trailerInfo.getShowLength());
                sb.append(":");
                sb.append(trailerInfo.getThumburl());
                sb.append("\n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送影院列表
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendCinemaList(int command) {
        CinemaListRequestData requestData = new CinemaListRequestData();
        requestData.setCityId(440300);
        requestData.setPageSize(10);
        requestData.setPageNo(1);
        requestData.setMapLat(22.537491);
        requestData.setMapLon(114.05975);
        requestData.setSortType(SortType.DISTANCE_ASC);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收影院列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveCinemaList(Object paramObject) {
        CinemaListResponseData data = (CinemaListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            sb.append(data.getPageSize() + "<>" + data.getCount());
            ArrayList<CinemaInfo> cinemaList = data.getCinemaList();
            for (CinemaInfo cinemaInfo : cinemaList) {
                sb.append(cinemaInfo.getCinemaName());
                sb.append(":");
                sb.append(cinemaInfo.getAddress());
                sb.append(":");
                sb.append(cinemaInfo.getLowPrice());
                sb.append(":");
                sb.append(cinemaInfo.getDistance());
                sb.append("\n");
            }

            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送上映时间列表
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendCinemaPlanTimeList(int command) {
        CinemaPlanTimeListRequestData requestData = new CinemaPlanTimeListRequestData();
        requestData.setCinemaId(4385);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收上映时间列表
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveCinemaPlanTimeList(Object paramObject) {
        CinemaPlanTimeListResponseData data = (CinemaPlanTimeListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<String> planTimeList = data.getPlanTimeList();
            for (String planTime : planTimeList) {
                sb.append(planTime);
                sb.append("\n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送影院详情
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendCinemaInfo(int command) {
        CinemaInfoRequestData requestData = new CinemaInfoRequestData();
        requestData.setCinemaId(3618);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收影院详情
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveCinemaInfo(Object paramObject) {
        CinemaInfoResponseData data = (CinemaInfoResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            CinemaInfo cinemaInfo = data.getCinemaInfo();
            sb.append(cinemaInfo.getCinemaName() + ",");
            sb.append(cinemaInfo.getTelphone() + ",");
            sb.append(cinemaInfo.getRoute() + ",");
            sb.append(cinemaInfo.getIntro() + ",");
            sb.append(cinemaInfo.getAddress() + ",");
            sb.append("\n");
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送搜索影院
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendSearchCinema(int command) {
        SearchCinemaRequestData requestData = new SearchCinemaRequestData();
        requestData.setCityId(310000);
        requestData.setQueryword("永华");

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收搜索影院
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receiveSearchCinema(Object paramObject) {
        SearchCinemaResponseData data = (SearchCinemaResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            sb.append(data.getPageSize() + "<>" + data.getCount());
            ArrayList<CinemaInfo> cinemaList = data.getCinemaList();
            for (CinemaInfo cinemaInfo : cinemaList) {
                sb.append(cinemaInfo.getCinemaName());
                sb.append(":");
                sb.append(cinemaInfo.getAddress());
                sb.append(":");
                sb.append(cinemaInfo.getLowPrice());
                sb.append(":");
                sb.append(cinemaInfo.getDistance());
                sb.append("\n");
            }

            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

    /**
     * description: 发送影院排期
     * 
     * @creater LLC
     * @param command
     * @date 2014-12-25 下午4:17:17
     * @editer
     */
    private void sendPlanList(int command) {
        PlanListRequestData requestData = new PlanListRequestData();
        requestData.setPromId(186788);
        requestData.setCinemaId(3860);

        mEngine.request(this, command, requestData);
    }

    /**
     * description: 接收影院排期
     * 
     * @creater LLC
     * @param paramObject
     * @date 2014-12-25 下午2:20:02
     * @editer
     */
    private void receivePlanList(Object paramObject) {
        PlanListResponseData data = (PlanListResponseData) paramObject;
        if (data.getHeadInfo().getCode() == ErrorCode.OK) {
            ArrayList<PlanInfo> planList = data.getPlanList();
            for (PlanInfo planInfo : planList) {
                sb.append(planInfo.getHallName());
                sb.append(":");
                sb.append(planInfo.getPlanLg());
                sb.append(":");
                sb.append(planInfo.getPlanStartTime());
                sb.append(":");
                sb.append(planInfo.getPlanEndTime());
                sb.append(":");
                sb.append(planInfo.getStandardPrice());
                sb.append(":");
                sb.append(planInfo.getSokuPrice());
                sb.append("\n");
            }
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_SUCCESS);
        } else {
            mHandler.sendEmptyMessage(HandlerTypeUtils.HANDLER_TYPE_LOAD_DATA_FAIL);
        }
    }

}
