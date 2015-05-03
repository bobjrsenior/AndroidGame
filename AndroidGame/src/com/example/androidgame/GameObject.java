package com.example.androidgame;

import android.content.Context;
import android.widget.ImageView;

public class GameObject extends ImageView{

	private boolean update;
	private float x;
	private float y;
	
	public GameObject(Context c) {
		super(c);
		this.x = 0;
		this.y = 0;
		setX(0);
		setY(0);
		update = false;
		setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));

	}
	
	public GameObject(Context c, int x, int y) {
		super(c);
		this.x = x;
		this.y = y;
		super.setX(x);
		super.setY(y);
		update = false;
		setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
	}
	
	public void translateX(float distance){
		x += distance;
//		QueueUpdate();
	}
	
	public void translateY(float distance){
		y += distance;
		QueueUpdate();
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
		QueueUpdate();
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
		QueueUpdate();
	}
	
	public void QueueUpdate(){
		if(!update){
			update = true;
			UpdaterAsyncTask.toUpdate.add(this);
		}
		
	}
	
	public void Update(){
		super.setX(x);
		super.setY(y);
		update = false;
	}

}
