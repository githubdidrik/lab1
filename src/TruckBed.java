public class TruckBed implements HasBed{
    private int bedAngle;
    public TruckBed(){
        bedAngle = 0;
    }
    public boolean isbedUp() {
        return bedAngle == 0;
    }
    public int getBedAngle(){
        return bedAngle;
    }
    public void raiseBed() {
        bedAngle += 5;
    }

    public void lowerBed() {
        bedAngle -= 5;
    }
}
