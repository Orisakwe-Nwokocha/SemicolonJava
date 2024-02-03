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
    public void accelerateBikeAtGearOneAtSpeed15_currentSpeedIs16GearIsOneTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 15; count++) bike.accelerate();
        assertEquals(1, bike.getCurrentGear());
        assertEquals(15, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(16, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearOneAtSpeed20_currentSpeedIs21GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 20; count++) bike.accelerate();
        assertEquals(1, bike.getCurrentGear());
        assertEquals(20, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(21, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearTwoAtSpeed27_currentSpeedIs29GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 24; count++) bike.accelerate();
        assertEquals(2, bike.getCurrentGear());
        assertEquals(27, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(29, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearTwoAtSpeed29_currentSpeedIs31GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 25; count++) bike.accelerate();
        assertEquals(2, bike.getCurrentGear());
        assertEquals(29, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(31, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearThreeAtSpeed37_currentSpeedIs40GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 28; count++) bike.accelerate();
        assertEquals(3, bike.getCurrentGear());
        assertEquals(37, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(40, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearThreeAtSpeed40_currentSpeedIs43GearIsFourTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 29; count++) bike.accelerate();
        assertEquals(3, bike.getCurrentGear());
        assertEquals(40, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(43, bike.getCurrentSpeed());
        assertEquals(4, bike.getCurrentGear());
    }

    @Test
    public void accelerateBikeAtGearFourAtSpeed47_currentSpeedIs51GearIsFourTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 31; count++) bike.accelerate();
        assertEquals(4, bike.getCurrentGear());
        assertEquals(47, bike.getCurrentSpeed());

        bike.accelerate();
        assertEquals(51, bike.getCurrentSpeed());
        assertEquals(4, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearFourAtSpeed59_currentSpeedIs55GearIsFourTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 34; count++) bike.accelerate();
        assertEquals(4, bike.getCurrentGear());
        assertEquals(59, bike.getCurrentSpeed());

        bike.decelerate();
        assertEquals(55, bike.getCurrentSpeed());
        assertEquals(4, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearFourAtSpeed43_currentSpeedIs39GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 30; count++) bike.accelerate();
        assertEquals(4, bike.getCurrentGear());
        assertEquals(43, bike.getCurrentSpeed());

        bike.decelerate();
        assertEquals(39, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearThreeAtSpeed35_currentSpeedIs32GearIsThreeTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 30; count++) bike.accelerate();
        bike.decelerate();
        bike.accelerate();
        bike.decelerate();
        bike.decelerate();
        assertEquals(35, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(32, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearThreeAtSpeed31_currentSpeedIs28GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 26; count++) bike.accelerate();
        assertEquals(31, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(28, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearTwoAtSpeed24_currentSpeedIs22GearIsTwoTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 26; count++) bike.accelerate();
        assertEquals(31, bike.getCurrentSpeed());
        assertEquals(3, bike.getCurrentGear());
        for (int count = 1; count <= 3; count++) bike.decelerate();
        assertEquals(24, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(22, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearTwoAtSpeed21_currentSpeedIs19GearIsOneTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 21; count++) bike.accelerate();
        assertEquals(21, bike.getCurrentSpeed());
        assertEquals(2, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(19, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearOneAtSpeed15_currentSpeedIs14GearIsOneTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1, bike.getCurrentGear());

        for (int count = 1; count <= 15; count++) bike.accelerate();
        assertEquals(15, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(14, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());
    }

    @Test
    public void decelerateBikeAtGearOneAtSpeed0_currentSpeedIs0GearIsOneTest() {
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(0, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());

        bike.decelerate();
        assertEquals(0, bike.getCurrentSpeed());
        assertEquals(1, bike.getCurrentGear());
    }
    
}