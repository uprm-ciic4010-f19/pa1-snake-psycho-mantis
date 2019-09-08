package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class HelpState extends State {

    private UIManager uiManager;

    public HelpState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
        // Add click-able to return to pause screen over bottom left arrow
        // Draw animated arrows and add them to buttons for click-able 
        
    }
    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
    	g.setColor(Color.MAGENTA);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.help,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

    }


}