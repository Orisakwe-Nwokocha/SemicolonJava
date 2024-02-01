package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {
    private AirConditioner samsungAC;

    @BeforeEach
    public void initializeAc() {
        samsungAC = new AirConditioner();
    }

    @Test
    public void turnOnAc_acIsOnTest() {
        assertFalse(samsungAC.isOn());

        samsungAC.toggle();
        assertTrue(samsungAC.isOn());
    }

    @Test
    public void turnOffAc_acIsOffTest() {
        assertFalse(samsungAC.isOn());
        samsungAC.toggle();
        assertTrue(samsungAC.isOn());

        samsungAC.toggle();
        assertFalse(samsungAC.isOn());
    }

    @Test
    public void increaseAcTemperatureFrom16To17_temperatureIncreasesTest() {
        samsungAC.toggle();
        assertTrue(samsungAC.isOn());
        assertEquals(16, samsungAC.getTemperature());

        samsungAC.increaseTemperature();
        assertEquals(17, samsungAC.getTemperature());
    }

    @Test
    public void decreaseAcTemperatureFrom18To17_temperatureDecreasesTest() {
        samsungAC.toggle();
        assertTrue(samsungAC.isOn());
        samsungAC.increaseTemperature();
        samsungAC.increaseTemperature();
        assertEquals(18, samsungAC.getTemperature());


        samsungAC.decreaseTemperature();
        assertEquals(17, samsungAC.getTemperature());
    }

    @Test
    public void increaseAcTemperatureAt30_temperatureIs30Test() {
        samsungAC.toggle();
        assertTrue(samsungAC.isOn());
        assertEquals(16, samsungAC.getTemperature());

        for (int count = 0; count < 14; count++) samsungAC.increaseTemperature();
        assertEquals(30, samsungAC.getTemperature());

        samsungAC.increaseTemperature();
        assertEquals(30, samsungAC.getTemperature());
    }

    @Test
    public void decreaseAcTemperatureAt16_temperatureIs16Test() {
        samsungAC.toggle();
        assertTrue(samsungAC.isOn());
        assertEquals(16, samsungAC.getTemperature());

        samsungAC.decreaseTemperature();
        assertEquals(16, samsungAC.getTemperature());
    }
}
