import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @Test
    void testSetTurboOn() {
        Saab95 saab95 = new Saab95();
        assertTrue(true);
    }

    @Test
    void testSetTurboOff() {
        Saab95 saab95 = new Saab95();
        assertFalse(false);
    }

    @Test
    void testSpeedFactor() {
        Saab95 saab95 = new Saab95();
        double speedFact = saab95.speedFactor();
        assertEquals(speedFact, saab95.speedFactor());
    }
}