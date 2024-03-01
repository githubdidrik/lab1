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

public class CarController implements ButtonObserver {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //MODEL
    Model model;
    ArrayList<Vehicle> cars;
    RepairShop<Volvo240> workshop;

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    public CarController(Model model, CarView frame){
        this.model = model;
        this.cars = model.cars;
        this.workshop = model.workshop;
        this.frame = frame;
        frame.addObserver(this);
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
        }
    }
    public void addCar(){
        model.addCar();
    }
    public void removeCar(){
        Vehicle removedCar = model.removeCar();
        frame.drawPanel.removeImage(removedCar.getImage());
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount)/ 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    public void brake(int amount){
        double brake = ((double) amount)/100;
        for(Vehicle car : cars){
            car.brake(brake);
        }
    }
    public void turboOff(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95) car).setTurboOff();
            }
        }
    }
    public void turboOn(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    public void startCars(){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }
    public void stopCars(){
        for(Vehicle car :cars ){
            car.stopEngine();
        }
    }
    public void liftBed(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania) car).raiseBed();
            }
        }
    }
    public void lowerBed(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania) car).lowerBed();
            }
        }
    }
}
