package com.example.androidgame;

import android.content.Context;
import android.util.Log;

public class EnemySimple extends Enemy {

	private int direction;
	
	public EnemySimple(Context c) {
		super(c);
		this.direction = (int) (System.nanoTime() % 4);
		UpdaterAsyncTask.alwaysUpdate.add(this);
	}

	public EnemySimple(Context c, int x, int y) {
		super(c, x, y);
		this.direction = (int) (System.nanoTime() % 4);
		UpdaterAsyncTask.alwaysUpdate.add(this);
		Log.d("demo", ":" + direction);
	}

	@Override
	public void Update(){
		int xMovement = 0;
		int yMovement = 0;
		
		switch (direction) {
		case 0:
			xMovement = 1;
			break;
		case 1:
			xMovement = -1;
			break;
		case 2:
			yMovement = 1;
			break;
		case 3:
			yMovement = -1;
			break;
		default:
			break;
		}
		this.translateX(xMovement);
		this.translateY(yMovement);
		QueueOccasionalUpdate();
	}

	@Override
	public void OccasionalUpdate() {
		setX(x);
		setY(y);
		occasionalUpdate = false;
	}

	@Override
	public void QueueOccasionalUpdate() {
		if(!occasionalUpdate){
			occasionalUpdate = true;
			UpdaterAsyncTask.toUpdate.add(this);
		}
	}
}
