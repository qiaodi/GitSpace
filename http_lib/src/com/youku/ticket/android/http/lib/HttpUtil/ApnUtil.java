/**
 * 
 */
package com.youku.ticket.android.http.lib.HttpUtil;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/**
 * @className ApnUtil
 * @description APN工具类
 * @author LLC
 * @date 2014-12-22 下午5:22:28
 */
public class ApnUtil {

    public static Proxy getApnProxy(Context context) {

        // String apn = PhoneInfo.getAccessPoint(context);
        // System.out.println("里面:" + apn);
        //
        // String proxy = null;
        // String port = null;
        //
        // if (apn.equals("cmwap") || apn.equals("uniwap") ||
        // apn.equals("3gwap")) {
        // proxy = "10.0.0.172";
        // port = "80";
        // } else if (apn.equals("ctwap")) {
        // proxy = "10.0.0.200";
        // port = "80";
        // }
        //
        // System.out.println("ip:" + proxy);
        //
        // if ((proxy != null) && (!proxy.equals(""))) {
        // if (validateIp(proxy)) {
        // return new Proxy(Proxy.Type.HTTP,
        // InetSocketAddress.createUnresolved(proxy, Integer
        // .valueOf(port).intValue()));
        // }
        //
        // return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy,
        // Integer.valueOf(port).intValue()));
        // }

        NetworkInfo ni = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();

        if (ni.isConnected()) {
            return null;
        }

        Cursor c = getCurrentApn(context);
        if (c.getCount() > 0) {
            c.moveToFirst();
            long id = c.getLong(c.getColumnIndex("_id"));

            String proxy = c.getString(c.getColumnIndex("proxy"));
            String port = c.getString(c.getColumnIndex("port"));

            c.close();

            if ((proxy != null) && (!proxy.equals(""))) {
                if (validateIp(proxy)) {
                    return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxy, Integer.valueOf(port).intValue()));
                }

                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, Integer.valueOf(port).intValue()));
            }
        }

        c.close();

        return null;
    }

    public static Cursor getCurrentApn(Context context) {
        return context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
    }

    public static boolean validateIp(String aIp) {
        String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(aIp);
        return matcher.matches();
    }

}
