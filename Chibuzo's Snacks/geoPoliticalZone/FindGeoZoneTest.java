package geoPoliticalZone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindGeoZoneTest {


    @Test
    public void givenStateLagos_whenQueried_thenLagosIsSouthWest() {
        assertEquals(GeoPoliticalZone.SOUTH_WEST, FindGeoZone.findGeoZone("Lagos"));
    }

}