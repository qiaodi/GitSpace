package com.youku.ticket.app.utils.cache;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

public class AppImageSDCardCache {

    private static AppImageSDCardCache mInstance;

    private final String CACHE_DIR = "";

    private final int PNGQUANTITY = 85;

    private final long FREE_SD_SPACE_NEEDED_TO_CACHE = 10 * 1024;

    private final long EXPIRED_TIME = 5 * 24 * 60 * 60 * 1000L;

    private final KeyedLock<String> mKeyLock = new KeyedLock<String>();

    private final String TAG = this.getClass().getSimpleName();

    public static AppImageSDCardCache getInstance() {
        if (mInstance == null) {
            synchronized (AppImageSDCardCache.class) {
                mInstance = new AppImageSDCardCache();
            }
        }
        return mInstance;
    }

    protected AppImageSDCardCache() {
        // TODO Auto-generated constructor stub
    }

    /**
     * description: TODO 从文件读取Bitmap，只有当不同线程读取同一个文件时会被锁
     * @creater QIAODI
     * @param key
     * @return
     * @date 2015年2月5日 下午4:57:13
     * @editer 	
     */
    public Bitmap getImage(String key) {
        mKeyLock.lock(key);
        Bitmap bp = null;
        String realPath = CACHE_DIR + "/" + key;
        File file = new File(realPath);
        if (file.exists()) {
            updateFileStamp(file);
            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inJustDecodeBounds = false;
            BitmapFactory.decodeFile(realPath, op);
            mKeyLock.unlock(key);
            return bp;
        } else {
            mKeyLock.unlock(key);
            return null;
        }
    }

    /**
     * description: TODO 将bitmap固化到文件
     * @creater QIAODI
     * @param key
     * @param bp
     * @date 2015年2月5日 下午5:00:10
     * @editer 	
     */
    public void saveImage(String key, Bitmap bp) {
        if (!hasEnoughSpace()) {
            clearCache();
        }

        if (!hasEnoughSpace()) {
            Log.e(TAG,"文件系统容量不足！");
            return;
        }

        File dir = new File(CACHE_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            mKeyLock.lock(key);
            String realPath = CACHE_DIR + "/" + key;
            File file = new File(realPath);
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            bp.compress(Bitmap.CompressFormat.PNG, PNGQUANTITY, out);
            out.flush();
            out.close();
            updateFileStamp(file);
        } catch (Exception e) {

        } finally {
            mKeyLock.unlock(key);
        }
    }

    /**
     * description: TODO 更新文件时间都最后一次被读写的时间
     * 
     * @creater QIAODI
     * @param file
     * @date 2015年2月5日 下午4:47:47
     * @editer
     */
    private void updateFileStamp(File file) {
        // TODO Auto-generated method stub
        long newModifiedTime = System.currentTimeMillis();
        if (!file.setLastModified(newModifiedTime)) {
            Log.e(TAG, "file.setLastModified is failed!!");
        }
    }

    private boolean hasEnoughSpace() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return Environment.getExternalStorageDirectory().getUsableSpace() > FREE_SD_SPACE_NEEDED_TO_CACHE;
        } else {
            // maybe make singleton
            final StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (long) stat.getAvailableBlocks() * (long) stat.getBlockSize() > FREE_SD_SPACE_NEEDED_TO_CACHE;
        }
    }

    @SuppressWarnings("unused")
    private void removeExpiredCache(String key) {
        if (mKeyLock.isLocked(key)) {
            File file = new File(CACHE_DIR + "/" + key);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * description: TODO 将超过EXPIRED_TIME的文件（在EXPIRED_TIME里没有被读写过）删除
     * @creater QIAODI
     * @date 2015年2月5日 下午5:02:19
     * @editer 	
     */
    public void clearCache() {
        File dir = new File(CACHE_DIR);
        if (dir.exists()) {
            File[] cachedImages = dir.listFiles(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    // TODO Auto-generated method stub                  
                    return System.currentTimeMillis() - file.lastModified() > EXPIRED_TIME;
                }
            });

            for (int i = 0; i < cachedImages.length; i++) {
                if (mKeyLock.isLocked(cachedImages[i].getName()) == false) {
                    cachedImages[i].delete();
                }
            }
        }
    }

    /**
     * description: TODO 获取disk cached list（文件名list = key list）
     * @creater QIAODI
     * @return
     * @date 2015年2月5日 下午5:03:26
     * @editer 	
     */
    public ArrayList<String> getSDCachedList() {
        ArrayList<String> keyList = new ArrayList<String>();
        File dir = new File(CACHE_DIR);
        if (dir.exists()) {
            File[] cachedImages = dir.listFiles();
            for (File file : cachedImages) {
                keyList.add(file.getName());
            }
        }
        return keyList;
    }
}
