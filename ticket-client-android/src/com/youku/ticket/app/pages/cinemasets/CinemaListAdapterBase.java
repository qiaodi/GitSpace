package com.youku.ticket.app.pages.cinemasets;

import java.util.ArrayList;

import com.youku.ticket.R;
import com.youku.ticket.android.http.lib.ProtocalEngine.ProtocalModel.basemodel.CinemaInfo;
import com.youku.ticket.app.model.CinemaStyleItemModel;
import com.youku.ticket.app.pages.cinemasets.CinemaListFragmentBase.CinemaListDataType;
import com.youku.ticket.app.views.CinemaStyleItemView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @className CinemaListAdapter
 * @description TODO 影院列表适配器
 * @author QIAODI
 * @date 2014年12月26日 下午4:40:57
 */
public class CinemaListAdapterBase extends BaseAdapter {

    private Context mContext;

    private String[] CINEMA_NAME = { "北京UME国际影城-华星", "北京博纳国际影城-悠唐店", "海淀剧院", "北京UME国际影城(双井店)", "北京金逸国际电影城(中关村店)" };

    private String[] CINEMA_ADDR = { "双榆树科学院南路44号", "朝阳区三丰北里2号楼悠唐生活广场B1层", "双榆树科学院南路44号", "朝阳区东三环中路双井桥北富力广场5-6层", "海淀区中关村大街19号新中关购物中心B1层 " };

    private String[] CINEMA_PRICE = { "票价：20rmb", "票价：200rmb", "票价：20rmb", "票价：80rmb", "票价：20rmb" };

    private String[] CINEMA_DIST = { "距离：1KM", "距离：1.5KM", "距离：200M", "距离：1KM", "距离：1KM" };

    private final CinemaListDataType mCinemaListDataType;

    private int mTargetMovie;

    public CinemaListAdapterBase(Context context, CinemaListDataType cinemaListDataType, int targetMovie) {
        // TODO Auto-generated constructor stub
        mContext = context;
        mCinemaListDataType = cinemaListDataType;
        mTargetMovie = targetMovie;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (mCinemaListDataType == CinemaListDataType.SALES) return CINEMA_NAME.length - 2;
        else return CINEMA_NAME.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        CinemaStyleItemView holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cinema_item, null);
            holder = new CinemaStyleItemView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (CinemaStyleItemView) convertView.getTag();
        }
        
        holder.setView(new CinemaStyleItemModel(CINEMA_NAME[position], CINEMA_ADDR[position], CINEMA_DIST[position], CINEMA_PRICE[position]));
        
        return convertView;
    }

    public void setData(ArrayList<CinemaInfo> cinemaList) {
        // TODO Auto-generated method stub
        for (int i = 0; i < cinemaList.size(); i++) {
            CINEMA_NAME[i] = cinemaList.get(i).getCinemaName();
            CINEMA_ADDR[i] = cinemaList.get(i).getAddress();
        }
        notifyDataSetChanged();
    }
}
