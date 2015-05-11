package com.example.androidgame;

import android.content.Context;

public abstract class Enemy extends GameObject{
	
	public Enemy(Context c) {
		super(c);
	}

	public Enemy(Context c, int x, int y) {
		super(c, x , y);
	}

}
