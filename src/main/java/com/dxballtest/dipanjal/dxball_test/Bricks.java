package com.dxballtest.dipanjal.dxball_test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

public class Bricks extends GameObject {

	Paint paint= new Paint();
	int height,width;
	int life;
	int x1,y1;
	Boolean first=true;
	public Bricks(int x, int y) {
		super(x, y);
	}

	public Bricks(int x, int x1, int y, int y1, int life)
	{
		super(x,y);
		this.life=life; //Double hit or single hit destroyer
		this.x1=x1;
		this.y1=y1;
	}
	
	
	@Override
	public void onDraw(Canvas canvas) {
		
			if(life==1){
				paint.setColor(Color.DKGRAY);
			}
			else if(life==2)
			{

				paint.setColor(Color.BLACK);
			}
			else if(life==3)
			{
				paint.setColor(Color.RED);
			}

			
			paint.setStyle(Style.FILL);

			Rect r= new Rect(x+2,y+2, x1,y1); //HOLDS CODRINATES FOR A RECTANGLE
			canvas.drawRect(r, paint); //DRAWING THE RECTANGLE
	}
}
