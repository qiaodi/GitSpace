/**
 * @title ThreadPoolUtil.java
 * @package com.example.youkudemo
 * @description TODO
 * @author LLC
 * @date 2014-12-25 下午2:06:38
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className ThreadPoolUtil
 * @description 线程池工具类
 * @author LLC
 * @date 2014-12-25 下午2:06:38
 */
public class ThreadPoolUtil {

    private static ExecutorService instance = null;

    private ThreadPoolUtil() {
    }

    public static ExecutorService getInstance() {
        if (instance == null) instance = Executors.newCachedThreadPool();
        return instance;
    }
}
