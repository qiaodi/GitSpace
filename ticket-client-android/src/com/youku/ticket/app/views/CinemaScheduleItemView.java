package com.youku.ticket.app.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.youku.ticket.R;
import com.youku.ticket.app.model.CinemaScheduleItemModel;
import com.youku.ticket.app.templates.BaseView;

/**
 * @className CinemaScheduleItemView
 * @description TODO 影院排期表项目视图
 * @author QIAODI
 * @date 2015年1月9日 下午4:22:23
 */
public class CinemaScheduleItemView extends BaseView {

    private TextView tv_startTime;

    private TextView tv_endTime;

    private TextView tv_room;

    private TextView tv_style;

    private TextView tv_price;

    private Button btn_buyTicket;

    public CinemaScheduleItemView(View node) {
        super(node);
        // TODO Auto-generated constructor stub
        tv_startTime = (TextView) node.findViewById(R.id.cinema_schedule_gamestarttime);
        tv_endTime = (TextView) node.findViewById(R.id.cinema_schedule_gameendtime);
        tv_style = (TextView) node.findViewById(R.id.cinema_schedule_gamestyle);
        tv_room = (TextView) node.findViewById(R.id.cinema_schedule_gameroom);
        tv_price = (TextView) node.findViewById(R.id.cinema_schedule_gameprice);
        btn_buyTicket = (Button) node.findViewById(R.id.cinema_schedule_buytickct);
    }

    @Override
    public void setView(Object data) {
        // TODO Auto-generated method stub
        tv_startTime.setText(((CinemaScheduleItemModel)data).getStartTime());
        tv_endTime.setText(((CinemaScheduleItemModel)data).getEndTime());
        tv_style.setText(((CinemaScheduleItemModel)data).getStyle());
        tv_room.setText(((CinemaScheduleItemModel)data).getRoom());
        tv_price.setText(((CinemaScheduleItemModel)data).getPrice());
    }

}
