package accountBigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountBigDecimal {
    private ArrayList<Transactions> successfulTransactions;

    public AccountBigDecimal() {
        successfulTransactions = new ArrayList<>();;
    }

    public void deposit(double amount) {
        validateDeposit(amount);

        Transactions deposit = new Transactions(TransactionType.CREDIT, BigDecimal.valueOf(amount));

        successfulTransactions.add(deposit);
    }

    private static void validateDeposit(double depositAmount) {
        boolean depositAmountIsInvalid = depositAmount <= 0;

        if (depositAmountIsInvalid) throw new IllegalArgumentException("Deposit amount must be greater than zero");
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);

        Transactions withdraw = new Transactions(TransactionType.DEBIT, BigDecimal.valueOf(amount));

        successfulTransactions.add(withdraw);
    }

    private void validateWithdraw(double withdrawAmount) {
        boolean withdrawAmountIsInvalid = withdrawAmount <= 0 ||
                BigDecimal.valueOf(withdrawAmount).compareTo(getBalance()) > 0;

        if (withdrawAmountIsInvalid) throw new IllegalArgumentException("Withdrawal amount is not valid");
    }

    public BigDecimal getBalance() {
        BigDecimal currentBalance = BigDecimal.ZERO;

        for (Transactions transactions : successfulTransactions) {
            switch (transactions.type()) {
                case DEBIT, TRANSFER_OUT -> currentBalance = currentBalance.subtract(transactions.value());
                case CREDIT, TRANSFER_IN -> currentBalance = currentBalance.add(transactions.value());
            }
        }

        return currentBalance;
    }
}
