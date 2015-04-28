package com.fivetrue.utils;

import android.view.View;

public class ColorUtil {
	
	/**
	 * @param view change view background
	 * @param arrColorFrom rgb value in int array
	 * @param arrColorTo rgb value in int array
	 * @param value change value
	 */
	static public void changeColor(final View view, final long[] arrColorFrom, final long[] arrColorTo, final float value){
		if(view == null || arrColorFrom == null || arrColorTo == null
				|| arrColorFrom.length <= 0 || arrColorTo.length <= 0 )
			return;

		int color[] = new int[arrColorFrom.length];
		for(int i = 0 ; i < arrColorFrom.length ; i ++){

			if(arrColorFrom[i] > arrColorTo[i]){
				float val = arrColorFrom[i] - value;

				if(arrColorTo[i] <= val){
					color[i] = (int)val;
				}
			}else if(arrColorFrom[i] < arrColorTo[i]){
				float val = arrColorFrom[i] + value;

				if(arrColorTo[i] >= val){
					color[i] = (int)val;
				}
			}

		}
		String backround = new String();
		backround += Integer.toHexString(0xFF);
		for(int i = 0 ; i < color.length ; i++){
			long val = color[i];
			long to = 0x10;
			if(val > 0x0F && val <= 0xFF){
				to = val;
			}else {
				to = arrColorTo[i];
			}
			backround += Long.toHexString(to > 0x0F ? to : 0x10);
		}
		long setColor = Long.valueOf(backround, 16);

		view.setBackgroundColor((int)setColor);
	}
	
	/**
	 * @param arrColorFrom
	 * @param arrColorTo
	 * @param value
	 * @return changed color value in long 
	 */
	static public int changeColor(final long[] arrColorFrom, final long[] arrColorTo, final float value){
		if(arrColorFrom == null || arrColorTo == null
				|| arrColorFrom.length <= 0 || arrColorTo.length <= 0 )
			return 0xFFFFFFFF;

		int color[] = new int[arrColorFrom.length];
		for(int i = 0 ; i < arrColorFrom.length ; i ++){

			if(arrColorFrom[i] > arrColorTo[i]){
				float val = arrColorFrom[i] - value;

				if(arrColorTo[i] <= val){
					color[i] = (int)val;
				}
			}else if(arrColorFrom[i] < arrColorTo[i]){
				float val = arrColorFrom[i] + value;

				if(arrColorTo[i] >= val){
					color[i] = (int)val;
				}
			}

		}
		String backround = new String();
		backround += Integer.toHexString(0xFF);
		for(int i = 0 ; i < color.length ; i++){
			long val = color[i];
			long to = 0x10;
			if(val > 0x0F && val <= 0xFF){
				to = val;
			}else {
				to = arrColorTo[i];
			}
			backround += Long.toHexString(to > 0x0F ? to : 0x10);
		}
		long setColor = Long.valueOf(backround, 16);
		
		return (int)setColor;
	}
}
