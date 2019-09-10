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
public class HelpState extends State {

    private UIManager uiManager;

    public HelpState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
        // Add click-able to return to pause screen over bottom left arrow
        // Draw animated arrows and add the 
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/5-120, handler.getHeight()/3+370, 100, 100, Images.Return, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null); 
                State.setState(handler.getGame().pauseState);
            }
        }));
        
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
        g.drawImage(Images.HelpScreen,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

    }


}