package com.example.scrollingshooter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable, GameStarter {

    private Thread mThread = null;
    private long mFPS;

    private GameState mGameState;
    private SoundEngine mSoundEngine;
    HUD mHUD;
    Renderer mRenderer;

    public GameEngine(Context context, Point size) {
        super(context);
        mGameState = new GameState(this, context);
        mSoundEngine = new SoundEngine(context);
        mHUD  = new HUD(size);
        mRenderer = new Renderer(this);
    }

    public void deSpawnReSpawn() {
        //Eventually this will despawn
        //and the respawn all the game objects
    }

    public void run() {
        while(mGameState.getThreadRunning()){
           long frameStartTime = System.currentTimeMillis();
           if(!mGameState.getPaused()){
               //Updade all the game objects here
               // /in a new way
           }
           //Draw al the game objects there
            //int a new way
            mRenderer.draw(mGameState,mHUD);
           //Measure the frames per second on the usual way
           long timeThisFrame = System.currentTimeMillis()-frameStartTime;
           if(timeThisFrame>=1){
               final int MILLIS_IN_SECOND =1000;
               mFPS = MILLIS_IN_SECOND/timeThisFrame;         }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        //Handle the Player 'input here
        // But in a new way
        mSoundEngine.playShoot();
        return true;
    }

    public void stopThread() {
        //new code here soon
        mGameState.stopEverything();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception", "stopThread()" + e.getMessage());
        }
    }

    public void startThread() {
        //new code here soon
        mGameState.startThread();
        mThread = new Thread(this);
        mThread.start();
    }

}
