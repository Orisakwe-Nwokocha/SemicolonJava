package transactionOperations;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;
import static transactionOperations.TransactionOperations.*;

public class TransactionOperationsTest {

    @Test
    public void testGetTransactionsFor() {
        var transactions = getTransactionsFor("2024-05-16");

        assertNotNull(transactions);
        assertEquals(3, transactions.size());
    }

    @Test
    public void testGetTransactionsFor_startAndEndDates() {
        var transactions = getTransactionsFor("2024-04-16", "2024-05-16");

        assertNotNull(transactions);
        assertEquals(4, transactions.size());
    }

    @Test
    public void testGetAverageTransactionAmount() {
        var actual = getAverageTransactionAmount("2024-04-16", "2024-05-16");

        System.out.println(actual);
        assertNotNull(actual);
        assertEquals(new BigDecimal("16500.00"), actual);
    }

    @Test
    public void testGetAccountSummary() {
        AccountSummary actual = getAccountSummary(5);
        AccountSummary expected = new AccountSummary(
                "Jean Gray",
                new BigDecimal("44299.50"),
                2L
                );

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}