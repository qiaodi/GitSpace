package com.youku.ticket.app.pages.commentsets;

import android.os.Bundle;
import android.widget.ListView;

import com.youku.ticket.R;
import com.youku.ticket.app.templates.BaseActivity;
import com.youku.ticket.app.templates.BaseDataProvider;

public class CommentDetailsActivity extends BaseActivity {

    private CommentDetailsAdapter mAdapter;
    
    private ListView mCommentDetailsList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub     
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
        bundle.getInt("CommentsID");
        setContentView(R.layout.commentsdetails);
        addAppBar(false);
        mAdapter = new CommentDetailsAdapter(this);
        mCommentDetailsList = (ListView) findViewById(R.id.commentDetailList);
        mCommentDetailsList.setAdapter(mAdapter);
    }
    
    @Override
    public void onDataUpdatedCb(Object response_data) {
        // TODO Auto-generated method stub

    }

    @Override
    public BaseDataProvider creatDataProvider() {
        // TODO Auto-generated method stub
        return new CommentDetailsDataProvider(this);
    }

}
