import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepairShopTest {
    RepairShop<Scania> scaniaRepairShop;
    Scania scania;
    Volvo240v2 volvo;
    @Before
    public void setUp() {
        scaniaRepairShop = new RepairShop<>(8);
        scania = new Scania();
        volvo = new Volvo240v2();
    }

    @Test
    public void addCar() {
        scaniaRepairShop.addCar(scania);
        assertEquals(scania, scaniaRepairShop.getCars().getFirst());
    }

    @Test
    public void retrieveCar() {
        scaniaRepairShop.addCar(scania);
        assertEquals(scania, scaniaRepairShop.retrieveCar());
        assertTrue(scaniaRepairShop.getCars().isEmpty());
    }
}