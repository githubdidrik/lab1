public abstract class VehicleFactory {
    public Vehicle addCar(){
        return createVehicle();
    }
    public abstract Vehicle createVehicle();
}
