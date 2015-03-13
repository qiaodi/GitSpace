package com.youku.ticket.app.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.youku.ticket.R;
import com.youku.ticket.app.threads.CooperationThread;
import com.youku.ticket.app.utils.cache.AppImageMemCache;
import com.youku.ticket.app.utils.cache.AppImageSDCardCache;
import com.youku.ticket.app.utils.cache.CacheKeyGen;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

/**
 * @className ImageLoader
 * @description TODO 异步加载图片工具类
 * @author QIAODI
 * @date 2015年2月5日 下午4:01:52
 */
public class ImageLoader {

    public static final String TAG = ImageLoader.class.getSimpleName();

    private ExecutorService mImageLoadingExecutor;

    private volatile static ImageLoader mInstance;

    public static ImageLoader getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoader();
                }
            }
        }
        return mInstance;
    }

    protected ImageLoader() {
        mImageLoadingExecutor = Executors.newCachedThreadPool();
    }

    public void displayImage(String uri, ImageView imageView) {
        new ImageTask(imageView).executeOnExecutor(mImageLoadingExecutor, uri);
    }

    private class ImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView mImageView;

        public ImageTask(ImageView imageView) {
            // TODO Auto-generated constructor stub
            mImageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub
            Bitmap result = LoadCachedImage(params[0]);
            if (result == null) {
                result = LoadRemoteImage(params[0]);
            }
            if (result == null) {
                Log.w(TAG, "LoadImage " + params[0] + " Failed");
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            if (result != null) {
                mImageView.setImageBitmap(result);
            } else {
                mImageView.setImageResource(R.drawable.default_poster);
            }
        }
    }

    private Bitmap LoadCachedImage(String uri) {
        String key = CacheKeyGen.getInstance().getCacheKey(uri);
        Bitmap bp = AppImageMemCache.getInstance().getImageCached(key);
        if (bp == null) {
            bp = AppImageSDCardCache.getInstance().getImage(key);
            CooperationThread.getInstance().saveCacheInMount(key, bp);
        }
        return bp;
    }

    private Bitmap LoadRemoteImage(String uri) {
        Bitmap bp = null;//LoadfromHttpLib
        String key = CacheKeyGen.getInstance().getCacheKey(uri);
        CooperationThread.getInstance().saveCacheInMem(key, bp);
        CooperationThread.getInstance().saveCacheInMount(key, bp);
        return bp;
    }
}
