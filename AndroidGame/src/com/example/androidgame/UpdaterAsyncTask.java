package com.example.androidgame;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Space;

public class UpdaterAsyncTask extends AsyncTask<Void, Void, Void>{

	public static ArrayList<GameObject> toUpdate = new ArrayList<GameObject>();
	public static ArrayList<GameObject> objectPool = new ArrayList<GameObject>();
	
	public float minFrameTime = .04f;
	
	public boolean quit = false;
	
	public GameObject testObject;
	public EnemySimple testEnemy;
	public Context context;
	public GridLayout rv;
	private boolean cont = true;
	
	public UpdaterAsyncTask(Context context, GridLayout rv) {
		//Player
		testObject = new GameObject(context, 30, 30);
		testObject.setLayoutParams(new LayoutParams(50, 50));
		this.rv = rv;
		rv.addView(testObject);
		
		//Enemy
		testEnemy = new EnemySimple(context, 90, 90);
		testEnemy.setLayoutParams(new LayoutParams(50, 50));
		this.rv = rv;
		rv.addView(testEnemy);
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
