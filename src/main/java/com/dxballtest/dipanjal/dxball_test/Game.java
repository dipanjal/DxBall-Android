package com.dxballtest.dipanjal.dxball_test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Game extends View {

	static int  Score=0,life=3;
	Paint paint= new Paint();
	Boolean first=true,onTouch=false;
	int speed=15,barX,width,height;
	int level=0;
	Context context;
	GameThread gameThread =new GameThread(this);
	Ball b;
	Bar ba;
	GameObject ball=new Ball(0, 0);
	GameObject bar= new Bar(1,2);

	boolean isMenuActivity=false;

	ArrayList<GameObject> gameObjectsList = new ArrayList<GameObject>();

	public Game(Context context) {

		super(context);
		this.context=context;
		gameObjectsList.add(ball);//ADDDING BALL TO ARRAYLIST
		gameObjectsList.add(bar); //ADDLING BAR TO ARRAYLIST
		gameThread.setRunning(true);
		gameThread.start(); //STARTING THE THREAD

	}


	public void stage2() {

		/*LEVEL 2 BRICKS*/



		int brickX=(width/5);
		int brickY=(height/10);

		gameObjectsList.add(new Bricks(brickX, brickX*2, brickY, brickY*2, 1));
		gameObjectsList.add(new Bricks(0, brickX, brickY*2, brickY*3, 1)); //X,X1,Y,Y1,Brick Life
		gameObjectsList.add(new Bricks(brickX, brickX*2, brickY*2, brickY*3, 2));
		gameObjectsList.add(new Bricks(brickX*2, brickX*3, brickY*2, brickY*3, 1));
		gameObjectsList.add(new Bricks(brickX, brickX*2, brickY*3, brickY*4, 1));

		gameObjectsList.add(new Bricks(brickX*4, brickX*5, brickY, brickY*2, 1)); //X,X1,Y,Y1,Brick Life
		gameObjectsList.add(new Bricks(brickX*3, brickX*4, brickY*2, brickY*3, 1));
		gameObjectsList.add(new Bricks(brickX*4, brickX*5, brickY*2, brickY*3, 3));
		//gameObjectsList.add(new Bricks(brickX*5, brickX*6, brickY*2, brickY*3, 1));
		gameObjectsList.add(new Bricks(brickX*4, brickX*5, brickY*3, brickY*4, 1));
		//gameObjectsList.add(new Bricks((width/5),(width/5)*2,height/10,(height/10)*2,1));
		//gameObjectsList.add(new Bricks((width/5),(width/5)*2,(height/10)*2,(height/10)*3,2));

		//gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,height/10,(height/10)*2,1));
		//gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,(height/10)*2,(height/10)*3,2));


		//gameObjectsList.add(new Bricks((width/5)*3,(width/5)*4 ,(height/10)*3,(height/10)*4,2));
		//gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,(he
		// ight/10)*3,(height/10)*4,2));

		b=(Ball)gameObjectsList.get(0);
		ba= (Bar)gameObjectsList.get(1);
		level++;
		onTouch=true;
	}

	public void stage1(){

		/*LEVEL 1 BRICKS*/
//
		gameObjectsList.add(new Bricks(0,(width)/5,height/10,(height/10)*2,1));
		gameObjectsList.add(new Bricks((width/5),(width/5)*2,height/10,(height/10)*2,1));
		gameObjectsList.add(new Bricks((width/5)*2,(width/5)*3 ,height/10,(height/10)*2,2));
		gameObjectsList.add(new Bricks((width/5)*3,(width/5)*4 ,height/10,(height/10)*2,1));
		gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,height/10,(height/10)*2,1));


		gameObjectsList.add(new Bricks(0,(width)/5,(height/10)*2,(height/10)*3,1));
		gameObjectsList.add(new Bricks((width/5),(width/5)*2,(height/10)*2,(height/10)*3,2));
		gameObjectsList.add(new Bricks((width/5)*2,(width/5)*3 ,(height/10)*2,(height/10)*3,3));
		gameObjectsList.add(new Bricks((width/5)*3,(width/5)*4 ,(height/10)*2,(height/10)*3,2));
		gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,(height/10)*2,(height/10)*3,1));

		gameObjectsList.add(new Bricks(0,(width)/5,(height/10)*3,(height/10)*4,1));
		gameObjectsList.add(new Bricks((width/5),(width/5)*2,(height/10)*3,(height/10)*4,1));
		gameObjectsList.add(new Bricks((width/5)*2,(width/5)*3 ,(height/10)*3,(height/10)*4,2));
		gameObjectsList.add(new Bricks((width/5)*3,(width/5)*4 ,(height/10)*3,(height/10)*4,1));
		gameObjectsList.add(new Bricks((width/5)*4,(width/5)*5-1 ,(height/10)*3,(height/10)*4,1));

		/*gameObjectsList.add(new Bricks((width/5)*2+1 , (width/5)*3 ,height/10,(height/10)*2,1));
		gameObjectsList.add(new Bricks((width/5)*3+1 , (width/5)*4 ,height/10,(height/10)*2,1));
		gameObjectsList.add(new Bricks((width/5)*4+1 , (width/5)*5 ,(height/10)*4+1,(height/10)*5,1));
		gameObjectsList.add(new Bricks((width/5)*3+1 , (width/5)*4 ,(height/10)*4+1,(height/10)*5,1));

		gameObjectsList.add(new Bricks(0,width/5 ,(height/10)*2+1,(height/10)*3,2));
		gameObjectsList.add(new Bricks(0,width/5 ,(height/10)*3+1,(height/10)*4,1));
		gameObjectsList.add(new Bricks(0,width/5 ,(height/10)*4+1,(height/10)*5,1));
		gameObjectsList.add(new Bricks((width/5)*3+1 , (width/5)*4 ,(height/10)*2+1,(height/10)*3,2));
		gameObjectsList.add(new Bricks((width/5)*4+1 , (width/5)*5 ,(height/10)*2+1,(height/10)*3,2));*/

		b=(Ball)gameObjectsList.get(0);
		ba= (Bar)gameObjectsList.get(1);
		onTouch=true;
		level++;

	}



	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		if(onTouch){

			if (event.getAction()==event.ACTION_MOVE)
			{
				if(event.getX() <= width/2-100)
				{
					if(ba.x<=10 )
					{

						speed=0;
					}
					else
					{
						speed=-20;
					}
				}
				else if(event.getX() >= width/2+100)
				{
					if(ba.x1>=width-10){
						speed=0;
					}
					else
					{
						speed=20;
					}

				}
				else
				{
					speed=0;
				}

				//MOVING BAR
				ba.x+=speed;
				ba.x1+=speed;

			}
		}
		return true;
	}


	Collision collision= new Collision();
	@Override
	protected void onDraw(Canvas canvas) {

		if(first)
		{
			canvas.drawRGB(0,0,0);
			//canvas.drawColor(Color.WHITE);
			width=canvas.getWidth();
			height=canvas.getHeight();
			Log.d("Screen",String.valueOf(width)+" X "+String.valueOf(height));
			stage2(); //LOAD STAGE 1

			/*INITIAL POSITION OF THE BALL*/

			ball.x=(width/2)-100;
			ball.y=height-80;
			first=false;

		}
		else
		{
			if(gameObjectsList.size()>2)
			{
				if(life!=0)
				{
					paint.setColor(Color.BLUE);
					paint.setTextSize(40);
					canvas.drawText("Score: "+String.valueOf(Score), width-180, 35, paint);
					paint.setColor(Color.RED);
					canvas.drawText("Life: "+String.valueOf(life), 20, 35, paint);
					for(int i=0;i<gameObjectsList.size();i++)
					{
						gameObjectsList.get(i).onDraw(canvas); //DRAW GAME OBJECTS

					}

					b.update(); //UPDATE BALL POSITION

					this.collision.setCanvas(canvas);
					collision.ballWithBar(gameObjectsList); //COLLISSION DETECTION BALL WITH BAR
					collision.ballWithBrick(gameObjectsList); //COLLISSION DETECTION BALL AND BRICK

				}
				else
				{
					paint.setColor(Color.RED);
					paint.setTextSize(80);
					canvas.drawText("GAME OVER", width/2-200, height/2, paint);

					try {
						gameThread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if(!this.isMenuActivity)
					{
						Intent i=new Intent(context,MenuActivity.class);
						((MainActivity)context).startActivity(i);
						this.isMenuActivity=true;
					}

				}


			}
			else
			{
				try
				{
					gameThread.setRunning(false);
					gameThread.sleep(500);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gameThread.setRunning(true);
				if(level<2)
				{
					stage2();

					ball.x=width/2;
					ball.y=90;
				}else{
					paint.setColor(Color.RED);
					paint.setTextSize(80);
					canvas.drawText("Congratulation!", (width/4)-100, height/2, paint);
				}
			}
		}

		//paint.setStyle(Paint.Style.FILL);
		invalidate();


	}
}

