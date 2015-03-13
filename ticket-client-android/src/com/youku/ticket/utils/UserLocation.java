package com.youku.ticket.utils;

import java.util.List;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class UserLocation {

    private final String TAG = "UserLocation";

    private static UserLocation instance = null;

    private static MyLocationManager mLocationManager = null;

    private static double latitude = 0.0;

    private static double longitude = 0.0;

    private boolean isGPSEnable = false;

    private boolean isNetWorkEnable = false;

    private Context mContext = null;

    public static UserLocation getInstance() {
        if (instance == null) {
            synchronized (UserLocation.class) {
                if (instance == null) {
                    instance = new UserLocation();
                }
            }
        }
        return instance;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //	public synchronized void initManager(Context context){
    //		if (mLocationManager == null && context != null){
    //			mLocationManager = new MyLocationManager(context, null);
    //		}
    //	}
    //	
    //	public synchronized void deinitManager(){
    //		mLocationManager = null;
    //	}
    //	
    //	public synchronized void recordLocation(boolean b) {
    //		// TODO Auto-generated method stub
    //		if(mLocationManager != null){
    //			mLocationManager.recordLocation(b);
    //		}
    //	}
    //	
    //	public synchronized void updateLocationInformation() {			
    //		if (mLocationManager != null) {
    //			Location location = mLocationManager.getCurrentLocation();
    //			if (location != null) {
    //				latitude = location.getLatitude();
    //				longitude = location.getLongitude();
    //			}
    //		}
    //	}
    //	public void updateLocationInformation(Context context) {
    //		LocationManager manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);//获取手机位置信息
    //        
    //        List<String> providers = manager.getAllProviders();
    //        
    //        for (String provider : providers) {
    //            Log.w(TAG, provider);
    //        }
    //        
    //       //获取的条件
    //        Criteria criteria = new Criteria();
    //        criteria.setAccuracy(Criteria.ACCURACY_FINE);//获取精准位置
    //        criteria.setCostAllowed(true);//允许产生开销
    //        criteria.setPowerRequirement(Criteria.POWER_HIGH);//消耗大的话，获取的频率高
    //        criteria.setSpeedRequired(true);//手机位置移动
    //        criteria.setAltitudeRequired(true);//海拔
    //        
    //        //获取最佳provider: 手机或者模拟器上均为gps
    //        String bestProvider = manager.getBestProvider(criteria, true);//使用GPS卫星
    //        
    //        Log.w(TAG,"最好的位置提供者是"+bestProvider);
    //        
    //        //parameter: 1. provider 2. 每隔多少时间获取一次  3.每隔多少米  4.监听器触发回调函数
    //        manager.requestLocationUpdates(bestProvider,60000,100, new MyLocationListener());
    //	}
    //	
    private class MyLocationListener implements LocationListener {

        /**
         * 手机位置发生变动
         */
        public void onLocationChanged(Location location) {
            location.getAccuracy();//精确度
            latitude = location.getLatitude();//经度
            longitude = location.getLongitude();//纬度
        }

        /**
         * 当某个位置提供者的状态发生改变时
         */
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        /**
         * 某个设备打开时
         */
        public void onProviderEnabled(String provider) {

        }

        /**
         * 某个设备关闭时
         */
        public void onProviderDisabled(String provider) {

        }

    }

    private MyLocationListener mListener = new MyLocationListener();

    public void updateLocationInformation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Log.w(TAG, "NETWORK_PROVIDER is Enable");
            isNetWorkEnable = true;
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, mListener);
        } else {
            isNetWorkEnable = false;
        }

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Log.w(TAG, "GPS_PROVIDER is Enable");
            isGPSEnable = true;
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 100, mListener);
        } else {
            isGPSEnable = false;
        }

        if (!isGPSEnable && !isNetWorkEnable) {
            Log.e(TAG, "All location PROVIDER is disable");
        }
    }
}
