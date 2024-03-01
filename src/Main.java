import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        Model model = new Model();
        CarController cc = new CarController(model);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }
}
