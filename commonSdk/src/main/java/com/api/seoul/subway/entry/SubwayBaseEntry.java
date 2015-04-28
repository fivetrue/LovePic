package com.api.seoul.subway.entry;


import android.content.Context;

import com.android.common.R;
import com.api.common.BaseEntry;

public abstract class SubwayBaseEntry extends BaseEntry {

	public String getLineCodeToName(Context context, String code){
		String name = null;
		if(context != null && code != null){
			String[] arrCode = context.getResources().getStringArray(R.array.subway_line_code);
			String[] arrName = context.getResources().getStringArray(R.array.subway_line_info);
			if(arrName != null && arrCode != null){
				for(int i = 0 ; i < arrCode.length ; i ++){
					if(arrCode[i].equals(code)){
						name = arrName[i];
						break;
					}
				}
			}
		}
		return name;
	}
}
