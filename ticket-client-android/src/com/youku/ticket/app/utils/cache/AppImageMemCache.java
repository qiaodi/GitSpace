package com.youku.ticket.app.utils.cache;

import android.graphics.Bitmap;

public abstract class AppImageMemCache {
    
    protected static final String TAG = AppImageMemCache.class.getSimpleName();
            
    private static AppImageMemCache mInstance;

    protected AppImageMemCache() {
        // TODO Auto-generated constructor stub
    }

    public static AppImageMemCache getInstance() {
        if (mInstance == null) {
            synchronized (AppImageMemCache.class) {
                mInstance = new AppImageMemSoftCache();
            }
        }
        return mInstance;
    }

    public abstract void setImageCache(String key, Bitmap bp);

    public abstract Bitmap getImageCached(String key);

    public abstract void clearCache();

    public abstract boolean isCachedInMem(String key);
}
