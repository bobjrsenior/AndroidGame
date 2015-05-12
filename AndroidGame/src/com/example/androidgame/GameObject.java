package com.example.androidgame;

import android.content.Context;
import android.widget.ImageView;

public abstract class GameObject extends GameObjectAbstract implements GameObjectInterface{

	
	public GameObject(Context c) {
		super(c);
		resetPosition(0, 0);
		setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));

	}
	
	
	public GameObject(Context c, int x, int y, boolean activated) {
		super(c);
		resetPosition(x, y);
	}
	
	public GameObject(Context c, int x, int y) {
		super(c);
		resetPosition(x, y);
		setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
	}
	
	private void resetPosition(int x, int y){
		this.x = x;
		this.y = y;
		setX(x);
		setY(y);
		occasionalUpdate = false;
	}
	
	public void translateX(float distance){
		x += distance;
		QueueOccasionalUpdate();
	}
	
	public void translateY(float distance){
		y += distance;
		QueueOccasionalUpdate();
	}

	public float getXPos() {
		return x;
	}

	public void setXPos(float x) {
		this.x = x;
		QueueOccasionalUpdate();
	}

	public float getYPos() {
		return y;
	}

	public void setYPos(float y) {
		this.y = y;
		QueueOccasionalUpdate();
	}
	
	public void damage(int damage){
		health -= damage;
	}	
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
