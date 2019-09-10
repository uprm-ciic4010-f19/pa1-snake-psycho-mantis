package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage Pause;
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
    public static BufferedImage OptionsScreen;
    public static BufferedImage[] party;
    public static ImageIcon icon;
    public static BufferedImage HelpScreen;
    public static BufferedImage[] Return;
    
    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        party = new BufferedImage[3];
        Return = new BufferedImage[3];
        
        
        try {

            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/Title.png"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
            Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
            Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));//clickbut
            party[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormParty.png")); //normParty
            party[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverParty.png")); //hoverParty
            party[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedParty.png")); //clickedParty
            HelpScreen = ImageIO.read(getClass().getResourceAsStream("/Sheets/HelpScreen.png"));
            Return[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ReturnNorm.png"));
            Return[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ReturnHover.png"));
            Return[2] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ReturnClicked.png"));
            
            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
        e.printStackTrace();
        }
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
