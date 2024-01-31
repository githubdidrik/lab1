import java.awt.*;

public class Scania extends Car implements HasBed{
    private int bedAngle;
    public Scania() {
        super("Scania", Color.PINK, 2, 200);
        bedAngle = 0;
    }

    public int getBedAngle() {
        return bedAngle;
    }

    public double speedFactor() {
        return 1;
    }
    public void raiseBed(int amount){
        if(this.getCurrentSpeed() == 0 && bedAngle + amount < 70){
            bedAngle += amount;
        }
    }
    public void lowerBed(int amount){
        if(this.getCurrentSpeed() == 0 && bedAngle >= amount){
            bedAngle -= amount;
        }
    }
    @Override
    public void startEngine(){
        if(bedAngle == 0){
            super.startEngine();
        }
    }

}
