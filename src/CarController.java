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
    Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    //MODEL
    Model model = new Model();
    ArrayList<Vehicle> cars = model.cars;
    RepairShop<Volvo240> workshop = model.workshop;

    int gasAmount = 0;
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model = model.update();
            for(Vehicle v : cars){ // uses the updated model to send changes to the view
                frame.drawPanel.addImage(v.getImage(), v.getPosition());
                frame.drawPanel.moveit(v.getImage(), v.getPosition());
            }
            frame.drawPanel.addImage(workshop.getImage(), workshop.getPosition());
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
