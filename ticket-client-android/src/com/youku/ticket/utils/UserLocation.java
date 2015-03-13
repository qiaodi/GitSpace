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
    //		LocationManager manager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);//��ȡ�ֻ�λ����Ϣ
    //        
    //        List<String> providers = manager.getAllProviders();
    //        
    //        for (String provider : providers) {
    //            Log.w(TAG, provider);
    //        }
    //        
    //       //��ȡ������
    //        Criteria criteria = new Criteria();
    //        criteria.setAccuracy(Criteria.ACCURACY_FINE);//��ȡ��׼λ��
    //        criteria.setCostAllowed(true);//�����������
    //        criteria.setPowerRequirement(Criteria.POWER_HIGH);//���Ĵ�Ļ�����ȡ��Ƶ�ʸ�
    //        criteria.setSpeedRequired(true);//�ֻ�λ���ƶ�
    //        criteria.setAltitudeRequired(true);//����
    //        
    //        //��ȡ���provider: �ֻ�����ģ�����Ͼ�Ϊgps
    //        String bestProvider = manager.getBestProvider(criteria, true);//ʹ��GPS����
    //        
    //        Log.w(TAG,"��õ�λ���ṩ����"+bestProvider);
    //        
    //        //parameter: 1. provider 2. ÿ������ʱ���ȡһ��  3.ÿ��������  4.�����������ص�����
    //        manager.requestLocationUpdates(bestProvider,60000,100, new MyLocationListener());
    //	}
    //	
    private class MyLocationListener implements LocationListener {

        /**
         * �ֻ�λ�÷����䶯
         */
        public void onLocationChanged(Location location) {
            location.getAccuracy();//��ȷ��
            latitude = location.getLatitude();//����
            longitude = location.getLongitude();//γ��
        }

        /**
         * ��ĳ��λ���ṩ�ߵ�״̬�����ı�ʱ
         */
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        /**
         * ĳ���豸��ʱ
         */
        public void onProviderEnabled(String provider) {

        }

        /**
         * ĳ���豸�ر�ʱ
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
