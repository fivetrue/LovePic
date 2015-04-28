package com.fivetrue.lovepic.fragment;

import com.fivetrue.lovepic.opengl.polygon.Cube;
import com.fivetrue.lovepic.opengl.polygon.Mesh;

import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class CubePictureFragment extends BasePictureFragment{
	private Cube mCube = null;
	
	public CubePictureFragment(){
		mCube = new Cube();
		mCube.status.rx = 1.0f;
		mCube.status.ry = 1.0f;
		mCube.status.rz = 1.0f;
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event != null){
			if(event.sensor.getType() == Sensor.TYPE_GRAVITY){
				if(mOpenGlRenderer != null && mOpenGlRenderer.meshState != null){
					
//					mOpenGlRenderer.meshState.x = -event.values[0];
//					mOpenGlRenderer.meshState.y = -event.values[1];

					if(Math.abs(Math.abs(mOpenGlRenderer.meshState.ry) - Math.abs(event.values[0])) > 0.1f){
						mOpenGlRenderer.meshState.ry = (event.values[0] * -180) / 4;
					}
					if(Math.abs(Math.abs(mOpenGlRenderer.meshState.rx) - Math.abs(event.values[1])) > 0.1f){
						mOpenGlRenderer.meshState.rx = (-event.values[1] * 180) / 4;
					}
				}
			}
		} 
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mesh getMesh() {
		// TODO Auto-generated method stub
		return mCube;
	}
	
	public void setCubePictrues(Bitmap[] bitmaps){
		mCube.setTextureBitmaps(bitmaps);
	}
	
	public Cube getCube(){
		return mCube;
	}
	
	public synchronized void setCubePictrue(Bitmap bm){
		int idx = mCube.getTextureBitmaps().length;
		mCube.getTextureBitmaps()[idx] = bm;
	}
}
