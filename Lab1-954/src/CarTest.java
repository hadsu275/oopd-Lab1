import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    @Test
    void testGetNrDoors() {
        Volvo240 volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    void testGetEnginePower() {
        Saab95 saab = new Saab95();
        assertEquals(125, saab.getEnginePower());
    }
    @Test
    void testGetModelName() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();

        assertSame("Volvo240", volvo.getModelName());
        assertSame("Saab95", saab.getModelName());
    }
    @Test
    void testGetCurrentSpeed() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());
    }
    @Test
    void testGetColor() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        assertSame(Color.BLACK, volvo.getColor());
        assertSame(Color.RED, saab.getColor());
    }
    @Test
    void testSetColor() {
        Volvo240 volvo = new Volvo240();
        volvo.setColor(Color.BLACK);
        assertEquals(Color.BLACK, volvo.getColor());
        volvo.setColor(Color.red);
        assertEquals(Color.red, volvo.getColor());
    }
    @Test
    void testStartEngine() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.currentSpeed);
    }
    @Test
    void testStopEngine() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.currentSpeed = 5;
        saab.stopEngine();

        assertEquals(0, saab.currentSpeed);
    }
    @Test
    void testIncrementSpeed() {
        Volvo240 volvo240 = new Volvo240();
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.incrementSpeed(0.3);
        double efterIncr = volvo240.getCurrentSpeed();
        assert (startSpeed < efterIncr);
    }

    @Test
    void testDecrementSpeed() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.decrementSpeed(0.8);
        double efterIncr = volvo240.getCurrentSpeed();
        assert (startSpeed > efterIncr);
    }

    @Test
    void testGas() {
        Volvo240 volvo240 = new Volvo240();
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.gas(0.2);
        double efterSpeed = volvo240.getCurrentSpeed();
        assert(startSpeed < volvo240.getCurrentSpeed());
    }
    @Test
    void testBrake() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        double startSpeed = volvo240.getCurrentSpeed();
        volvo240.brake(0.5);
        double efterSpeed = volvo240.getCurrentSpeed();
        assert(startSpeed > efterSpeed);
    }
    @Test
    void testMove() {
        Saab95 saab = new Saab95();
        saab.direction = "North";
        saab.startEngine();
        saab.setTurboOn();
        saab.brake(0.5);
        saab.y = 1;
        saab.move();

        assertEquals("North",saab.direction );
        assertTrue(saab.y > saab.currentSpeed);
    }
    @Test
    void testTurnLeft() {
        Volvo240 volvo = new Volvo240();
        volvo.direction = "West";
        volvo.turnLeft();

        assertSame("South", volvo.direction);
    }
    @Test
    void testTurnRight() {
        Volvo240 volvo = new Volvo240();
        volvo.direction = "North";
        volvo.turnRight();

        assertSame("East", volvo.direction);
    }
}
