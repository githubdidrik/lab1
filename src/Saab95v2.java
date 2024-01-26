
import java.awt.*;

public class Saab95v2 extends Car {
    private boolean turboOn;
    public Saab95v2(){
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
