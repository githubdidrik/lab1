import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTransportTest {
    CarTransport ct;
    Car c;
    @Before
    public void setUp() {
        ct = new CarTransport();
        c = new Saab95v2();
    }

    @Test
    public void raiseBed() {
        ct.raiseBed(10);
        assertTrue(ct.isBedUp());
    }

    @Test
    public void lowerBed() {
        ct.lowerBed(10);
        assertFalse(ct.isBedUp());
    }

    @Test
    public void loadCar() {
        ct.lowerBed(10);
        ct.loadCar(c);
        assertEquals(1, ct.getLoadedCars().size());
    }

    @Test
    public void deloadCar() {
        ct.loadCar(c);
        ct.deloadCar();
        assertEquals(0, ct.getLoadedCars().size());
    }
}