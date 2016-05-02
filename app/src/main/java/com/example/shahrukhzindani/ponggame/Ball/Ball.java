package com.example.shahrukhzindani.ponggame.Ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shahrukhzindani on 3/10/16.
 * 
 */
public class Ball extends View {

   public Paint paint;
    int xDir=1;
    int yDir=1;
    float radius;
    float x;
    float y;

    public float xspeed= 20;
   public float yspeed=20;

   public boolean stopped=true;




   public Ball(Context context, AttributeSet attrs){
       super(context,attrs);
       paint = new Paint();
       paint.setStyle(Paint.Style.FILL);
       paint.setColor(Color.BLUE);

   }
    @Override
    protected void onDraw(Canvas canvas){
        radius=(float)(getWidth()/10);


        if(stopped){
            x = (float) (getWidth() / 2);
            y = (float) (getHeight() / 2);

        }
        canvas.drawCircle(x,y,radius,paint);

        x+=xspeed;
        y+=yspeed;
        if(x<radius){
            xspeed=1*Math.abs(xspeed);
        }

        if (x>getWidth()-radius){
            xspeed=-1*Math.abs(xspeed);
        }

        if(y<radius){
            yspeed=Math.abs(yspeed);
        }
        if(y>getHeight()-25){
            yspeed=Math.abs(yspeed)*-1;
        }




        invalidate();
    }
}
