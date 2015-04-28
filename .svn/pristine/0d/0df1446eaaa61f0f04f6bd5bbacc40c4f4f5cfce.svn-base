package com.fivetrue.lovepic.opengl.polygon;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

abstract public class Mesh {
	
	public Mesh() {
		// TODO Auto-generated constructor stub
	}
	
	protected static final int INVALID_VALUE = -1;
	
	public static class MeshStatus{
		public float x = 0;
		public float y = 0;
		public float z = 0;

		public float rx = 0;
		public float ry = 0;
		public float rz = 0;
	}

	public MeshStatus status = new MeshStatus();
	
	public abstract void draw(GL10 gl);
	
	public abstract int getNumOfFace();
	
	public abstract float[] getVertexArray();
	
	public abstract float[] getColorArray();
	
	public abstract void loadTexture(GL10 gl, Context context);
	
}
