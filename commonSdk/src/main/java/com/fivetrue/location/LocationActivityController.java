package com.fivetrue.location;

import android.app.Activity;

public class LocationActivityController {
	
	private Activity activity;
	private LocationCallback locationCallback;

	public LocationActivityController(Activity activity, LocationCallback ll){
		this.activity = activity;
		this.locationCallback = ll;
	}

	public Activity getActivity() {
		return activity;
	}

	public LocationCallback getLocationCallback() {
		return locationCallback;
	}
}
