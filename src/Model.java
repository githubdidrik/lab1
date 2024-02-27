import java.util.ArrayList;

public class Model {
    ArrayList<Vehicle> cars = new ArrayList<>();
    RepairShop<Volvo240> workshop = new RepairShop<>(10);
    public Model(){
    }
    public Model(Model model) {
        this.cars = model.cars;
        this.workshop = model.workshop;
    }

    public Model update() {
        ArrayList<Vehicle> carsCopy = new ArrayList<>(cars);
        for (Vehicle car : carsCopy) {
            car.move();
            int x = (int) Math.round(car.getPosition().getX());
            int y = (int) Math.round(car.getPosition().getY());
            if (outOfBounds(x,y)) {
                car.turnRight();
                car.turnRight();
                car.move();
            }
            if (car.getModelName().equals("Volvo240") && inWorkshopBounds(x,y)) {
                workshop.addCar((Volvo240) car);
                car.stopEngine();
                cars.remove(car);
            }
        }
        return new Model(this);

    }
    private boolean outOfBounds(int x, int y){
        return (y > 500 || x > 680 || y < 0 || x < 0);
    }
    private boolean inWorkshopBounds(int x, int y){
        int wx = workshop.getPosition().x;
        int wy = workshop.getPosition().y;
        return (x <= wx + 40 && x >= wx - 40 && y <= wy + 40 && y >= wy - 40);
    }
}