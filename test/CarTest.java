import junit.framework.TestCase;
import org.junit.Before;

import java.awt.*;

public class CarTest extends TestCase {
    Car c = new Car("Saab95", Color.RED, 2, 125);
    public void testGetNrDoors() {
        assertEquals(2, c.getNrDoors());
    }

    public void testGetEnginePower() {
        assertEquals(125.0, c.getEnginePower(), 0.01);
    }

    public void testGetCurrentSpeed() {
        assertEquals(0.0, c.getCurrentSpeed(),0.01);
    }

    public void testGetColor() {
        assertEquals(Color.RED, c.getColor());
    }

    public void testSetColor() {
        c.setColor(Color.BLACK);
        assertEquals(Color.BLACK, c.getColor());
    }


    public void testStartEngine() {
        c.startEngine();
        assertEquals(0.1, c.getCurrentSpeed());
    }

    public void testStopEngine() {
        c.stopEngine();
        assertEquals(0.0,c.getCurrentSpeed());
    }

    public void testStartingPosition() {
        Point p = new Point(0,0);
        c.startingPosition();
        assertEquals(p, c.getPosition());
    }

    public void testMove() {
        Point p = new Point(0, (int) c.getCurrentSpeed());
        c.move();
        assertEquals(p, c.getPosition());
    }

    public void testTurnLeft() {
        c.turnLeft();
        assertEquals(-1, c.getDirection());
    }

    public void testTurnRight() {
        c.turnRight();
        assertEquals(1,c.getDirection());
    }

    public void testGetPosition() {
        Point p = new Point(0,0);
        assertEquals(p, c.getPosition());
    }

    public void testGetDirection() {
        assertEquals(0, c.getDirection());
    }
}