import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RepairShop <T extends Vehicle>{
    private Point position;
    private final int maxCapacity;
    private ArrayDeque<T> carList;
    public RepairShop(int maxCapacity){
        this.maxCapacity = maxCapacity;
        carList = new ArrayDeque<>();
        position = new Point(500, 500);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public ArrayDeque<T> getCars(){
        return carList;
    }
    public void addCar(T car){
        if(carList.size() < maxCapacity){
            carList.add(car);
            System.out.println(car.getClass().toString().substring(6) + "added to the repair shop.");
        } else {
            throw new RuntimeException("repair shop is full");
        }
    }
    public T retrieveCar(){
        if(!carList.isEmpty()) {
            return carList.remove();
        } else {
            throw new RuntimeException("no cars in repair shop");
        }
    }

}
