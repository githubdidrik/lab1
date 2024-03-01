public class ScaniaFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Scania();
    }
}
