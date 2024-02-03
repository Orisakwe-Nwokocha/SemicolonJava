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
    public void changeChannelNumberForwardAt5_channelNumberIs6Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 6; count++) toshiba.addChannel();
        assertEquals(6, toshiba.getChannels().size());
        assertEquals("Displaying Channel 5", toshiba.displayChannel(5));

        toshiba.changeChannel(5, true);

        assertEquals("Displaying Channel 6", toshiba.displayChannel(6));
    }

    @Test
    public void changeChannelNumberBackwardAt4_channelNumberIs3Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        for (int count = 0; count < 10; count++) toshiba.addChannel();
        assertEquals(10, toshiba.getChannels().size());
        assertEquals("Displaying Channel 4", toshiba.displayChannel(4));

        toshiba.changeChannel(4, false);

        assertEquals("Displaying Channel 3", toshiba.displayChannel(3));
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
    public void decreaseVolumeAt25_tvVolumeIs24Test() {
        assertFalse(toshiba.isOn());
        toshiba.toggle();
        assertTrue(toshiba.isOn());
        assertEquals(25, toshiba.getTvVolume());

        toshiba.increaseVolume();

        assertEquals(26, toshiba.getTvVolume());
    }
}