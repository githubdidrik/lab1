
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;
    private BufferedImage image;

    {
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public BufferedImage getImage(){
        return image;
    }

    public Volvo240(){
        super("Volvo240", Color.black, 4, 100);
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01*trimFactor;
    }
}
