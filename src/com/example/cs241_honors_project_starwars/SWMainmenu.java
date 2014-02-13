package com.example.cs241_honors_project_starwars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class SWMainmenu extends Activity {
    /** Called when the activity is first created. */
	final SWEngine engine = new SWEngine();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SWEngine.context = getApplicationContext();
       
        
        /** Fire up background music */
       SWEngine.musicThread = new Thread(){
        	public void run(){
        		Intent bgmusic = new Intent(getApplicationContext(), SWMusic.class);
        		startService(bgmusic);
  
        	}
        };
        SWEngine.musicThread.start();
        

        
        /** Set menu button options */
        ImageButton start = (ImageButton)findViewById(R.id.btnStart);
        ImageButton exit = (ImageButton)findViewById(R.id.btnExit);
        
        start.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				/** Start Game!!!! */
				Intent game = new Intent(getApplicationContext(),SWGame.class);
				SWMainmenu.this.startActivity(game);

			}
        	
        });
        
        exit.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v) {
				boolean clean = false;
				clean = engine.onExit(v);	
				if (clean)
				{
					int pid= android.os.Process.myPid();
					android.os.Process.killProcess(pid);
				}
			}
        	});
    }
}
