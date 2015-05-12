package com.example.androidgame;

import java.util.ArrayList;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public class EnemySpawner {

	public static ArrayList<GameObjectInterface> objectPool = new ArrayList<GameObjectInterface>();
	
	private Context context;
	
	public EnemySpawner(Context c, int objectPoolCount){
		context = c;
		expandPool(objectPoolCount);
	}
	
	public EnemySpawner(Context c){
		context = c;
		expandPool(10);
	}
	
	public void Update(){
		//Test spawn code
		if(objectPool.size() > 5){
			EnemySimple temp = (EnemySimple) pop();
			temp.setDrawable();
			temp.setXPos(150);
			temp.setYPos(150);
			temp.setLayoutParams(new LayoutParams(50, 50));
			temp.setUp();
			UpdaterAsyncTask.addView(temp);
		}
	}
	
	public void expandPool(int count){
		for(int e = 0; e < count; e ++){
			Enemy temp = new EnemySimple(context, -100, -100, true);
			objectPool.add(temp);
		}
	}
	
	public GameObjectInterface pop(){
		return objectPool.remove(0);
	}
	
	public void add(GameObjectInterface obj){
		objectPool.add(obj);
	}
	
}
