package com.example.androidgame;

import android.content.Context;

public class Enemy extends GameObject{
	
	public Enemy(Context c) {
		super(c);
	}

	public Enemy(Context c, int x, int y) {
		super(c, x , y);
	}
	
	@Override
	public void Update(){
		super.Update();
		QueueUpdate();
	}

}
