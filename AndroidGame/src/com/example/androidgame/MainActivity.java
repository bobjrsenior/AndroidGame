package com.example.androidgame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;


public class MainActivity extends Activity {

	ExecutorService threadpool;
	UpdaterAsyncTask async;
	
	public static float xPos;
	public static float yPos;
	public static boolean touching = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = new TextView(this);
        tv.setText("test");
        GridLayout rv = (GridLayout) findViewById(R.id.mainLayout);
        //rv.addView(tv);
        TouchEvents activitySwipeDetector = new TouchEvents();
        rv.setOnTouchListener(activitySwipeDetector);
        threadpool = Executors.newFixedThreadPool(4);
        
        async = new UpdaterAsyncTask(this, rv);
        async.execute();
    }
    
    
    

    @Override
	public boolean onTouchEvent(MotionEvent event) {
    	 xPos = (int) event.getRawX();
         yPos = (int) event.getRawY();
         touching = true;
         int eventaction = event.getAction();
         switch (eventaction) {

         case MotionEvent.ACTION_DOWN:
             touching = true;
             break;
         case MotionEvent.ACTION_UP:
             touching = false;
             break;
         }
         return true;
		//return super.onTouchEvent(event);
	}




	@Override
	protected void onDestroy() {
    	threadpool.shutdownNow();
    	async.quit = true;
    	super.onDestroy();
	}




	@Override
	public void onBackPressed() {
    	threadpool.shutdownNow();
    	async.quit = true;
		super.onBackPressed();
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
