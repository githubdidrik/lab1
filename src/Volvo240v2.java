
import java.awt.*;

public class Volvo240v2 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240v2(){
        super("Volvo240", Color.black, 4, 100);
    }
    @Override
    public double speedFactor(){
        return super.speedFactor()*trimFactor;
    }
}
