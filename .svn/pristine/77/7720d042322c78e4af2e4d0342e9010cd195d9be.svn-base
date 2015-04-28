package com.fivetrue.location;

import java.util.List;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

@SuppressLint("NewApi")
public class LocationControlManager{
	
	private final String LOCATION_MANAGER_NULL_ERR = "Location Manager is null";
	private final String LOCATION_DATA_NULL_ERR = "Location DATA is null";
	private final String TAG = getClass().getName();

	private final long MIN_TIME = 500;
	private final float MIN_DISTANCE = 1;
	private final int NUM_OF_ADDRESS = 1;

	private Context mContext = null;
	private LocationManager mLocationManager = null;
	private LocationCallback mLocationStatusListener = null;
	private String mProvider = null;

	private Location mLocationData = null;
	
	private boolean isRunning = false;
	
	static private LocationControlManager mLocationControlManager = null;


	static public LocationControlManager getInstance(Context context){
		if(mLocationControlManager != null){
			return mLocationControlManager;
		}else{
			mLocationControlManager = new LocationControlManager(context);
			return mLocationControlManager;
		}
	}

	private LocationControlManager(Context context){
		mContext = context;
		mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

		Criteria c = new Criteria();
		mProvider = mLocationManager.getBestProvider(c, true);

		if(mProvider == null || !mLocationManager.isProviderEnabled(mProvider)){
			List<String> list = mLocationManager.getAllProviders();

			for(int i = 0 ; i < list.size() ; i++){
				String temp = list.get(i);

				if(mLocationManager.isProviderEnabled(temp)){
					mProvider = temp;
				}
			}
		}
//		requestLocationUpdate();
	}

	@SuppressLint("NewApi")
	public static boolean isMockLocationSet(Context context) { 
		if (Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ALLOW_MOCK_LOCATION).contentEquals("1")) { 
			return true;  
		} 
		else { 
			return false;                     
		} 
	} 
	public void stop(){
		if(mLocationManager != null){
			mLocationManager.removeUpdates(mLocationListener);
			mLocationManager.removeGpsStatusListener(mGpsStatusListener);
			isRunning = false;
		}
	}
	
	public void start(){
		requestLocationUpdate();
	}
	
	public Location getLastLocation(){
		if(mLocationManager != null){
			mLocationData = mLocationManager.getLastKnownLocation(mProvider);
			if(mLocationManager == null){
				Log.e(TAG, LOCATION_DATA_NULL_ERR);
			}
		}else{
			Log.e(TAG, LOCATION_MANAGER_NULL_ERR);
		}
		return mLocationData;
	}

	public Location getCurrenLocationData(){
		
//		requestLocationUpdate();
//		if(mLocationData != null){
//			return mLocationData;
//		}else{
//			Log.e(TAG, LOCATION_DATA_NULL_ERR);
//			mLocationData = mLocationManager.getLastKnownLocation(mProvider);
//			return mLocationData;
//		}
		return mLocationData;
	}
	
	public void requestLocationUpdate(){
		if(mLocationManager != null && mProvider != null){
			if(mLocationListener != null){
				mLocationManager.requestLocationUpdates(mProvider, MIN_TIME, MIN_DISTANCE, mLocationListener);
				isRunning = true;
			}
			if(mGpsStatusListener != null){
				mLocationManager.addGpsStatusListener(mGpsStatusListener);
			}
		}
	}
	
	/**
	 * @return the mLocationControlListener
	 */
	public LocationCallback getLocationStatusListener() {
		return mLocationStatusListener;
	}

	/**
	 * @param mLocationStatusListener the mLocationControlListener to set
	 */
	public void setLocationStatusListener(
			LocationCallback locationControlListener) {
		this.mLocationStatusListener = locationControlListener;
	}

	public String getAddress(){
		return getAddress(mLocationData);
	}
	
	public String getAddress(Location location){

		String address = null;
		
		if(location == null)
			return address;

		Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());

		List<Address> list = null;

		try{
			list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), NUM_OF_ADDRESS);
		}catch(Exception e){
			e.printStackTrace();
		}

		if(list.size() > 0){
			Address addr = list.get(0);
			StringBuilder stb = new StringBuilder();
			stb.append(addr.getCountryName()).append(" ")
			.append(addr.getPostalCode()).append(" ")
			.append(addr.getLocality()).append(" ")
			.append(addr.getThoroughfare()).append(" ")
			.append(addr.getFeatureName()).append(" ");
			address = stb.toString();
		}
		return address;
	}
	
	/**
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}
	
	public boolean isGpsEnable(){
		if(mLocationManager != null && mProvider != null){
			return mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		}
		return false;
	}

	private GpsStatus.Listener mGpsStatusListener = new Listener() {
		
		@Override
		public void onGpsStatusChanged(int event) {
			// TODO Auto-generated method stub
			switch (event) {
            case GpsStatus.GPS_EVENT_STARTED:
            	if(mLocationStatusListener != null){
            		mLocationStatusListener.onGpsStarted();
            	}
                break;
            case GpsStatus.GPS_EVENT_FIRST_FIX:
            	if(mLocationStatusListener != null){
            		mLocationStatusListener.onGpsFirstFix();
            	}
                break;
            case GpsStatus.GPS_EVENT_STOPPED:
            	if(mLocationStatusListener != null){
            		mLocationStatusListener.onGpsStopped();
            	}
                break;
            case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
            	if(mLocationStatusListener != null){
            		mLocationStatusListener.onGpsSatelliteStatus();
            	}
                break;
            default:
                break;
        }
		}
	};
	
	private LocationListener mLocationListener = new LocationListener(){

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			mLocationData = location;
			if(mLocationStatusListener != null){
				mLocationStatusListener.onLocationChanged(location);
			}
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			if(mLocationStatusListener != null){
				switch (status) {
				case LocationProvider.OUT_OF_SERVICE:
					mLocationStatusListener.onLocationStatusOutOfService(provider, status, extras);
					break;
				case LocationProvider.TEMPORARILY_UNAVAILABLE:
					mLocationStatusListener.onLocationStatusTemporarilyUnavailable(provider, status, extras);
					break;
				case LocationProvider.AVAILABLE:
					mLocationStatusListener.onLocationStatusAvaliable(provider, status, extras);
					break;
				}
			}
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			if(mLocationStatusListener != null){
				mLocationStatusListener.onEnable(provider);
			}
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			if(mLocationStatusListener != null){
				mLocationStatusListener.onDisable(provider);
			}
		}
		
	};
}
