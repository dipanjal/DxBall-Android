package com.dxballtest.dipanjal.dxball_test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

public class Bar extends GameObject {

	int x1,y1;
	Boolean first=true;
	Paint paint =new Paint();
	int height , width;
	public Bar(int x, int y) {
		super(x, y);
	}
	public Bar(int x,int y,int x1,int y1){
		super(x, y);
		this.x1=x1;
		this.y1=y1;
	}



	@Override
	public void onDraw(Canvas canvas) {
		if(first){
			height=canvas.getHeight();
			width= canvas.getWidth();
			x=(width/4); //A
			x1=3*(width/6)+30; //B
			y=height-50; //C
			y1=height-25; //D
			first=false;
		}
		//Log.d("test", ""+x );
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
		Rect r = new Rect(x, y, x1, y1);
		canvas.drawRect(r, paint);
		
	}
	
	
}
