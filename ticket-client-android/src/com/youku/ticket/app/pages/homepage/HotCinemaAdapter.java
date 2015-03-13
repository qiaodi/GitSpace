package com.youku.ticket.app.pages.homepage;

import java.util.zip.Inflater;

import com.youku.ticket.R;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @className HotCinemaAdapter
 * @description TODO 热门影院子控件的适配器
 * @author QIAODI
 * @date 2014年12月26日 下午5:00:17
 */
public class HotCinemaAdapter extends BaseAdapter {

    private String[] CINEMA_NAME = { "北京UME国际影城-华星","北京博纳国际影城-悠唐店", "海淀剧院", "北京UME国际影城(双井店)", "北京金逸国际电影城(中关村店)" };

    private String[] CINEMA_ADDR = { "双榆树科学院南路44号","朝阳区三丰北里2号楼悠唐生活广场B1层", "双榆树科学院南路44号", "朝阳区东三环中路双井桥北富力广场5-6层", "海淀区中关村大街19号新中关购物中心B1层 " };

    private Context mContext;

    public HotCinemaAdapter(Context context) {
        // TODO Auto-generated constructor stub
        mContext = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return CINEMA_NAME.length;
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
        View itemView = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.mainpage_hotcinema_item, null);
        }
        TextView name = (TextView) itemView.findViewById(R.id.hotcinema_name);
        name.setText(CINEMA_NAME[position]);
        TextView addr = (TextView) itemView.findViewById(R.id.hotcinema_address);
        addr.setText(CINEMA_ADDR[position]);
        return itemView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub

    }
}
