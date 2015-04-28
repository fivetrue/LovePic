package com.fivetrue.lovepic.ui;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.fivetrue.lovepic.R;
import com.fivetrue.lovepic.fragment.CubePictureFragment;
import com.fivetrue.lovepic.fragment.adapter.MyFragmentPagerAdapter;
import com.fivetrue.lovepic.helper.FacebookApiHelper;
import com.fivetrue.lovepic.util.JsonConvertUtil;
import com.fivetrue.lovepic.view.FragmentViewPager;
import com.fivetrue.lovepic.vo.AlbumVO;
import com.fivetrue.lovepic.vo.MeVO;
import com.fivetrue.lovepic.vo.PictureVO;
import com.fivetrue.network.VolleyInstance;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import org.json.JSONArray;
import org.json.JSONException;


public class MainActivity extends FragmentActivity implements SensorEventListener{

	private static final int VIEW_PAGER_ID = 0x41641101;
	private Sensor mGyroSensor = null;
	private Sensor mGravitySensor = null;
	
	private SensorManager mSensorManger = null;
	
	private ViewPager mViewPager = null;
	private MyFragmentPagerAdapter mPagerAdapter = null;
	private List<Fragment> mFragmentList = null;
//    private String[] mArrPictrueList = {
//            "https://fbcdn-sphotos-b-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10438535_843404729066340_5360271156053621426_n.jpg?oh=6614573454346073dc811ae7f4e37670&oe=55D53498&__gda__=1435992388_a9e802af21594867a457772140848ba1",
//            "https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-xpf1/v/t1.0-9/11156353_843404752399671_4893221420894961746_n.jpg?oh=dd550c78fadcc990e4fd98c35ef60d78&oe=55E1B294&__gda__=1440519422_da0e76d8724c082b258a04f2a08ae38d",
//            "https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpf1/v/t1.0-9/11167685_843404789066334_9177399484545299858_n.jpg?oh=8a358d4d490dde94b2389c0d7bad7f12&oe=55E14A5E&__gda__=1439663668_1730f45029cfd99c64fac0a3c31ab08f",
//            "https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xpa1/v/t1.0-9/11048744_801324109962637_9033386711858261846_n.jpg?oh=56b012235875d72e24580973a12a06c3&oe=55D27950&__gda__=1439864040_c96c7d15f2d82007210a7b2b329e7703",
//            "https://fbcdn-sphotos-b-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/1377446_800699020025146_5456065570359729057_n.jpg?oh=a1cb48e543777ad913a1b6adaadfe564&oe=55CD57BB&__gda__=1440358898_6277f3e12db7b18cba0a7a035043c9f9",
//            "https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xaf1/v/t1.0-9/10942491_800055946756120_4449300794286669957_n.jpg?oh=2455a9e62570cfcdcdab6adba8a9f155&oe=559CEE38&__gda__=1440938633_db7f486d0f980496327bfec04f1d4f4f"
//    };
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VolleyInstance.init(this);
        mSensorManger = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mGyroSensor = mSensorManger.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mGravitySensor = mSensorManger.getDefaultSensor(Sensor.TYPE_GRAVITY);
        loadFacebookPictrues();
//        initLayout();
    }

    private void loadFacebookPictrues(){
        FacebookApiHelper.getInstance().getMe(new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                if(response != null && response.getJSONObject() != null){
                    MeVO me = new MeVO(JsonConvertUtil.getFacebookDataFromJsonObject(response.getJSONObject()));

                    FacebookApiHelper.getInstance().getAlbums(new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            if(response != null && response.getJSONObject() != null) {
                                ArrayList<AlbumVO> arrAlbum = new ArrayList<AlbumVO>();
                                JSONArray jAlbums = JsonConvertUtil.getFacebookDataFromJsonArray(response.getJSONObject());
                                for (int i = 0; i < jAlbums.length(); i++) {
                                    try {
                                        arrAlbum.add(new AlbumVO(jAlbums.getJSONObject(i)));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                FacebookApiHelper.getInstance().getPhotosOfAlbum(arrAlbum.get(0).getId(), new GraphRequest.Callback() {
                                    @Override
                                    public void onCompleted(GraphResponse response) {
                                        if (response != null && response.getJSONObject() != null) {
                                            Log.e("ojkwon", response.getJSONObject().toString());
                                            setImageResponse(JsonConvertUtil.getFacebookDataFromJsonArray(response.getJSONObject()));
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    private void setImageResponse(JSONArray json){
        Log.e("ojkwon" , json.toString());
        ArrayList<PictureVO> arrPicture = new ArrayList<>();
        if(json != null && json.length() > 0){
            for(int i = 0 ; i < json.length() ; i ++){
                try {
                    if(json.getJSONObject(i) != null){
                        arrPicture.add(new PictureVO(json.getJSONObject(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        initLayout(arrPicture);
    }
    private void initLayout(ArrayList<PictureVO> pictures){
    	setContentView(R.layout.activity_main);
    	mViewPager = new FragmentViewPager(this);
    	mViewPager.setId(VIEW_PAGER_ID);
    	mFragmentList = new ArrayList<Fragment>();
    	final CubePictureFragment f = new CubePictureFragment();
        final CubePictureFragment f1 = new CubePictureFragment();
    	final Bitmap[] bitmap = new Bitmap[f.getCube().getNumOfFace()];
        Log.e("ojkwon", pictures.toString());
    	for(int i = 0 ; i < f.getCube().getNumOfFace(); i++){
    		
    		final int index = i;
    		VolleyInstance.getImageLoader().get(pictures.get(i).getSource(), new ImageLoader.ImageListener() {
				
				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
					// TODO Auto-generated method stub
					if(response != null && response.getBitmap() != null && !response.getBitmap().isRecycled()){
						bitmap[index] = response.getBitmap();
						if(index == f.getCube().getNumOfFace() - 1){
							f.setCubePictrues(bitmap);
                            f1.setCubePictrues(bitmap);
							mFragmentList.add(f);
                            mFragmentList.add(f1);
							mPagerAdapter.notifyDataSetChanged();
						}
					}
				}
			});
    	}
    	mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
    	mViewPager.setAdapter(mPagerAdapter);
    	((ViewGroup)findViewById(R.id.layout_anchor)).addView(mViewPager, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    	
    	
    }

    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	if(mSensorManger != null){
    		if(mGyroSensor != null){
    			mSensorManger.registerListener(this, mGyroSensor, SensorManager.SENSOR_DELAY_GAME);
    		}
    		if(mGravitySensor != null){
    			mSensorManger.registerListener(this, mGravitySensor, SensorManager.SENSOR_DELAY_GAME);
    		}
    	}
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	if(mSensorManger != null){
    		mSensorManger.unregisterListener(this);
    	}
    }
    

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized (this) {
			if(mFragmentList != null && mFragmentList.size() > 0){
				for(Fragment f : mFragmentList){
					if(f instanceof CubePictureFragment){
						((CubePictureFragment)f).onSensorChanged(event);
					}
				}
			}
		}
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	boolean isTouch = false;
	
	float x = 0;
	float y = 0;
	private final int DRAG = 0x01;
	private final int ZOOM = 0x02;
	private final int NONE = 0x03;
	private int MODE = NONE;
	float oldDist = 0;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event != null ){//&& mOpenGlRenderer != null){
			
			
			switch(event.getAction() & MotionEvent.ACTION_MASK){
			case MotionEvent.ACTION_DOWN :
//				isTouch = true;
//				x = event.getX();
//				y = event.getY();
				MODE = DRAG;
				break;
				
			case MotionEvent.ACTION_POINTER_DOWN :
			
				oldDist = spacing(event);
				if(oldDist > 10f){
					MODE = ZOOM;
				}
				break;
				
			case MotionEvent.ACTION_MOVE:
				
				if(MODE == DRAG){
					
				}else if(MODE == ZOOM){
					float newDist = spacing(event);
					if(newDist > 10f){
						System.out.println("ojkwon : newDist = " + newDist);
						System.out.println("ojkwon : oldDist = " + oldDist);
//						for(Fragment f : mFragmentList){
//							if(f instanceof CubePictureFragment){
//								((CubePictureFragment)f).pinchEvent((newDist - oldDist) * 0.01f);
//							}
//						}
					}
				}
				break;
			case MotionEvent.ACTION_UP :
			case MotionEvent.ACTION_POINTER_UP :
			case MotionEvent.ACTION_CANCEL:
				MODE = NONE;
				isTouch = false;
				break;
			}
		}
		return false;
	}
	
	private float spacing(MotionEvent event){
		if(event != null){
			float x = event.getX(0) - event.getX(1);
			float y = event.getY(0) - event.getY(1);
			return FloatMath.sqrt(x*x + y*y);
		}
		return 0;
	}
	
	private synchronized void setCubeBitmap(Bitmap bitmap){
		
	}
}
