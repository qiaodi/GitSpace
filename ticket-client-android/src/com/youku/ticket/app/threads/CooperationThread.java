package com.youku.ticket.app.threads;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

import com.youku.ticket.app.utils.cache.AppImageMemCache;
import com.youku.ticket.app.utils.cache.AppImageSDCardCache;
import com.youku.ticket.app.utils.cache.CacheKeyGen;


/**
 * @className CooperationThread
 * @description TODO 处理UI无关的异步任务
 * @author QIAODI
 * @date 2015年2月5日 下午4:01:08
 */
public class CooperationThread extends HandlerThread implements Callback{

    private final String TAG = getClass().getSimpleName();
    
    public final int MESSAGE_INIT_CACHES = 1;
    public final int MESSAGE_SAVE_CACHE_IN_MOUNT = 2;
    public final int MESSAGE_SAVE_CACHE_IN_MEM = 3;
    
    private static CooperationThread mCooperationThread;
    
    private Handler mCooperationHandler;
    
    public static CooperationThread getInstance(){
        if(mCooperationThread != null){
            synchronized (CooperationThread.class) {
                mCooperationThread = new CooperationThread("CooperationThread");
            }
        }
        return mCooperationThread;
    }
  
    private CooperationThread(String name) {
        super(name);
        // TODO Auto-generated constructor stub
        mCooperationHandler = new Handler(mCooperationThread.getLooper(), (Callback) mCooperationThread);
    }

    @Override
    public boolean handleMessage(Message msg){
        Bundle bundle = (Bundle) msg.obj;
        switch (msg.what) {
            case MESSAGE_INIT_CACHES:
                LoadAllCachedInMem();
                break;
            case MESSAGE_SAVE_CACHE_IN_MOUNT:
                AppImageSDCardCache.getInstance().saveImage(bundle.getString("key"), (Bitmap) bundle.getParcelable("data"));
                break;
            case MESSAGE_SAVE_CACHE_IN_MEM:
                AppImageMemCache.getInstance().setImageCache(bundle.getString("key"), (Bitmap) bundle.getParcelable("data"));
                break;
            default:
                break;
        }
        return false;
    }
    
    /**
     * description: TODO 将所有文件形式的cache导入到内存
     * @creater QIAODI
     * @date 2015年2月5日 下午5:05:44
     * @editer 	
     */
    public void initCaches(){
        mCooperationHandler.sendEmptyMessage(MESSAGE_INIT_CACHES);
    }
    
    public void saveCacheInMount(String key, Bitmap bp){
        Message msg = Message.obtain();
        msg.what = MESSAGE_SAVE_CACHE_IN_MOUNT;
        Bundle obj = new Bundle();
        obj.putString("key", key);
        obj.putParcelable("data", bp);
        msg.obj = obj;
        mCooperationHandler.sendMessage(msg);
    }

    public void saveCacheInMem(String key, Bitmap bp){
        Message msg = Message.obtain();
        msg.what = MESSAGE_SAVE_CACHE_IN_MEM;
        Bundle obj = new Bundle();
        obj.putString("key", key);
        obj.putParcelable("data", bp);
        msg.obj = obj;
        mCooperationHandler.sendMessage(msg);
    }
    
    private void LoadAllCachedInMem(){
        ArrayList<String> list = AppImageSDCardCache.getInstance().getSDCachedList();
        Bitmap bp = null;
        for (String key : list) {
            if(false == AppImageMemCache.getInstance().isCachedInMem(key)){
                bp = AppImageSDCardCache.getInstance().getImage(key);
                AppImageMemCache.getInstance().setImageCache(key, bp);
            }
        }
    }
}
