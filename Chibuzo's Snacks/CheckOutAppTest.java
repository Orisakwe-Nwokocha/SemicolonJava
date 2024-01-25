import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckOutAppTest {

    @Test
    public void getCurrentDateAndTime() {
        String currentDateAndTime =  CheckOutApp.getCurrentDateAndTime();
        boolean isValidDateAndTimeRange = isDateInRange(currentDateAndTime, "25-Jan-24 08:12:00", "25-Jan-24 08:13:00");
        
        assertTrue(isValidDateAndTimeRange);
    }

    private boolean isDateInRange(String currentDateAndTime, String startRange, String endRange) {
        
        return currentDateAndTime.compareTo(startRange) >= 0 && currentDateAndTime.compareTo(endRange) <= 0;
    }

    @Test
    public void getCustomerName() {
        CheckOutApp.setCustomerName("Orisha c19");
        assertEquals("Orisha c19", CheckOutApp.getCustomerName());
    }

    @Test
    public void getCashierName() {
        CheckOutApp.setCashierName("Semicolon Africa 2023");
        assertEquals("Semicolon Africa 2023", CheckOutApp.getCashierName());
    }

    @Test
    public void getSubTotal() {
        CheckOutApp.setSubTotal(2343.00);
        assertEquals(2343.0, CheckOutApp.getSubTotal());

    }

    @Test
    public void getDiscount() {
        CheckOutApp.setDiscount(-15.0);
        assertEquals(0.0, CheckOutApp.getDiscount());
    }

    @Test
    public void getDiscountedTotal() {
        CheckOutApp.setSubTotal(5300);
        CheckOutApp.setDiscount(8);
        assertEquals(424.0, CheckOutApp.getDiscountedTotal());
    }

    @Test
    public void getVAT() {
        CheckOutApp.setSubTotal(5300);
        assertEquals(397.5, CheckOutApp.getVAT());
    }

    @Test
    public void getBillTotal() {
        CheckOutApp.setSubTotal(5300);
        CheckOutApp.setDiscount(8);
        assertEquals(5273.5, CheckOutApp.getBillTotal());
    }

    @Test
    public void getAmountPaid() {
        CheckOutApp.setAmountPaid(6000);
        assertEquals(6000.00, CheckOutApp.getAmountPaid());
    }

    @Test
    public void getBalance() {
        CheckOutApp.setSubTotal(5300);
        CheckOutApp.setDiscount(8);
        CheckOutApp.setAmountPaid(5273.50);

        assertEquals(0, CheckOutApp.getBalance());
    }
}
