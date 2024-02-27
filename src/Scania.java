import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Truck{
    private TruckBed bed;
    private BufferedImage image;

    {
        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public BufferedImage getImage(){
        return image;
    }

    public Scania() {
        super("Scania", Color.PINK, 2, 300);
        bed = new TruckBed();
    }

    public int getBedAngle() {
        return bed.getBedAngle();
    }

    public void raiseBed(){
        if(this.getCurrentSpeed() == 0 && bed.getBedAngle() + 5 < 70){
            bed.raiseBed();
        }
    }
    public void lowerBed(){
        if(this.getCurrentSpeed() == 0 && bed.getBedAngle() >= 5){
            bed.lowerBed();
        }
    }
    @Override
    public void startEngine(){
        if(bed.isbedUp()){
            super.startEngine();
        }
    }


}
