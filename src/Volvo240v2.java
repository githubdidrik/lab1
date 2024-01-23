
import java.awt.*;

public class Volvo240v2 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240v2(){
        super("Volvo240", Color.black, 4, 100);
    }
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
