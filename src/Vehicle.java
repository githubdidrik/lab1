import java.awt.*;

public abstract class Vehicle implements Movable{
    private final String modelName;
    private final int nrDoors;
    protected final double enginePower;
    private double currentSpeed;
    private Color color;
    private Point position;
    private int direction; // -1 left, 0 straight, +1 right

    public Vehicle(String modelName, Color color, int nrDoors, double enginePower){
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;

        stopEngine();
        startingPosition();
    }
    public String getModelName(){return modelName;}
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
    public void setPosition(Point newPosition){
        this.position = newPosition;
    }
    public int getDirection(){
        return direction;
    }
    public void startEngine(){
        currentSpeed = 10;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public void startingPosition(){
        position = new Point(0,0);
        direction = 0;
    }
    public abstract double speedFactor();


    private void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if(newSpeed >= currentSpeed){
            currentSpeed = newSpeed;
        }
    }

    private void decrementSpeed(double amount){
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if(newSpeed <= currentSpeed){
            currentSpeed = newSpeed;
        }
    }
    @Override
    public void move() {
        switch (direction){
            case 0:
                position.x += currentSpeed;
                break;
            case 1:
                position.y += currentSpeed;
                break;
            case 2:
                position.x -= currentSpeed;
                break;
            case 3:
                position.y -= currentSpeed;
                break;
        }

    }
    @Override
    public void turnLeft() {
        direction = Math.floorMod(direction - 1, 4);
    }
    @Override
    public void turnRight() {
        direction = Math.floorMod(direction + 1, 4);
    }

    public void gas(double amount){
        if(amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if(amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
