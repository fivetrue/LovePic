package com.api.common;

import org.json.JSONObject;

public interface IRequestResult {

	public void onSuccessRequest(String url, JSONObject request);
	
	public void onFailRequest(String url);
}
