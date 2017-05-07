package com.dxballtest.dipanjal.dxball_test;


import android.graphics.Canvas;

public class GameThread extends Thread {
	Boolean running;
	Game game;
	GameObject ball;
	public GameThread(Game game) {
		this.game=game;
	}
	
	public void setRunning(Boolean run) {
		
		running=run;
	}
	Canvas c= new  Canvas();
	//@SuppressLint("WrongCall")
	
	@Override
	public void run() {
	
		
		while(running){

		   // Log.d("Thread", "Running  "+running);
		    
			try {
				
				sleep(500);
			}
			catch (InterruptedException e)
			{
				e.getMessage();
			}
		
			try
			{
				//game.onDraw(c);
				game.draw(c); //This is onDraw Method
			}
			catch (Exception e)
			{
				e.getMessage();
			}
			finally {
				c=null;
			}
		    	
			
			
		}
	}
	
}
