package transactionOperations;

import json.serialization.transaction.Transaction;
import json.serialization.transaction.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static json.serialization.transaction.Type.CREDIT;
import static utils.Utility.getTransactions;
import static java.math.RoundingMode.HALF_EVEN;


public class TransactionOperations {
//    private static final String location = "C:\\Users\\DELL\\Videos\\Transactions.json";
    private static final String location = "C:\\Users\\DELL\\IdeaProjects\\LambdasAndStreams\\src\\Transactions.json";

    public static void main(String[] args) {
        System.out.println(getTransactions(location));
        BigDecimal a = new BigDecimal("48000.00");
        BigDecimal b = new BigDecimal("-"+"3700.50");
        System.out.println(a.add(b));
//        System.out.println(getTransactionsFor("2024-04-16", "2024-05-16"));
    }

    public static List<Transaction> getTransactionsFor(String date) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Error parsing date: " + e.getMessage());
        }

        List<Transaction> transactions = getTransactions(location);
        LocalDate finalLocalDate = localDate;

        return transactions.stream()
                .filter((transaction) -> transaction.getDate().equals(finalLocalDate))
                .toList();
    }

    public static List<Transaction> getTransactionsFor(String startDate, String endDate) {
        LocalDate start;
        LocalDate end;
        try {
            start = LocalDate.parse(startDate);
            end = LocalDate.parse(endDate);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Error parsing date: " + e.getMessage());
        }

        List<Transaction> transactions = getTransactions(location);
        LocalDate finalStartDate = start;
        LocalDate finalEndDate = end;

        return transactions.stream()
                .filter((transaction) -> !transaction.getDate().isBefore(finalStartDate)
                            && !transaction.getDate().isAfter(finalEndDate))
                .toList();
    }

    public static BigDecimal getAverageTransactionAmount(String startDate, String endDate) {
        List<Transaction> transactions = getTransactionsFor(startDate, endDate);

        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(transactions.size()),  2, HALF_EVEN);
    }

    public static AccountSummary getAccountSummary(int id) {
        var transactions = getTransactions(location);
        var accountLedger = transactions.stream().filter((transaction) -> transaction.getId() == id).toList();

        BigDecimal balance = accountLedger.stream()
                .map(TransactionOperations::getBigDecimal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        String name = accountLedger.getFirst().getName();
        Long transactionCount = (long) accountLedger.size();

        return new AccountSummary(name, balance, transactionCount);
    }

    private static BigDecimal getBigDecimal(Transaction transaction) {
        return transaction.getType().equals(CREDIT)
                ? new BigDecimal(transaction.getAmount().toString())
                : new BigDecimal("-" + transaction.getAmount().toString());
    }
}
