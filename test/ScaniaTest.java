import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {
    Scania scania;
    @Before
    public void setUp() {
        scania = new Scania();
    }

    @Test
    public void raiseBed() {
        scania.raiseBed(10);
        assertEquals(10, scania.getBedAngle());
    }

    @Test
    public void lowerBed() {
        scania.lowerBed(10);
        assertEquals(0, scania.getBedAngle());
    }

}