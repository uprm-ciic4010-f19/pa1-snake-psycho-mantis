package Worlds;

import Game.Entities.Dynamic.Player;


import Game.Entities.Dynamic.Tail;
import Game.Entities.Static.Apple;
import Game.Entities.Static.DoubleUp;
import Game.Entities.Static.SlowDown;

import Main.Handler;

import java.awt.*;
import java.util.LinkedList;


/**
 * Created by AlexVR on 7/2/2018.
 */
public abstract class WorldBase {

    //How many pixels are from left to right
    //How many pixels are from top to bottom
    //Must be equal
    public int GridWidthHeightPixelCount;

    //automatically calculated, depends on previous input.
    //The size of each box, the size of each box will be GridPixelsize x GridPixelsize.
    public int GridPixelsize;

    public Player player;

    protected Handler handler;


    public Boolean appleOnBoard;
    public Boolean doubleUpOnBoard;
    public Boolean slowDownOnBoard;
    public Apple apple;
    public DoubleUp doubleUp;
    public SlowDown slowDown;
    public Boolean[][] appleLocation;
    public Boolean[][] doubleUpLocation;
    public Boolean[][] slowDownLocation;
    
    public Boolean[][] playerLocation;

    public LinkedList<Tail> body = new LinkedList<>();


    public WorldBase(Handler handler){
        this.handler = handler;

        appleOnBoard = false;
        doubleUpOnBoard = false;
        slowDownOnBoard = false;
    }
    public void tick(){



    }

    public void render(Graphics g){

        for (int i = 0; i <= 800; i = i + GridPixelsize) {
        	Color DarkPurple= new Color(66,28,82);

            g.setColor(DarkPurple);
            g.drawLine(0, i, handler.getWidth() , i);
            g.drawLine(i,0,i,handler.getHeight());
            

        }



    }

}
