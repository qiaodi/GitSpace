package com.youku.ticket.app.views;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CinemaStyleItemModel;
import com.youku.ticket.app.templates.BaseView;

import android.view.View;
import android.widget.TextView;

/**
 * @className CinemaStyleItemView
 * @description TODO 影院列表页项目视图
 * @author QIAODI
 * @date 2015年1月9日 下午4:23:01
 */
public class CinemaStyleItemView  extends BaseView{

    private TextView cinema_name;

    private TextView cinema_distance;

    private TextView cinema_addr;

    private TextView cinema_price;

    public CinemaStyleItemView(View node) {
        // TODO Auto-generated constructor stub
        super(node);
        cinema_name = (TextView) node.findViewById(R.id.cinema_name);
        cinema_distance = (TextView) node.findViewById(R.id.cinema_distance);
        cinema_addr = (TextView) node.findViewById(R.id.cinema_addr);
        cinema_price = (TextView) node.findViewById(R.id.cinema_price);
    }
    
    @Override
    public void setView(Object data) {
        cinema_name.setText(((CinemaStyleItemModel) data).getCinemaName());
        cinema_distance.setText(((CinemaStyleItemModel) data).getCinemaDistance());
        cinema_addr.setText(((CinemaStyleItemModel) data).getCinemaAddr());
        cinema_price.setText(((CinemaStyleItemModel) data).getCinemaPrice());
    }
}
