package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class OptionsState extends State {

    private UIManager uiManager;

    public OptionsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-64, handler.getHeight()/2-100, 150, 150, Images.butstart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().pauseState);
            }
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/2-64, handler.getHeight()/2-100, 150, 150, Images.party, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart(); 
                handler.getWorld().player.setPartyTime(true); 
            }
        }));
        
        }
    	
    	// Move the Party click-able to top right for quality of life
    	// Add another click-able to change the background color
    	// Make it so applying partyTime doesn't reset the game/score
    	
    //Add Difficulty Screen? 
    //Make it so starting and increasing speed are less or more in respected difficulties
    
    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
    	g.setColor(Color.MAGENTA);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        uiManager.Render(g);

    }


}
