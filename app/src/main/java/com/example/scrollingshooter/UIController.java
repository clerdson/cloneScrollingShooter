package com.example.scrollingshooter;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public class UIController implements InputObserver {

    public UIController(GameEngineBroadcaster b) {
        b.addObserver(this);
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, ArrayList<Rect> buttons) {
        int i = event.getActionIndex();
        int x = (int)event.getX(i);
        int y = (int)event.getY(i);

        int eventType = event.getAction()& MotionEvent.ACTION_MASK;
        if(eventType == MotionEvent.ACTION_UP||eventType == MotionEvent.ACTION_POINTER_UP){
            if(buttons.get(HUD.PAUSE).contains(x,y)){
                //player press the pause button
                //Responde diferently depending
                //upon the game state

                //if the game is not paused
                if(!gameState.getPaused()){
                    //Pause the Game
                    gameState.pause();
                }
                //If game is over start a new Game
                else if (gameState.getGameOver()){
                    gameState.startNewGame();
                }
                //Paused and not game over
                else if (gameState.getPaused()&& !gameState.getGameOver()){
                    gameState.resume();
                }
            }
        }
    }
}
