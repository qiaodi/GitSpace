package com.youku.ticket.app.utils.cache;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentHashMap;

import android.graphics.Bitmap;

public class AppImageMemSoftCache extends AppImageMemCache {

    private ConcurrentHashMap<String, CacheBitmap> mCachedImageSet;

    private ReferenceQueue<Bitmap> mRecycleBitmaps;

    public AppImageMemSoftCache() {
        // TODO Auto-generated constructor stub
        mCachedImageSet = new ConcurrentHashMap<String, CacheBitmap>();
        mRecycleBitmaps = new ReferenceQueue<Bitmap>();
    }

    public void setImageCache(String key, Bitmap bp) {
        cleanCache();
        CacheBitmap cache = new CacheBitmap(key, bp, mRecycleBitmaps);
        mCachedImageSet.put(key, cache);
    }

    private void cleanCache() {
        // TODO Auto-generated method stub
        CacheBitmap cache = null;
        while ((cache = (CacheBitmap) mRecycleBitmaps.poll()) != null) {
            mCachedImageSet.remove(cache.key);
        }
    }

    public Bitmap getImageCached(String key) {
        if (mCachedImageSet.containsKey(key)) {
            CacheBitmap cache = mCachedImageSet.get(key);
            if (cache.get() == null) {
                return null;
            } else {
                return cache.get();
            }
        } else {
            return null;
        }
    }

    public void clearCache() {
        cleanCache();
        mCachedImageSet.clear();
        System.gc();
        System.runFinalization();
    }

    public boolean isCachedInMem(String key) {
        return mCachedImageSet.containsKey(key);
    }
}
