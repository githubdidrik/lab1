import java.awt.*;

public abstract class Truck extends Vehicle{
    public Truck(String modelName, Color color, int nrDoors, double enginePower) {
        super(modelName, color, nrDoors, enginePower);
    }
    public double speedFactor() {
        return 1;
    }
    public void startEngine(){
        super.startEngine();
    }
}
