/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.MovieInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className MovieListResponseData
 * @description 影片列表响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class MovieListResponseData extends ResponseDataBase {

    private ArrayList<MovieInfo> movieList = null;

    /**
     * description: 返回影片列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-25 下午4:42:29
     * @editer
     */
    public ArrayList<MovieInfo> getMovieList() {
        return movieList;
    }

    /**
     * description: 设置影片列表
     * 
     * @creater LLC
     * @param movieList
     * @date 2014-12-25 下午4:42:40
     * @editer
     */
    public void setMovieList(ArrayList<MovieInfo> movieList) {
        this.movieList = movieList;
    }

}
