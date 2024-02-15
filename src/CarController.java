import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<Vehicle> cars = new ArrayList<>();
    RepairShop<Volvo240> workshop = new RepairShop<>(10);


    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        volvo.setPosition(new Point(0,0));
        saab.setPosition(new Point(0, 100));
        scania.setPosition(new Point(0, 200));

        cc.cars.add(volvo);
        cc.cars.add(saab);
        cc.cars.add(scania);

        cc.workshop.setPosition(new Point(300, 100));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> carsCopy = new ArrayList<>(cars);
            for (Vehicle car : carsCopy) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                if(y > 500 || x > 680 || y < 0 || x < 0){
                    car.turnRight();
                    car.turnRight();
                    car.move();
                }
                if(car.getModelName().equals("Volvo240")){
                    int wx = workshop.getPosition().x;
                    int wy = workshop.getPosition().y;
                    if(x <= wx + 40 && x >= wx - 40 && y <= wy + 40 && y >= wy - 40){
                        workshop.addCar((Volvo240) car);
                        car.stopEngine();
                        cars.remove(car);

                    }
                }
                frame.drawPanel.addVehicle(car);
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel

            }
            frame.drawPanel.addWorkshop(workshop);
            frame.drawPanel.repaint();

        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount)/100;
        for(Vehicle car : cars){
            car.brake(brake);
        }
    }
    void turboOff(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void turboOn(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void startCars(){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }
    void stopCars(){
        for(Vehicle car :cars ){
            car.stopEngine();
        }
    }
    void liftBed(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania) car).raiseBed();
            }
        }
    }
    void lowerBed(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania) car).lowerBed();
            }
        }
    }
}
