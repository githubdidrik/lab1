import java.awt.*;

public class Main {
    public static void main(String[] args) {
        CarView view = new CarView("CarSim 2.0");
        Model model = new Model();
        model.addObserver(view);
        CarController cc = new CarController(model, view);
        cc.timer.start();
    }
}
