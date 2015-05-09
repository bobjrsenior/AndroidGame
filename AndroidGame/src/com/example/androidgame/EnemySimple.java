package com.example.androidgame;

import android.content.Context;
import android.util.Log;

public class EnemySimple extends Enemy {

	private int direction;
	
	public EnemySimple(Context c) {
		super(c);
		this.direction = (int) (System.nanoTime() % 4);
	}

	public EnemySimple(Context c, int x, int y) {
		super(c, x, y);
		this.direction = (int) (System.nanoTime() % 4);
		Log.d("demo", ":" + direction);
	}

	@Override
	public void Update(){
		int xMovement = 10;
		int yMovement = 0;
		
		switch (direction) {
		case 0:
			xMovement = 10;
			break;
		case 1:
			xMovement = -10;
			break;
		case 2:
			yMovement = 10;
			break;
		case 3:
			yMovement = -10;
			break;
		default:
			break;
		}
		this.translateX(xMovement);
		this.translateY(yMovement);
		super.Update();
	}
}
