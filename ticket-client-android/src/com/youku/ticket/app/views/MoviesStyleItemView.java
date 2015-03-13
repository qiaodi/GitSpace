package com.youku.ticket.app.views;

import com.youku.ticket.R;
import com.youku.ticket.app.model.MoviesStyleItemModel;
import com.youku.ticket.app.templates.BaseView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @className MoviesStyleItemView
 * @description TODO 影院列表页列表项视图
 * @author QIAODI
 * @date 2015年1月9日 下午4:33:41
 */
public class MoviesStyleItemView extends BaseView{

    private ImageView mMoviePoster;

    private TextView mMovieName;

    private TextView mMovieInfo;

    private TextView mMovieScore;

    private Button mMovieOperation;

    public MoviesStyleItemView(View node) {
        // TODO Auto-generated constructor stub
        super(node);
        mMoviePoster = (ImageView) node.findViewById(R.id.movieitem_poster);
        mMovieName = (TextView) node.findViewById(R.id.movieitem_name);
        mMovieInfo = (TextView) node.findViewById(R.id.movieitem_info);
        mMovieScore = (TextView) node.findViewById(R.id.movieitem_score);
        mMovieOperation = (Button) node.findViewById(R.id.movieitem_operation);
    }

    @Override
    public void setView(Object data) {
        // TODO Auto-generated method stub
        mMoviePoster.setImageResource(((MoviesStyleItemModel) data).getMovieRosterResource());
        mMovieName.setText(((MoviesStyleItemModel) data).getMovieName());
        mMovieInfo.setText(((MoviesStyleItemModel) data).getMovieInfo());
        mMovieScore.setText(((MoviesStyleItemModel) data).getMovieScore());
        mMovieOperation.setOnClickListener(((MoviesStyleItemModel) data).getMovieOperationHandle());
    }
}
