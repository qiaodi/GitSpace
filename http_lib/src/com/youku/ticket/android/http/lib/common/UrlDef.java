/**
 * @title UrlDef.java
 * @package com.youku.ticket.android.http.lib.common
 * @description TODO
 * @author LLC
 * @date 2014-12-22 下午6:14:37
 * @version V1.0
 */
package com.youku.ticket.android.http.lib.common;

import java.io.File;

import android.os.Environment;

/**
 * @className UrlDef
 * @description 默认URL
 * @author LLC
 * @date 2014-12-22 下午6:14:37
 */
public class UrlDef {
 
    private static final String SERVER_URL = "http://10.111.8.29/";

    private static final String TEST_SERVER_URL = "http://10.111.8.29/";

    /**
     * description: 返回服务器地址
     * 
     * @creater LLC
     * @return
     * @date 2014-12-22 下午6:17:01
     * @editer
     */
    public static String getServerUrl() {
        try {
            String path = Environment.getExternalStorageDirectory() + "/data/test";
            File f = new File(path);
            if (f.exists()) {
                return SERVER_URL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TEST_SERVER_URL;
    }

}
