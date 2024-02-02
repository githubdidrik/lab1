import java.awt.*;

public class Scania extends Truck{
    private TruckBed bed;
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
