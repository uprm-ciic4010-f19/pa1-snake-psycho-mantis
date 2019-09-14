package Game.Entities.Static;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord;
    public boolean isGood;
    
    public Apple(Handler handler,int x, int y,Boolean isGood){
        this.handler=handler;
        this.xCoord=x;
        this.yCoord=y;
        this.isGood=isGood;
        
    }

    public boolean getGood() {
		return isGood;
	}

	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
}
