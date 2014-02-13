package com.example.cs241_honors_project_starwars;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class SWGameView extends GLSurfaceView {
	private SWGameRenderer renderer;
	
	public SWGameView(Context context) {
		super(context);
		
		renderer = new SWGameRenderer();
		
		this.setRenderer(renderer);
	}
}
