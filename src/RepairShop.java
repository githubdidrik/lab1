import java.util.ArrayList;
import java.util.List;

public class RepairShop <T extends Car>{
    private final int maxCapacity;
    private List<T> carList;
    public RepairShop(int maxCapacity){
        this.maxCapacity = maxCapacity;
        carList = new ArrayList<T>();
    }
    public void addCar(T car){
        if(carList.size() < maxCapacity){
            carList.add(car);
            System.out.println(car.getClass().toString().substring(6) + "added to the repair shop.");
        } else {
            throw new RuntimeException("repair shop i full");
        }
    }
    public T retrieveCar(T car){
        if(!carList.isEmpty()) {
            T c = carList.get(carList.indexOf(car));
            carList.remove(car);
            System.out.println(car.getClass().toString().substring(6) + " retrieved from the repair shop.");
            return c;
        } else {
            throw new RuntimeException("no cars in repair shop");
        }
    }

}
