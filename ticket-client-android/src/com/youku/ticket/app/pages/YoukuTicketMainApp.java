package com.youku.ticket.app.pages;

import com.youku.ticket.app.threads.CooperationThread;

import android.app.Application;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;

public class YoukuTicketMainApp extends Application {
    
    private CooperationThread mCooperationThread;
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mCooperationThread = CooperationThread.getInstance();
        mCooperationThread.setDaemon(true);
        mCooperationThread.start();  
        initCaches();
    }
    
    private void initCaches(){
        mCooperationThread.initCaches();
    }
}
