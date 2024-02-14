import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTransportTest {
    CarTransport ct;
    Car c;
    @Before
    public void setUp() {
        ct = new CarTransport();
        c = new Saab95();
    }

    @Test
    public void raiseBed() {
        ct.raiseBed();
        assertTrue(ct.isBedUp());
    }

    @Test
    public void lowerBed() {
        ct.lowerBed();
        assertFalse(ct.isBedUp());
    }

    @Test
    public void loadCar() {
        ct.lowerBed();
        ct.loadCar(c);
        assertEquals(1, ct.getLoadedCars().size());
    }

    @Test
    public void deloadCar() {
        ct.lowerBed();
        ct.loadCar(c);
        ct.deloadCar();
        assertEquals(0, ct.getLoadedCars().size());
    }
}