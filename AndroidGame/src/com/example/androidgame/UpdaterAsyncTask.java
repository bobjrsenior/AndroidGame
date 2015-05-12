package com.example.androidgame;

import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Space;

public class UpdaterAsyncTask extends AsyncTask<Void, Void, Void>{

	public static ArrayList<GameObjectInterface> toUpdate = new ArrayList<GameObjectInterface>();
	public static ArrayList<GameObjectInterface> alwaysUpdate = new ArrayList<GameObjectInterface>();
	private EnemySpawner spawner;
	
	public float minFrameTime = .04f;
	
	public boolean quit = false;
	
	public GameObject testObject;
	public EnemySimple testEnemy;
	public Context context;
	public static GridLayout rv;
	private boolean cont = true;
	
	public UpdaterAsyncTask(Context context, GridLayout rv) {
		spawner = new EnemySpawner(context, 10);
		
		//Player
		testObject = new Player(context, 50, 50);
		testObject.setLayoutParams(new LayoutParams(50, 50));
		UpdaterAsyncTask.rv = rv;
		rv.addView(testObject);
		
		//Enemy
		testEnemy = new EnemySimple(context, 90, 90);
		testEnemy.setLayoutParams(new LayoutParams(50, 50));
		UpdaterAsyncTask.rv = rv;
		rv.addView(testEnemy);
	}
	
	public static void addView(View view){
		rv.addView(view);
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
			for(GameObjectInterface obj : alwaysUpdate){
				obj.Update();
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
		spawner.Update();
		while(toUpdate.size() > 0){
			toUpdate.get(0).OccasionalUpdate();
			toUpdate.remove(0);			
		}
		
		cont = true;
		super.onProgressUpdate(values);
	}
	
	

}
