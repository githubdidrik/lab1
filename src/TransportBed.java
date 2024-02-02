public class TransportBed implements HasBed{
    private boolean bedUp;
    @Override
    public boolean isbedUp() {
        return bedUp;
    }

    @Override
    public void raiseBed() {
        bedUp = true;
    }

    @Override
    public void lowerBed() {
        bedUp = false;
    }
}
