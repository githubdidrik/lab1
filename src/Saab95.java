
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Car {
    private boolean turboOn;
    private BufferedImage image;

    {
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public BufferedImage getImage(){
        return image;
    }
    public Saab95(){
        super("Saab95", Color.RED, 2, 125);
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = turboOn ? 1.3 : 1.0;
        return enginePower * 0.01*turbo;
    }

}
