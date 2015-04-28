package com.fivetrue.location.activity;

import com.fivetrue.ILocationService;
import com.fivetrue.location.LocationCallback;
import com.fivetrue.location.service.LocationService;
import com.fivetrue.network.VolleyInstance;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

abstract public class LocationActivity extends FragmentActivity implements LocationCallback{

	
	private ILocationService mLocationService = null;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		bindLocationService();
		addLocatioActivityToService();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unbindLocationService();
		removeLocationActivityFromService();
	}

	protected void addLocatioActivityToService(){
		LocationService.addLocationActivity(this, this);
	}
	
	protected void removeLocationActivityFromService(){
		LocationService.removeLocationActivity(this);
	}
	
	
	public ILocationService getLocationService() {
		return mLocationService;
	}

	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mLocationService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mLocationService = ILocationService.Stub.asInterface(service);
		}
	};
	
	
	public void bindLocationService(){
		if(mLocationService == null){
			bindService(new Intent(getApplicationContext(), LocationService.class), mConnection, BIND_AUTO_CREATE);
		}
	}
	
	public void unbindLocationService(){
		if(mLocationService != null){
			unbindService(mConnection);
		}
	}
	
	public Location getCurrentLocation(){
		try {
			return mLocationService.getCurrentLocation();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void onStartLocationService(){
		try {
			mLocationService.onStart();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onPauseLocationService(){
		try {
			mLocationService.onPause();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected boolean isLocationServiceRunning(){
		try {
			return mLocationService.isRunning();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	protected boolean isGpsEnable(){
		try {
			return mLocationService.isGpsEnable();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 위치 서비스를 받지 못하는 상태에 해당 메서드를 호출
	 * @param provider
	 * @param status
	 * @param extras
	 */
	abstract protected void outOfService(String provider, int status, Bundle extras);
	
	/**
	 * 위치 서비스를 받을 수 있는 상태에서 해당 메서드를 호출
	 * @param provider
	 * @param status
	 * @param extras
	 */
	abstract protected void avaliableService(String provider, int status, Bundle extras);
	
	/**
	 * 일시적으로 위치 서비스가 불가능 상태가 되었을 떄 호출됨
	 * @param provider
	 * @param status
	 * @param extras
	 */
	abstract protected void temporarilyServiceUnavailable(String provider, int status, Bundle extras);
	
	/**
	 * 현재 위치가 변경되었을 떄 호출됨
	 * @param location
	 */
	abstract protected void changeLocation(Location location);
	
	/**
	 * 위치 서비스가 활성화 되었을 떄 호출됨
	 * @param provider
	 */
	protected void onLocationServiceEnable(String provider){
		Log.e(getPackageName(), "LocationService Enable = " + provider);
	}
	
	/**
	 * 위치 서비스가 비활성화 되었을 떄 호출됨
	 * @param provider
	 */
	protected void onLocationServiceDisable(String provider){
		Log.e(getPackageName(), "LocationService Disable = " + provider);
	}
	
	/**
	 * GPS가 시작될 떄 호출
	 */
	protected void onGpsServiceStarted(){
		Log.e(getPackageName(), "onGpsServiceStarted");
	}
	
	/**
	 * GPS가 처음 위치를 잡았을 떄 호출
	 */
	protected void onGpsServiceFirstFix(){
		Log.e(getPackageName(), "onGpsServiceFirstFix");
	}
	
	/**
	 * GPS가 정지되었을 떄 호출
	 */
	protected void onGpsServiceStop(){
		Log.e(getPackageName(), "onGpsServiceStop");
	}
	
	/**
	 * GPS 위성 상태가 변경되었을 떄 호출
	 */
	protected void onGpsServiceSatelliteStatus(){
		Log.e(getPackageName(), "onGpsServiceSatelliteStatus");
	}

	@Override
	public void onLocationStatusOutOfService(String provider, int status,
			Bundle extras) {
		// TODO Auto-generated method stub
		outOfService(provider, status, extras);
	}

	@Override
	public void onLocationStatusAvaliable(String provider, int status,
			Bundle extras) {
		// TODO Auto-generated method stub
		avaliableService(provider, status, extras);
	}

	@Override
	public void onLocationStatusTemporarilyUnavailable(String provider,
			int status, Bundle extras) {
		// TODO Auto-generated method stub
		temporarilyServiceUnavailable(provider, status, extras);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		changeLocation(location);
	}

	@Override
	public void onEnable(String provider) {
		// TODO Auto-generated method stub
		onLocationServiceEnable(provider);
	}

	@Override
	public void onDisable(String provider) {
		// TODO Auto-generated method stub
		onLocationServiceDisable(provider);
	}

	@Override
	public void onGpsStarted() {
		// TODO Auto-generated method stub
		onGpsServiceStarted();
	}

	@Override
	public void onGpsFirstFix() {
		// TODO Auto-generated method stub
		onGpsServiceFirstFix();
	}

	@Override
	public void onGpsStopped() {
		// TODO Auto-generated method stub
		onGpsServiceStop();
	}

	@Override
	public void onGpsSatelliteStatus() {
		// TODO Auto-generated method stub
		onGpsServiceSatelliteStatus();
	}
}
