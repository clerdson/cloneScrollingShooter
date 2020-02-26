package com.example.scrollingshooter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable {

    private Thread mThread = null;
    private long mFPS;

    public GameEngine(Context context, Point size) {
        super(context);
    }

    public void run() {
        long frameStartTime = System.currentTimeMillis();
        // Update all game object here
        // in a new way
        //draw all the game objects here
        //in a new way

        //measure the frames per second in the usual way
        long timeThisFrame = System.currentTimeMillis() - frameStartTime;
        if (timeThisFrame >= 1) {
            final int MILLIS_IN_SECOND = 1000;
            mFPS = MILLIS_IN_SECOND / timeThisFrame;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        //Handle the Player 'input here
        // But in a new way
        return true;
    }
    public void stopThread(){
        //new code here soon
        try{
            mThread.join();
        }catch (InterruptedException e){
            Log.e("Exception","stopThread()"+e.getMessage());
        }
    }

    public void startThread(){
        //new code here soon

        mThread = new Thread(this);
        mThread.start();
    }
}
