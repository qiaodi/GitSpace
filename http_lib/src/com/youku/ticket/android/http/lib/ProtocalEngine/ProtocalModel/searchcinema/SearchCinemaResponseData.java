/**
 * @title CityListResponseData.java
 * @package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.cityslist
 * @description TODO
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.searchcinema;

import java.util.ArrayList;

import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalUtil.ResponseDataBase;

/**
 * @className SearchCinemaResponseData
 * @description 搜索影院响应数据
 * @author LLC
 * @date 2014-12-25 上午11:00:42
 */
public class SearchCinemaResponseData extends ResponseDataBase {

    private int pageSize;//每页显示多少记录数

    private int pageCount;//总页数

    private int count;//总数

    private int pageNo;//第几页

    private ArrayList<CinemaInfo> cinemaList = null;//上映影院列表

    /**
     * description: 每页显示多少记录数
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:02:27
     * @editer
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * description: 总页数
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:02:40
     * @editer
     */
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * description: 总数
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:02:57
     * @editer
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * description: 第几页
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:03:11
     * @editer
     */
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * description: 上映影院列表
     * 
     * @creater LLC
     * @return
     * @date 2014-12-26 上午11:03:27
     * @editer
     */
    public ArrayList<CinemaInfo> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<CinemaInfo> cinemaList) {
        this.cinemaList = cinemaList;
    }

}
