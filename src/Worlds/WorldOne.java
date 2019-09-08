package Worlds;

import Game.Entities.Static.Apple;
import Game.Entities.Static.DoubleUp;
import Game.Entities.Static.SlowDown;
import Main.Handler;

import java.awt.*;
import java.util.Random;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class WorldOne extends WorldBase{

    public WorldOne (Handler handler) {
        super(handler);

        //has to be a number bigger than 20 and even
        GridWidthHeightPixelCount = 60;
        GridPixelsize = (800/GridWidthHeightPixelCount);
        playerLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
        appleLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
        doubleUpLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
        slowDownLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
    }

    @Override
    public void tick() {
        super.tick();
        player.tick();
        if(!appleOnBoard){
            appleOnBoard=true;
            int appleX = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);
            int appley = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);

            //change coordinates till one is selected in which the player isn't standing
            boolean goodCoordinates=false;
            do{
                if(!handler.getWorld().playerLocation[appleX][appley]){
                    goodCoordinates=true;
                }
            }while(!goodCoordinates);

            apple = new Apple(handler,appleX,appley,true);
            appleLocation[appleX][appley]=true;

        }
        
        if(!doubleUpOnBoard){
        	doubleUpOnBoard=true;
            int doubleUpX = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);
            int doubleUpeY = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);

            //change coordinates till one is selected in which the player isn't standing
            boolean niceCoordinates=false;
            do{
                if(!handler.getWorld().playerLocation[doubleUpX][doubleUpeY]){
                    niceCoordinates=true;
                }
            }while(!niceCoordinates);

            doubleUp = new DoubleUp(handler,doubleUpX,doubleUpeY);
            doubleUpLocation[doubleUpX][doubleUpeY]=true;
    }
        if(!slowDownOnBoard){
        	slowDownOnBoard=true;
            int slowDownX = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);
            int slowDowneY = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);

            //change coordinates till one is selected in which the player isn't standing
            boolean fineCoordinates=false;
            do{
                if(!handler.getWorld().playerLocation[slowDownX][slowDowneY]){
                    fineCoordinates=true;
                }
            }while(!fineCoordinates);

            slowDown = new SlowDown(handler,slowDownX,slowDowneY);
            slowDownLocation[slowDownX][slowDowneY]=true;
        }
    }
   
    
    @Override
    public void render(Graphics g){
        super.render(g);
        player.render(g,playerLocation);
        g.drawString("Score  "+this.player.currScore, 5, 15);
    }

}
