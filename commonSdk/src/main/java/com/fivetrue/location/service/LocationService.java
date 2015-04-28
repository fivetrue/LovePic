package com.fivetrue.location.service;

import java.util.ArrayList;

import com.fivetrue.ILocationService;
import com.fivetrue.location.LocationControlManager;
import com.fivetrue.location.LocationActivityController;
import com.fivetrue.location.LocationCallback;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class LocationService extends Service {

	static private ArrayList<LocationActivityController> LocationController = new ArrayList<LocationActivityController>();

	public static void addLocationActivity(Activity activity, LocationCallback callback){
		if(LocationController != null){
			boolean hasAlready = false;
			for(LocationActivityController controller : LocationController){
				hasAlready = controller.getActivity().equals(activity);
				hasAlready = controller.getLocationCallback().equals(callback);
			}

			if(!hasAlready){
				LocationController.add(new LocationActivityController(activity, callback));
			}
		}
	}

	public static void removeLocationActivity(Activity runningActivity) {

		if(LocationController != null && LocationController.size() > 0){
			for(int i = 0 ; i < LocationController.size() ; i ++){
				LocationActivityController controller = LocationController.get(i);
				if(controller.getActivity().equals(runningActivity)){
					LocationController.remove(i);
					return;
				}
			}
		}
	}

	private LocationControlManager mLocationControlManager = null;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		initServiceModel();
		Log.e(getPackageName(), "onCreate Location Service");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mLocationControlManager.stop();
		Log.e(getPackageName(), "onDestroy Location Service");
	}

	private void initServiceModel(){
		mLocationControlManager = LocationControlManager.getInstance(getApplicationContext());
		mLocationControlManager.setLocationStatusListener(mLocationStatusCallback);
	}

	ILocationService.Stub mBinder = new ILocationService.Stub() {

		@Override
		public boolean onStart() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Location Service Start");
				mLocationControlManager.start();
				return true;
			}
			return false;
		}

		@Override
		public boolean onPause() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Location Service Stop");
				mLocationControlManager.stop();
				return true;
			}
			return false;
		}

		@Override
		public Location getLastLocation() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Location Service getLastLocation");
				return mLocationControlManager.getLastLocation();
			}
			return null;
		}

		@Override
		public Location getCurrentLocation() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Location Service getCurrentLocation");
				return mLocationControlManager.getCurrenLocationData();
			}
			return null;
		}

		@Override
		public boolean isRunning() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Location Service isRunning");
				return mLocationControlManager.isRunning();
			}
			return false;
		}

		@Override
		public boolean isGpsEnable() throws RemoteException {
			// TODO Auto-generated method stub
			if(mLocationControlManager != null){
				Log.e(getPackageName(), "Gps Enable");
				return mLocationControlManager.isGpsEnable();
			}
			return false;
		}
	};

	private LocationCallback mLocationStatusCallback = new LocationCallback() {

		@Override
		public void onLocationStatusTemporarilyUnavailable(String provider,
				int status, Bundle extras) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onLocationStatusTemporarilyUnavailable(provider, status, extras);
				}
			}
		}

		@Override
		public void onLocationStatusOutOfService(String provider, int status,
				Bundle extras) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onLocationStatusOutOfService(provider, status, extras);
				}
			}
		}

		@Override
		public void onLocationStatusAvaliable(String provider, int status,
				Bundle extras) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onLocationStatusAvaliable(provider, status, extras);
				}
			}
		}

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onLocationChanged(location);
				}
			}
		}

		@Override
		public void onGpsStopped() {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onGpsStopped();
				}
			}
		}

		@Override
		public void onGpsStarted() {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onGpsStarted();
				}
			}
		}

		@Override
		public void onGpsSatelliteStatus() {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onGpsSatelliteStatus();
				}
			}
		}

		@Override
		public void onGpsFirstFix() {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onGpsFirstFix();
				}
			}
		}

		@Override
		public void onEnable(String provider) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onEnable(provider);
				}
			}
		}

		@Override
		public void onDisable(String provider) {
			// TODO Auto-generated method stub
			for(LocationActivityController info : LocationController){
				if(info.getLocationCallback() != null){
					info.getLocationCallback().onDisable(provider);
				}
			}
		}
	};
}
