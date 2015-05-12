package com.example.androidgame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public abstract class GameObjectAbstract extends ImageView{
	public GameObjectAbstract(Context context) {
		super(context);
	}
	public boolean occasionalUpdate;
	public float x;
	public float y;
	public int health;
	public int activated;

	public void setX(int x){
		super.setX(x);
	}
	
	public void setY(int y){
		super.setY(y);
	}
	
	public void setDrawable(){
		setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
	}
	
	public void setDrawable(Drawable drawable){
		setImageDrawable(drawable);
	}
}
