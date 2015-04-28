package com.api.common;

import org.json.JSONObject;

public interface BaseResponseConverter <T>{
	public T onReceive(JSONObject json);
}
