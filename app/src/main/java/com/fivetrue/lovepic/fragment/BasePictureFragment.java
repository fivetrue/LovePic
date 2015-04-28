package com.fivetrue.lovepic.fragment;

import com.fivetrue.lovepic.opengl.OpenGLRenderer;
import com.fivetrue.lovepic.opengl.polygon.Mesh;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract public class BasePictureFragment extends Fragment implements SensorEventListener{
	
	protected OpenGLRenderer mOpenGlRenderer = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mOpenGlRenderer = new OpenGLRenderer(getActivity());
		mOpenGlRenderer.setMesh(getMesh());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		GLSurfaceView view = new GLSurfaceView(getActivity());
		view.setRenderer(mOpenGlRenderer);
		return view;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	public OpenGLRenderer getOpenGLRenderer(){
		return mOpenGlRenderer;
	}
	
	public abstract Mesh getMesh();

}
