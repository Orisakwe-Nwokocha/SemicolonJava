package account;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountBigDecimal {
    private ArrayList<Transactions> successfulTransactions;

    public AccountBigDecimal() {
        successfulTransactions = new ArrayList<>();;
    }

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) throw new IllegalArgumentException("Deposit amount must be greater than zero");

        Transactions deposit = new Transactions("CREDIT", BigDecimal.valueOf(depositAmount));
        successfulTransactions.add(deposit);
    }
    public void withdraw(double withdrawAmount) {

        boolean withdrawAmountIsNotValid = withdrawAmount <= 0 ||
                BigDecimal.valueOf(withdrawAmount).compareTo(getBalance()) > 0;

        if (withdrawAmountIsNotValid) throw new IllegalArgumentException("Withdrawal amount is not valid");

        Transactions withdraw = new Transactions("DEBIT", BigDecimal.valueOf(withdrawAmount));
        successfulTransactions.add(withdraw);

    }
    public BigDecimal getBalance() {
        BigDecimal currentBalance = BigDecimal.ZERO;

        for (Transactions transactions : successfulTransactions) {
            switch (transactions.name()) {
                case "DEBIT" -> currentBalance = currentBalance.subtract(transactions.value());
                case "CREDIT" -> currentBalance = currentBalance.add(transactions.value());
            }
        }
        return currentBalance;
    }
}
