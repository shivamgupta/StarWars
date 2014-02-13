package com.example.cs241_honors_project_starwars;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class SWGame extends Activity {
	final SWEngine gameEngine = new SWEngine();
	private SWGameView gameView;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new SWGameView(this);
        setContentView(gameView);
    }
    @Override
    protected void onResume() {
       super.onResume();
       gameView.onResume();
    }

    @Override
    protected void onPause() {
       super.onPause();
       gameView.onPause();
    }

   	@SuppressWarnings("deprecation")
	@Override
   	public boolean onTouchEvent(MotionEvent event) {
   		//
   		float x = event.getX();
        float y = event.getY();
        @SuppressWarnings("deprecation")
		int height = SWEngine.display.getHeight() / 4;
        @SuppressWarnings("deprecation")
		int playableArea = SWEngine.display.getHeight() - height;
        if (y > playableArea){
        	switch (event.getAction()){
        	case MotionEvent.ACTION_DOWN:
        		if(x < SWEngine.display.getWidth() / 2){
        			SWEngine.playerFlightAction = SWEngine.PLAYER_BANK_LEFT_1;
        		}else{
        			SWEngine.playerFlightAction = SWEngine.PLAYER_BANK_RIGHT_1;
        		}
        		break;
        	case MotionEvent.ACTION_UP:
        		SWEngine.playerFlightAction = SWEngine.PLAYER_RELEASE;
        		break;
        	}
        	
        }

		return false;
    }
	
}

