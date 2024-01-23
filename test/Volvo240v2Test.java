import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Volvo240v2Test {
    Volvo240v2 c = new Volvo240v2();
    @Test
    public void testGetNrDoors() {
        assertEquals(4, c.getNrDoors());
    }
    @Test
    public void testGetEnginePower() {
        assertEquals(100.0, c.getEnginePower(), 0.01);
    }
    @Test
    public void testGetCurrentSpeed() {
        assertEquals(0.0, c.getCurrentSpeed(),0.01);
    }
    @Test
    public void testGetColor() {
        assertEquals(Color.BLACK, c.getColor());
    }
    @Test
    public void testSetColor() {
        c.setColor(Color.RED);
        assertEquals(Color.RED, c.getColor());
    }

    @Test
    public void testStartEngine() {
        c.startEngine();
        assertEquals(0.1, c.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testStopEngine() {
        c.stopEngine();
        assertEquals(0.0,c.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testStartingPosition() {
        Point p = new Point(0,0);
        c.startingPosition();
        assertEquals(p, c.getPosition());
    }
    @Test
    public void testMove() {
        Point p = new Point(0, (int) c.getCurrentSpeed());
        c.move();
        assertEquals(p, c.getPosition());
    }
    @Test
    public void testTurnLeft() {
        c.turnLeft();
        assertEquals(-1, c.getDirection());
    }
    @Test
    public void testTurnRight() {
        c.turnRight();
        assertEquals(1,c.getDirection());
    }
    @Test
    public void testGetPosition() {
        Point p = new Point(0,0);
        assertEquals(p, c.getPosition());
    }
    @Test
    public void testGetDirection() {
        assertEquals(0, c.getDirection());
    }
    @Test
    public void testSpeedFactor() {
        assertEquals(1.25, c.speedFactor(), 0.01);
    }
    @Test
    public void testIncrementSpeed() {
        c.incrementSpeed(5);
        assertEquals(6.25, c.getCurrentSpeed(), 0.01);
    }
    @Test
    public void testDecrementSpeed() {
        c.decrementSpeed(5);
        assertEquals(0.0, c.getCurrentSpeed(),0.01);
    }
    @Test
    public void testGas() {
        c.gas(0.5);
        assertEquals(0.625, c.getCurrentSpeed(),0.01);
    }
    @Test
    public void testBrake() {
        c.brake(0.5);
        assertEquals(0.0, c.getCurrentSpeed(), 0.01);
    }

}