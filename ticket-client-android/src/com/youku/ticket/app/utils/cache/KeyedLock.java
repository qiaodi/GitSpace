package com.youku.ticket.app.utils.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import android.util.Log;

/**
 * @className KeyedLock
 * @description TODO 对应每一个key创建一把独立的同步锁
 * @author QIAODI
 * @date 2015年2月5日 下午4:39:36
 */
public class KeyedLock<K> {
    private static final String TAG = KeyedLock.class.getSimpleName();

    private final Map<K, ReentrantLock> mLocks = new HashMap<K, ReentrantLock>();

    private static boolean DEBUG = false;

    /**
     * description: TODO 加锁
     * @creater QIAODI
     * @param key
     * @date 2015年2月5日 下午4:39:32
     * @editer 	
     */
    public void lock(K key) {
        if (DEBUG) {
            log("acquiring lock for key " + key);
        }

        ReentrantLock lock;
        synchronized (mLocks) {
            lock = mLocks.get(key);
            if (lock == null) {
                lock = new ReentrantLock();
                mLocks.put(key, lock);
                if (DEBUG) {
                    log(lock + " created new lock and added it to map");
                }

            }
        }

        lock.lock();
    }


    /**
     * description: TODO 解锁
     * @creater QIAODI
     * @param key
     * @date 2015年2月5日 下午4:39:14
     * @editer 	
     */
    public void unlock(K key) {
        if (DEBUG) {
            log("unlocking lock for key " + key);
        }
        ReentrantLock lock;

        synchronized (mLocks) {
            lock = mLocks.get(key);
            if (lock == null) {
                Log.e(TAG, "Attempting to unlock lock for key " + key + " which has no entry");
                return;
            }
            if (DEBUG) {
                log(lock + " has queued threads " + lock.hasQueuedThreads() + " for key " + key);
            }
            // maybe entries should be removed when there are no queued threads. This would
            // occasionally fail...
            // final boolean queued = lock.hasQueuedThreads();

            lock.unlock();
        }
    }

    /**
     * description: TODO 查询是否被锁
     * @creater QIAODI
     * @param key
     * @return
     * @date 2015年2月5日 下午4:39:57
     * @editer 	
     */
    public boolean isLocked(K key){
        ReentrantLock lock = mLocks.get(key);
        return lock != null && lock.isLocked();
    }
    
    private void log(String message) {

        Log.d(TAG, Thread.currentThread().getId() + "\t" + message);

    }
}