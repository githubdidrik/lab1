public class Saab95Factory extends VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Saab95();
    }
}
