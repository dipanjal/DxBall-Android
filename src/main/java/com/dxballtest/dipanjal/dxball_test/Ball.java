package com.dxballtest.dipanjal.dxball_test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Ball extends GameObject {

	int  speedX=5,speedY=5;
	int h,w;
	Boolean first=true;
	public Ball(int x, int y) {
		super(x, y);
	}

	public Ball(int x,int y,int speed){
		super(x,y);
		speedX=speed;
		speedY=speed;
	}
	Paint paint= new Paint();
	
	@Override
	public void onDraw(Canvas canvas) {
		if(first)
		{
			h=canvas.getHeight();
			w=canvas.getWidth();
			first=false;
		}
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(x, y, 30, paint);
	}
	
	public void update(){
		x+=speedX;
		y+=speedY;
		if(x<30)
		{
			speedX=5; //Goes Right
		}
		if(x>w-30) //When the ball Touch the top
		{
			speedX=-5; //Goes Left
		}
		if(y>h-30) //If the ball touches the ground
		{
			speedY=5;
			Game.life--;
			x=w/2;
			y=h/2;
		}
		
		if(y<30) //When the ball Touch the top
		{
			//Log.d("Ball","Coming Back");
			speedY=5;
		}
	}
}
