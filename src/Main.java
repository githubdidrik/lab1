import java.awt.*;

public class Main {
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

        cc.workshop.setPosition(new Point(300, 0));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }
}
