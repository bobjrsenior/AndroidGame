package com.example.androidgame;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RelativeLayout;

public class UpdaterAsyncTask extends AsyncTask<Void, Void, Void>{

	public static ArrayList<GameObject> toUpdate = new ArrayList<GameObject>();
	public float minFrameTime = .04f;
	
	public boolean quit = false;
	
	public GameObject testObject;
	public Context context;
	public RelativeLayout rv;
	private boolean cont = true;
	
	public UpdaterAsyncTask(Context context, RelativeLayout rv) {
		testObject = new GameObject(context, 30, 30);
		this.rv = rv;
		rv.addView(testObject);
	}

	@Override
	protected Void doInBackground(Void... params) {
		while(!quit){
			
			//Log.d("demo", "Loop");
			long startTime = System.currentTimeMillis();
			
			if(MainActivity.touching){
				if(testObject.getX() < MainActivity.xPos){
					testObject.translateX(1f);
				}
				else if(testObject.getX() > MainActivity.xPos){
					testObject.translateX(-1f);
				}
				if(testObject.getY() < MainActivity.yPos){
					testObject.translateY(1f);
				}
				else if(testObject.getY() > MainActivity.yPos){
					testObject.translateY(-1f);
				}
				//MainActivity.touching = false;
			}
			cont = false;
			publishProgress();
			
			while(!cont){
				
			}
			if(!quit && System.currentTimeMillis() < startTime + minFrameTime){
				try {
					Thread.sleep((long) (minFrameTime - (System.currentTimeMillis() - startTime)));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		return null;
		
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		//for(GameObject obj : toUpdate){
		//	obj.Update();
		//}
		//toUpdate.clear();
		while(toUpdate.size() > 0){
			toUpdate.get(0).Update();
			toUpdate.remove(0);			
		}
		cont = true;
		super.onProgressUpdate(values);
	}
	
	

}
