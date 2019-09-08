package Game.Entities.Dynamic;

import Main.Handler;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;


/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {

    public int lenght;
    public boolean justAte;
    public boolean justDoubled;
    public boolean justSlowed;
    private Handler handler;
    public boolean partyTime;
    Color DarkPurple= new Color(66,28,82);
    public int xCoord;
    public int yCoord;

    public int moveCounter;
    
    public int speed = 10;
    public double currScore ;

    public String direction;//is your first name one?
    
    Random rand = new Random(); //random color generator

	float r = rand.nextFloat();
	float v = rand.nextFloat();
	float b = rand.nextFloat();
	
	Color randomColor = new Color(r,v,b);
	
    public Player(Handler handler){
        this.handler = handler;
        xCoord = 0;
        yCoord = 0;
        moveCounter = 0;
        direction= "Right";
        justAte = false;
        justDoubled = false; 
        justSlowed = false;
        partyTime = false;
        lenght= 1;
        currScore=0.0;
    
        Random rand = new Random();

    	float r = rand.nextFloat();
    	float v = rand.nextFloat();
    	float b = rand.nextFloat();
    	
    	Color randomColor = new Color(r,v,b);
    }

    public void tick(){
    	moveCounter++;
        if(moveCounter>=speed) {
            checkCollisionAndMove();
            moveCounter=0;
            
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)){
            direction="Up";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)){
            direction="Down";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)){
            direction="Left";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)){
            direction="Right";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) {
        	handler.getWorld().body.addLast(new Tail(xCoord,yCoord,handler));
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS))
        {  speed--; 
        	
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) {
        	speed++; 
        	
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
        	
        	handler.getGame().pause();
        	
        } 
        
    
        }

    public void checkCollisionAndMove(){
        handler.getWorld().playerLocation[xCoord][yCoord]=false;
        int x = xCoord;
        int y = yCoord;
        switch (direction){
            case "Left":
                if(xCoord==0){
                    xCoord = handler.getWorld().GridWidthHeightPixelCount-1;}
                else {
                	xCoord--;
                }
                break;
            case "Right":
                if(xCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                	xCoord=0;}
                else {
                	xCoord++; 
                }
                break;
            case "Up":
                if(yCoord==0){
                	yCoord=handler.getWorld().GridWidthHeightPixelCount-1;}
                else {
                	yCoord--;
                }
                break;
            case "Down":
                if(yCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                	yCoord=0;}
                else {
                	yCoord++;
                	}
                break;
        }
        handler.getWorld().playerLocation[xCoord][yCoord]=true; 


        if(handler.getWorld().appleLocation[xCoord][yCoord]){
            Eat();}

        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
        }
        
        if(handler.getWorld().doubleUpLocation[xCoord][yCoord]){
            Dub();}
        
        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
        }
        
        if(handler.getWorld().slowDownLocation[xCoord][yCoord]){
            Slow();}
        
        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
        }
    }
    public void render(Graphics g,Boolean[][] playeLocation){

    	if (!partyTime) {
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
                g.setColor(Color.GREEN);
                

                if(playeLocation[i][j]){
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                }
          
                if(handler.getWorld().doubleUpLocation[i][j]) { 
                	
                	if (speed>0 && currScore>0.0) {
                		
            
                		g.setColor(Color.ORANGE);
                		 g.fillRect((i*handler.getWorld().GridPixelsize),
                                 (j*handler.getWorld().GridPixelsize),
                                 handler.getWorld().GridPixelsize,
                                 handler.getWorld().GridPixelsize);
                	}	
                	else {
                		g.setColor(DarkPurple);
               		 	g.fillRect((i*handler.getWorld().GridPixelsize),
                                (j*handler.getWorld().GridPixelsize),
                                handler.getWorld().GridPixelsize,
                                handler.getWorld().GridPixelsize);
                	}
                }
                
                if(handler.getWorld().slowDownLocation[i][j]) {
                	
                	if (speed<2) {
                    g.setColor(Color.cyan);
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                	}
                	else {
                		g.setColor(DarkPurple);
               		 	g.fillRect((i*handler.getWorld().GridPixelsize),
                                (j*handler.getWorld().GridPixelsize),
                                handler.getWorld().GridPixelsize,
                                handler.getWorld().GridPixelsize);
                			}	
                		}
                	
                
                
                if(handler.getWorld().appleLocation[i][j]) {
                	if(handler.getWorld().apple.good) {
                		 g.setColor(Color.RED);
                		 g.fillRect((i*handler.getWorld().GridPixelsize),
                                 (j*handler.getWorld().GridPixelsize),
                                 handler.getWorld().GridPixelsize,
                                 handler.getWorld().GridPixelsize);
                	}
                	else {
                	 g.setColor(Color.YELLOW);
               		 g.fillRect((i*handler.getWorld().GridPixelsize),
                                (j*handler.getWorld().GridPixelsize),
                                handler.getWorld().GridPixelsize,
                                handler.getWorld().GridPixelsize);
                		}
                	}  	
                }
            }   
        }   
    	
    	else {   
    		for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
            		g.setColor(randomColor); 
            		//changes color every time dance ball is clicked
            		// make it change color every 30 ticks or 6 moves
            		 if(playeLocation[i][j]) {
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                }
                if(handler.getWorld().appleLocation[i][j]) {
                	if(handler.getWorld().apple.good) {
                		g.setColor(Color.RED);
                		 g.fillRect((i*handler.getWorld().GridPixelsize),
                                 (j*handler.getWorld().GridPixelsize),
                                 handler.getWorld().GridPixelsize,
                                 handler.getWorld().GridPixelsize);
                	}
                	else {
                		g.setColor(Color.GREEN);
               		 g.fillRect((i*handler.getWorld().GridPixelsize),
                                (j*handler.getWorld().GridPixelsize),
                                handler.getWorld().GridPixelsize,
                                handler.getWorld().GridPixelsize);
                		}
                	}
                }
            }
        }
    }        

    public void Eat(){
    	currScore += Math.sqrt((2*currScore)+1);
    	speed = speed-1;  
    	this.justAte=true;
    	this.handler.getGame().setScore(currScore);
    	 System.out.println(this.currScore);
        lenght++;
        Tail tail= null;
        handler.getWorld().appleLocation[xCoord][yCoord]=false;
        handler.getWorld().appleOnBoard=false;
        switch (direction){
            case "Left":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail = new Tail(this.xCoord+1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail = new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail =new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler);
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler);

                        }
                    }

                }
                break;
            case "Right":
                if( handler.getWorld().body.isEmpty()){
                    if(this.xCoord!=0){
                        tail=new Tail(this.xCoord-1,this.yCoord,handler);
                    }else{
                        if(this.yCoord!=0){
                            tail=new Tail(this.xCoord,this.yCoord-1,handler);
                        }else{
                            tail=new Tail(this.xCoord,this.yCoord+1,handler);
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().x!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                        }
                    }

                }
                break;
            case "Up":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(this.xCoord,this.yCoord+1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=handler.getWorld().GridWidthHeightPixelCount-1){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
            case "Down":
                if( handler.getWorld().body.isEmpty()){
                    if(this.yCoord!=0){
                        tail=(new Tail(this.xCoord,this.yCoord-1,handler));
                    }else{
                        if(this.xCoord!=0){
                            tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                        }
                    }
                }else{
                    if(handler.getWorld().body.getLast().y!=0){
                        tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                        }
                    }

                }
                break;
        }
        handler.getWorld().body.addLast(tail);
        handler.getWorld().playerLocation[tail.x][tail.y] = true;
       
    }
    
    public void Dub(){
    	if (speed>0 && currScore>0) {
    	currScore = currScore*2;
    	speed = speed-3;  
    	this.justDoubled=true;
    	this.handler.getGame().setScore(currScore);
    	System.out.println(this.currScore);
        handler.getWorld().doubleUpLocation[xCoord][yCoord]=false;
        handler.getWorld().doubleUpOnBoard=false;
    	}
    else {
    	this.justDoubled=false;
    	}
   }
    
    public void Slow(){
    	if (speed<2) {
    	currScore += 0.5*Math.sqrt((2*currScore)+1);
    	speed = speed+3;  
    	this.justSlowed=true;
    	this.handler.getGame().setScore(currScore);
    	System.out.println(this.currScore);
        handler.getWorld().slowDownLocation[xCoord][yCoord]=false;
        handler.getWorld().slowDownOnBoard=false;
    	}
    else {
    	this.justSlowed=false;
    	}
   }
    	
    public void kill(){
        lenght = 0;
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {

                handler.getWorld().playerLocation[i][j]=false;

            }
        }
    }

   
    
   
    public boolean isJustAte() {
        return justAte;
    }

    public void setJustAte(boolean justAte) {
        this.justAte = justAte;
        
    }
    public boolean isJustDoubled() {
    	return justDoubled;}
    	
    public void setJustDoubled(boolean justDoubled) {
    	this.justDoubled = justDoubled;
    }
    
	public boolean isJustSlowed() {
		return justSlowed;}
	
	public void setJustSlowed(boolean justSlowed) {
		this.justSlowed = justSlowed;
}

    
	public double getCurrScore() {
		return currScore;
	}

	public void setCurrScore(double currScore) {
		this.currScore = currScore;
	}
    public boolean partyTime() {
    	return partyTime;
    }
    
    public void setPartyTime(boolean partyTime) {
    	this.partyTime = partyTime;
    	
    }
}
