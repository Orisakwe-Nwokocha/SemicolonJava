package logisticsServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogisticsServicesTest {

    @Test
    public void given25SuccessfulDeliveries_whenCalculated_thenRidersWageIs9000() {
        assertEquals(9_000, LogisticsServices.calculateRidersWage(25));
    }

    @Test
    public void given49SuccessfulDeliveries_whenCalculated_thenRidersWageIs12840() {
        assertEquals(12_840, LogisticsServices.calculateRidersWage(49));
    }

    @Test
    public void given50SuccessfulDeliveries_whenCalculated_thenRidersWageIs15000() {
        assertEquals(15_000, LogisticsServices.calculateRidersWage(50));
    }

    @Test
    public void given55SuccessfulDeliveries_whenCalculated_thenRidersWageIs16000() {
        assertEquals(16_000, LogisticsServices.calculateRidersWage(55));
    }

    @Test
    public void given60SuccessfulDeliveries_whenCalculated_thenRidersWageIs20000() {
        assertEquals(20_000, LogisticsServices.calculateRidersWage(60));
    }

    @Test
    public void given65SuccessfulDeliveries_whenCalculated_thenRidersWageIs21250() {
        assertEquals(21_250, LogisticsServices.calculateRidersWage(65));
    }

    @Test
    public void given70SuccessfulDeliveries_whenCalculated_thenRidersWageIs40000() {
        assertEquals(40_000, LogisticsServices.calculateRidersWage(70));
    }

    @Test
    public void given80SuccessfulDeliveries_whenCalculated_thenRidersWageIs45000() {
        assertEquals(45_000, LogisticsServices.calculateRidersWage(80));
    }

    @Test
    public void given0SuccessfulDeliveries_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> LogisticsServices.calculateRidersWage(0));
    }

    @Test
    public void given101SuccessfulDeliveries_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> LogisticsServices.calculateRidersWage(101));
    }
}