package com.fivetrue.location;

import android.location.Location;
import android.os.Bundle;

public interface LocationCallback {
	public void onLocationStatusOutOfService(String provider, int status, Bundle extras);
	public void onLocationStatusAvaliable(String provider, int status, Bundle extras);
	public void onLocationStatusTemporarilyUnavailable(String provider, int status, Bundle extras);
	public void onLocationChanged(Location location);
	
	public void onEnable(String provider);
	public void onDisable(String provider);
	
	public void onGpsStarted();
	public void onGpsFirstFix();
	public void onGpsStopped();
	public void onGpsSatelliteStatus();
}
