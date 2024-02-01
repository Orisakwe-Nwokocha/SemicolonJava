package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    @Test
    public void toggleOn_acIsTurnedOnTest() {
        AirConditioner samsungAC = new AirConditioner();
        assertFalse(samsungAC.isOn());

        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());
    }

    @Test
    public void toggleOff_acIsTurnedOffTest() {
        AirConditioner samsungAC = new AirConditioner();

        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());

        samsungAC.toggleOff();
        assertFalse(samsungAC.isOn());
    }

    @Test
    public void increaseTemperature_temperatureIncreasesTest() {
        AirConditioner samsungAC = new AirConditioner();
        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());
        assertEquals(25, samsungAC.getTemperature());

        samsungAC.increaseTemperature();
        assertEquals(26, samsungAC.getTemperature());
    }

    @Test
    public void decreaseTemperature_temperatureDecreasesTest() {
        AirConditioner samsungAC = new AirConditioner();
        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());
        assertEquals(25, samsungAC.getTemperature());

        samsungAC.decreaseTemperature();
        assertEquals(24, samsungAC.getTemperature());
    }

    @Test
    public void increaseTemperatureBeyond30_temperatureRemainsUnchangedTest() {
        AirConditioner samsungAC = new AirConditioner();
        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());
        assertEquals(25, samsungAC.getTemperature());

        samsungAC.increaseTemperature(30);
        assertEquals(30, samsungAC.getTemperature());
        samsungAC.increaseTemperature();
        assertEquals(30, samsungAC.getTemperature());
    }

    @Test
    public void decreaseTemperatureBelow16_temperatureRemainsUnchangedTest() {
        AirConditioner samsungAC = new AirConditioner();
        samsungAC.toggleOn();
        assertTrue(samsungAC.isOn());
        assertEquals(25, samsungAC.getTemperature());

        samsungAC.decreaseTemperature();
        assertEquals(24, samsungAC.getTemperature());
    }
}
