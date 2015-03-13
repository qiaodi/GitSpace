/**
 * @title CityListResponseParser.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.movielist;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.MovieInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseParserBase;

/**
 * @className MovieListResponseParser
 * @description 影片列表响应解析器
 * @author LLC
 * @date 2014-12-25 上午11:01:41
 */
public class MovieListResponseParser extends ResponseParserBase {

    private final String LABEL_BODY_PROMID = "promId";

    private final String LABEL_BODY_PROMNAME = "promName";

    private final String LABEL_BODY_CINEMACOUNT = "cinemaCount";

    private final String LABEL_BODY_LOWPRICE = "lowPrice";

    private final String LABEL_BODY_VIMG = "vimg";

    private final String LABEL_BODY_TRAILER = "trailer";

    private final String LABEL_BODY_RELEASEDATEMAINLAND = "releasedateMainland";

    private final String LABEL_BODY_AREA = "area";

    private final String LABEL_BODY_GRENRE = "grenre";

    private final String LABEL_BODY_DIRECTOR = "director";

    private final String LABEL_BODY_PERFORMER = "performer";

    private final String LABEL_BODY_SHOWLENGTH = "showlength";

    private final String LABEL_BODY_DOUBANSCORE = "doubanScore";

    private final String LABEL_BODY_MOVIETYPE = "movieType";

    private final String LABEL_BODY_TRAILERVIDEOID = "trailerVideoid";

    private final String LABEL_BODY_SHOWDESC = "showDesc";

    private final String LABEL_BODY_PLANCOUNT = "planCount";

    private MovieListResponseData responseData = new MovieListResponseData();

    @Override
    public Object getResponseData() throws Exception {
        responseData.setHeadInfo(this.headInfo);
        return responseData;
    }

    @Override
    protected void fetchBody() throws Exception {

        ArrayList<MovieInfo> movieList = new ArrayList<MovieInfo>();

        JSONArray bodyJsonArr = this.jsonObject.getJSONArray(TAG_BODY);

        for (int i = 0; i < bodyJsonArr.length(); i++) {
            JSONObject bodyJsonObj = bodyJsonArr.getJSONObject(i);
            int promId = bodyJsonObj.getInt(LABEL_BODY_PROMID);
            String promName = bodyJsonObj.getString(LABEL_BODY_PROMNAME);
            int cinemaCount = bodyJsonObj.getInt(LABEL_BODY_CINEMACOUNT);
            int planCount = bodyJsonObj.getInt(LABEL_BODY_PLANCOUNT);
            int lowPrice = bodyJsonObj.getInt(LABEL_BODY_LOWPRICE);
            String vimg = bodyJsonObj.getString(LABEL_BODY_VIMG);
            String trailer = bodyJsonObj.getString(LABEL_BODY_TRAILER);
            String releasedateMainland = bodyJsonObj.getString(LABEL_BODY_RELEASEDATEMAINLAND);
            String area = bodyJsonObj.getString(LABEL_BODY_AREA);
            String grenre = bodyJsonObj.getString(LABEL_BODY_GRENRE);

            //导演名称
            JSONArray directorJsonArr = bodyJsonObj.getJSONArray(LABEL_BODY_DIRECTOR);
            int directorNum = directorJsonArr.length();
            String[] directors = new String[directorNum];
            for (int j = 0; j < directorNum; j++) {
                directors[j] = directorJsonArr.getString(j);
            }

            //主演名称
            JSONArray performerJsonArr = bodyJsonObj.getJSONArray(LABEL_BODY_PERFORMER);
            int performerNum = performerJsonArr.length();
            String[] performers = new String[performerNum];
            for (int j = 0; j < performerNum; j++) {
                performers[j] = performerJsonArr.getString(j);
            }

            int showlength = bodyJsonObj.getInt(LABEL_BODY_SHOWLENGTH);
            double doubanScore = bodyJsonObj.getDouble(LABEL_BODY_DOUBANSCORE);
            int movieType = bodyJsonObj.getInt(LABEL_BODY_MOVIETYPE);
            int trailerVideoid = bodyJsonObj.getInt(LABEL_BODY_TRAILERVIDEOID);
            String showDesc = bodyJsonObj.getString(LABEL_BODY_SHOWDESC);

            MovieInfo info = new MovieInfo();
            info.setPromId(promId);
            info.setPromName(promName);
            info.setCinemaCount(cinemaCount);
            info.setPlanCount(planCount);
            info.setLowPrice(lowPrice);
            info.setVimg(vimg);
            info.setTrailer(trailer);
            info.setReleasedateMainland(releasedateMainland);
            info.setArea(area);
            info.setGrenre(grenre);
            info.setDirector(directors);
            info.setPerformer(performers);
            info.setShowlength(showlength);
            info.setDoubanScore(doubanScore);
            info.setMovieType(movieType);
            info.setTrailerVideoid(trailerVideoid);
            info.setShowDesc(showDesc);
            movieList.add(info);
        }

        responseData.setMovieList(movieList);
    }
}
