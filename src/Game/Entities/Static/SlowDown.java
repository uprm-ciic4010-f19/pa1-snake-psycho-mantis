package Game.Entities.Static;

import Main.Handler;

public class SlowDown {
// Power-up that speeds you up but rewards more score (2x)
	    private Handler handler;

	    public int xCoord;
	    public int yCoord;
	    
	    public SlowDown(Handler handler,int x, int y) {
	        this.handler=handler;
	        this.xCoord=x;
	        this.yCoord=y;
	    }
	}
