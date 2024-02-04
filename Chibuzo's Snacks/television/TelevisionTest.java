package television;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTest {
    private Television toshiba;

    @BeforeEach
    public void initializeTv() {
        toshiba = new Television();
    }

    @Test
    public void turnOnTv_tvIsOnTest() {
        assertFalse(toshiba.isOn());

        toshiba.toggle();
        assertTrue(toshiba.isOn());
    }

    @Test
    public void turnOffTv_tvIsOffTest() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());

        toshiba.toggle();
        assertFalse(toshiba.isOn());
    }

    @Test
    public void displayChannelOne_channelOneIsDisplayedTest() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());

        toshiba.addChannel();
        assertEquals(1, toshiba.getChannels().size());

        String channel = toshiba.displayChannel(1);
        assertEquals("Displaying Channel 1", channel);

    }

    @Test
    public void displayChannelTen_channelTenIsDisplayedTest() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());

        String channel = toshiba.displayChannel(10);

        assertEquals("Displaying Channel 10", channel);
    }

    @Test
    public void displayNonPositiveChannelNumber_exceptionIsThrownTest() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());

        assertThrows(IllegalArgumentException.class, ()-> toshiba.displayChannel(0));
        assertThrows(IllegalArgumentException.class, ()-> toshiba.displayChannel(-5));
    }

    @Test
    public void displayChannelGreaterThanNoOfChannels_exceptionIsThrownTest() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());

        assertThrows(IllegalArgumentException.class, ()-> toshiba.displayChannel(11));
        assertThrows(IllegalArgumentException.class, ()-> toshiba.displayChannel(25));
    }

    @Test
    public void changeChannelForwardAt3_channelIs4Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 6; count++) toshiba.addChannel();
        assertEquals(6, toshiba.getChannels().size());
        assertEquals("Displaying Channel 3", toshiba.displayChannel(3));
        assertEquals(3, toshiba.getCurrentChannel());

        toshiba.changeChannel(true);

        assertEquals(4, toshiba.getCurrentChannel());
        assertEquals("Displaying Channel 4", toshiba.displayChannel());
    }

    @Test
    public void changeChannelBackwardAt8_channelIs7Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());
        assertEquals("Displaying Channel 8", toshiba.displayChannel(8));
        assertEquals(8, toshiba.getCurrentChannel());

        toshiba.changeChannel( false);

        assertEquals(7, toshiba.getCurrentChannel());
        assertEquals("Displaying Channel 7", toshiba.displayChannel());
    }
    @Test
    public void changeChannelForwardAt7_channelIs7Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 7; count++) toshiba.addChannel();
        assertEquals(7, toshiba.getChannels().size());
        assertEquals("Displaying Channel 7", toshiba.displayChannel(7));
        assertEquals(7, toshiba.getCurrentChannel());

        toshiba.changeChannel(true);

        assertNotEquals(8, toshiba.getCurrentChannel());
        assertEquals("Displaying Channel 7", toshiba.displayChannel());
    }

    @Test
    public void changeChannelBackwardAt1_channelIs1Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());
        assertEquals("Displaying Channel 1", toshiba.displayChannel(1));

        toshiba.changeChannel( false);

        assertEquals(1, toshiba.getCurrentChannel());
        assertEquals("Displaying Channel 1", toshiba.displayChannel());
    }

    @Test
    public void increaseVolumeAt25_tvVolumeIs26Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        assertEquals(25, toshiba.getTvVolume());

        toshiba.increaseVolume();

        assertEquals(26, toshiba.getTvVolume());
    }

    @Test
    public void decreaseVolumeAt87_tvVolumeIs86Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        assertEquals(25, toshiba.getTvVolume());
        for (int count = 0; count < 62; count++) toshiba.increaseVolume();
        assertEquals(87, toshiba.getTvVolume());

        toshiba.decreaseVolume();

        assertEquals(86, toshiba.getTvVolume());
    }
    @Test
    public void increaseVolumeAt100_tvVolumeIs100Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        assertEquals(25, toshiba.getTvVolume());
        for (int count = 0; count < 75; count++) toshiba.increaseVolume();
        assertEquals(100, toshiba.getTvVolume());

        toshiba.increaseVolume();

        assertNotEquals(101, toshiba.getTvVolume());
    }

    @Test
    public void decreaseVolumeAt0_tvVolumeIs0Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        assertEquals(25, toshiba.getTvVolume());
        for (int count = 25; count > 0; count--) toshiba.decreaseVolume();
        assertEquals(0, toshiba.getTvVolume());

        toshiba.decreaseVolume();

        assertNotEquals(-1, toshiba.getTvVolume());
    }
}