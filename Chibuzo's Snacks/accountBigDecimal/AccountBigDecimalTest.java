package accountBigDecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

public class AccountBigDecimalTest {

    @Test
    public void deposit10k_balanceIs10kTest() {
        AccountBigDecimal account = new AccountBigDecimal();
        account.deposit(10_000);

        BigDecimal expected = BigDecimal.valueOf(10_000.00);

        assertEquals(expected, account.getBalance());
    }

    @Test
    public void deposit10kTwice_balanceIs20kTest() {
        AccountBigDecimal account = new AccountBigDecimal();
        account.deposit(10_000);
        account.deposit(10_000);

        BigDecimal expected = BigDecimal.valueOf(20_000.00);

        assertEquals(expected, account.getBalance());
    }

    @Test
    public void deposit10kTwice_withdraw7k_balanceIs13kTest() {
        AccountBigDecimal account = new AccountBigDecimal();
        account.deposit(10_000);
        account.deposit(10_000);
        account.withdraw(7_000);

        BigDecimal expected = BigDecimal.valueOf(13_000.00);

        assertEquals(expected, account.getBalance());
    }
}