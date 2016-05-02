
//Author Shahrukh Zindani
//10/03/2016

package com.example.shahrukhzindani.ponggame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import com.example.shahrukhzindani.ponggame.Ball.Ball;

import java.util.Random;


public class MainActivity extends Activity {
    Ball ball;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball = (Ball)findViewById(R.id.ball);
        seekbar= (SeekBar) findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SpeedListener());


    }
    //Additional method that changes color randomly
    public void changeColor(View v){

        int x=1;
        Random r = new Random();
        int rcolor = r.nextInt(5 - 0) + 0;
        int color[] = new int[5];
        color[0]= -65536;
        color[1]= -256;
        color[2]= -16777216 ;
        color[3]= -16711936 ;
        color[4]= -3355444  ;


        ball.paint.setColor(color[rcolor]);


    }

    class SpeedListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if(ball.xspeed<0 || ball.yspeed<0){
                ball.xspeed=i-5;
                ball.yspeed=i-5;
            }
            ball.xspeed=5+i;
            ball.yspeed=5+i;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    public void isPaused(View v){
        ball.stopped=true;
    }
    public void isOn(View v){
        ball.stopped=false;
    }


    //methods that make the color change using the radio buttons
    public void makeYellow(View view){
        ball.paint.setColor(-256);
    }
    public void makeGrey(View view){
        ball.paint.setColor(-3355444  );
    }
    public void makeRed(View view){
        ball.paint.setColor(-65536);
    }
    public void makeBlack(View view){
        ball.paint.setColor(-16777216);
    }



}
