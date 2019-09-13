package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class PauseState extends State {

    private int count = 0;
    private UIManager uiManager;

    public PauseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(56+ 100, 223+60, 128, 64, Images.Resume, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().gameState);
        }));

        uiManager.addObjects(new UIImageButton(56+60, 223+(200+16), 128, 64, Images.Options, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().optionsState);
        }));

        uiManager.addObjects(new UIImageButton(56+40, (223+(280+16))+(64+16), 128, 64, Images.Help, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().helpState);
        }));



// Fix bug where Pause screen changes back to in game when holding ESC down

    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.Pause,0,0,800,800,null);
        uiManager.Render(g);

    } 
     
}
