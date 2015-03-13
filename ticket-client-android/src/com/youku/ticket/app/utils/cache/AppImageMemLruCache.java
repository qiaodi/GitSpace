package com.youku.ticket.app.utils.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class AppImageMemLruCache extends AppImageMemCache {

    private LruCache<String, Bitmap> mCachedImageSet;

    public static final int DEFAULT_CACHE_SIZE = (24 /* MiB */* 1024 * 1024); // in bytes

    public AppImageMemLruCache() {
        // TODO Auto-generated constructor stub
        mCachedImageSet = new LruCache<String, Bitmap>(DEFAULT_CACHE_SIZE) {

            @Override
            protected int sizeOf(String key, Bitmap value) {
                // TODO Auto-generated method stub
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public void setImageCache(String key, Bitmap bp) {
        // TODO Auto-generated method stub
        mCachedImageSet.put(key, bp);
    }

    @Override
    public Bitmap getImageCached(String key) {
        // TODO Auto-generated method stub
        return mCachedImageSet.get(key);
    }

    @Override
    public void clearCache() {
        // TODO Auto-generated method stub
        mCachedImageSet.evictAll();
    }

    @Override
    public boolean isCachedInMem(String key) {
        // TODO Auto-generated method stub
        return mCachedImageSet.get(key) != null;
    }

}
