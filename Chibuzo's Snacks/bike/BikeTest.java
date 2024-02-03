package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void initializeBike() {
        bike = new Bike();
    }

    @Test
    public void turnOnBike_bikeIsOnTest() {
        assertFalse(bike.isOn());

        bike.toggle();
        assertTrue(bike.isOn());
    }

    @Test
    public void turnOffBike_bikeIsOffTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());

        bike.toggle();
        assertFalse(bike.isOn());
    }

    @Test
    public void accelerateBikeAtGearOneBikeSpeedIs15_currentSpeedIs16GearIsOneTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 15; count++) bike.accelerate();
        assertEquals(1, bike.getGear());
        assertEquals(15, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(16, bike.getCurrentSpeed());
        assertEquals(1, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearOneBikeSpeedIs20_currentSpeedIs21GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 20; count++) bike.accelerate();
        assertEquals(1, bike.getGear());
        assertEquals(20, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(21, bike.getCurrentSpeed());
        assertEquals(2, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearTwoBikeSpeedIs27_currentSpeedIs29GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 24; count++) bike.accelerate();
        assertEquals(2, bike.getGear());
        assertEquals(27, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(29, bike.getCurrentSpeed());
        assertEquals(2, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearTwoBikeSpeedIs29_currentSpeedIs31GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 25; count++) bike.accelerate();
        assertEquals(2, bike.getGear());
        assertEquals(29, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(31, bike.getCurrentSpeed());
        assertEquals(3, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearThreeBikeSpeedIs37_currentSpeedIs40GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 28; count++) bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(37, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(40, bike.getCurrentSpeed());
        assertEquals(3, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearThreeBikeSpeedIs40_currentSpeedIs43GearIsFourTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 29; count++) bike.accelerate();
        assertEquals(3, bike.getGear());
        assertEquals(40, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(43, bike.getCurrentSpeed());
        assertEquals(4, bike.getGear());
    }

    @Test
    public void accelerateBikeAtGearFourBikeSpeedIs47_currentSpeedIs51GearIsFourTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getGear());

        for (int count = 1; count <= 31; count++) bike.accelerate();
        assertEquals(4, bike.getGear());
        assertEquals(47, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(51, bike.getCurrentSpeed());
        assertEquals(4, bike.getGear());
    }


}