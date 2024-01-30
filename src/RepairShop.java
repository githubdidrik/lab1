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
        if(){
            carList.add(car);
        }

    }
    public void retrieveCar(){

    }

}
