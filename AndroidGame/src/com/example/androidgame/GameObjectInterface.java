package com.example.androidgame;

public interface GameObjectInterface {
	public void translateX(float distance);
	
	public void translateY(float distance);

	public float getX();

	public void setX(float x);

	public float getY();

	public void setY(float y);
	
	public void damage(int damage);
	
	public int getHealth();

	public void setHealth(int health);
	
	public void Update();
	
	public void QueueOccasionalUpdate();
	
	public void OccasionalUpdate();
}
