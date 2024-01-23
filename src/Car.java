
import java.awt.*;
public class Car implements Movable {
    private final String modelName;
    private final int nrDoors;
    public final double enginePower;
    public double currentSpeed;
    private Color color;
    private Point position;
    private int direction; // -1 left, 0 straight, +1 right


    public Car(String modelName, Color color, int nrDoors, double enginePower){
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        stopEngine();
        startingPosition();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Point getPosition(){
        return position;
    }
    public int getDirection(){
        return direction;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public void startingPosition(){
        position = new Point(0,0);
        direction = 0;
    }

    public void move() {
        if(direction == 0){
            position.y += currentSpeed;
        } else{
            position.x += currentSpeed*direction;
        }

    }

    public void turnLeft() {
        direction = -1;
    }

    public void turnRight() {
        direction = 1;
    }
}
