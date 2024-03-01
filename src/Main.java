import java.awt.*;

public class Main {
    public static void main(String[] args) {
        CarView frame = new CarView("CarSim 2.0");
        Model model = new Model(frame);
        CarController cc = new CarController(model, frame);
        cc.timer.start();
    }
}
