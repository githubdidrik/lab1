import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck{
    private Stack<Car> loadedCars;
    private final int maxCars = 8;
    private TransportBed bed;
    public CarTransport(){
        super("Volvo FH", Color.BLACK, 2, 400);
        loadedCars = new Stack<>();
        bed = new TransportBed();
    }
    public boolean isBedUp(){
        return bed.isbedUp();
    }
    public Stack<Car> getLoadedCars(){return loadedCars;}
    public void loadCar(Car car){
        if(!bed.isbedUp() && distanceToTransport(car) < 5 && loadedCars.size() < maxCars){
            loadedCars.push(car);
        } else{
            throw new RuntimeException("cant load car");
        }

    }
    public Car deloadCar(){
        if(!bed.isbedUp() && !loadedCars.isEmpty()){
            Car deloadedCar = loadedCars.pop();
            Point newPos = new Point(this.getPosition().x + 4, this.getPosition().y);
            deloadedCar.setPosition(newPos);
            return deloadedCar;
        } else{
            throw new RuntimeException("cant deload the car");
        }

    }
    @Override
    public void move(){
        super.move();
        for(Car c : loadedCars){
            c.setPosition(this.getPosition());
        }
    }

    public void raiseBed() {
        if(this.getCurrentSpeed() == 0 && !bed.isbedUp()){
            bed.raiseBed();
        }
    }

    public void lowerBed() {
        if(this.getCurrentSpeed() == 0 && bed.isbedUp()){
            bed.lowerBed();
        }
    }@Override
    public void startEngine(){
        if(bed.isbedUp()){
            super.startEngine();
        }
    }
    private double distanceToTransport(Car car){
        double xDiff = this.getPosition().x - car.getPosition().x;
        double yDiff = this.getPosition().y - car.getPosition().y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
}
