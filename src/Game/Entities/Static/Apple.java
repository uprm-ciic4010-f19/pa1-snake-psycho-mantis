package Game.Entities.Static;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord;
    public boolean good;
    
    public Apple(Handler handler,int x, int y,Boolean good){
        this.handler=handler;
        this.xCoord=x;
        this.yCoord=y;
        this.good=good;
        
    }

    public void isGood() {
    	
    	if (!good) {
    		
    		handler.getWorld().player.lenght--;
    		handler.getWorld().player.currScore = handler.getWorld().player.currScore-Math.sqrt((2*handler.getWorld().player.currScore)+1);
    		
    		
    	}
    	
    }

}
