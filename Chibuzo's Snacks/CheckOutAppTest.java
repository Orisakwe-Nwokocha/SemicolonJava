import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckOutAppTest {
    private CheckOutApp checkOutApp;

    @BeforeEach
    public void startWith() {
        checkOutApp = new CheckOutApp();
    }

    @Test
    public void getCustomerName() {
        checkOutApp.setCustomerName("Orisha c19");
        assertEquals("Orisha c19", checkOutApp.getCustomerName());
    }

    @Test
    public void getCashierName() {
        checkOutApp.setCashierName("Semicolon Africa 2023");
        assertEquals("Semicolon Africa 2023", checkOutApp.getCashierName());
    }

    @Test
    public void getSubTotal() {
        checkOutApp.setSubTotal(2343.00);
        assertEquals(2343.0, checkOutApp.getSubTotal());

    }

    @Test
    public void getDiscount() {
        checkOutApp.setDiscount(-15.0);
        assertEquals(0.0, checkOutApp.getDiscount());
    }

    @Test
    public void getDiscountedTotal() {
        checkOutApp.setSubTotal(5300);
        checkOutApp.setDiscount(8);
        assertEquals(424.0, checkOutApp.getDiscountedTotal());
    }

    @Test
    public void getVAT() {
        checkOutApp.setSubTotal(5300);
        assertEquals(397.5, checkOutApp.getVAT());
    }

    @Test
    public void getBillTotal() {
        checkOutApp.setSubTotal(5300);
        checkOutApp.setDiscount(8);
        assertEquals(5273.5, checkOutApp.getBillTotal());
    }

    @Test
    public void getAmountPaid() {
        checkOutApp.setAmountPaid(6000);
        assertEquals(6000.00, checkOutApp.getAmountPaid());
    }

    @Test
    public void getBalance() {
        checkOutApp.setSubTotal(5300);
        checkOutApp.setDiscount(8);
        checkOutApp.setAmountPaid(5273.50);

        assertEquals(0, checkOutApp.getBalance());
    }
}