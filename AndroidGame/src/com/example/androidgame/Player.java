package com.example.androidgame;

import android.content.Context;
import android.util.Log;

public class Player extends GameObject{

	public Player(Context c, int x, int y) {
		super(c, x, y);
	}

	@Override
	public void Update() {
				
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

	@Override
	public void setUp() {
		
	}

}
