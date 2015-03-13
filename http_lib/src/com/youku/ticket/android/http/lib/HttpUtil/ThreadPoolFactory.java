/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className ThreadPoolFactory
 * @description 线程池工厂
 * @author LLC
 * @date 2014-12-22 下午5:26:56
 */
public class ThreadPoolFactory {

    private static ExecutorService exe = null;

    public static ExecutorService getInstance() {
        if (exe == null) {
            exe = Executors.newCachedThreadPool();
        }
        return exe;
    }

}
