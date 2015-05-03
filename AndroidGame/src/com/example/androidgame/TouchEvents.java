package com.example.androidgame;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchEvents implements View.OnTouchListener {

	public static float xPos;
	public static float yPos;
	public static boolean touched;
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		touched = true;
		xPos = event.getX();
		yPos = event.getY();
		Log.d("demo", "X: " + xPos + " Y: " + yPos);
		return false;
	}
	
	

}
