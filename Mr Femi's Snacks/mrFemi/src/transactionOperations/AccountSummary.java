package transactionOperations;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountSummary {
    private String name;
    private BigDecimal balance;
    private Long transactionCount;

    public AccountSummary(String name, BigDecimal balance, Long transactionCount) {
        this.name = name;
        this.balance = balance;
        this.transactionCount = transactionCount;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", transactionCount=" + transactionCount +
                '}';
    }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof AccountSummary accountSummary)
                &&  this.name.equals(accountSummary.name)
                && this.balance.equals(accountSummary.balance)
                && this.transactionCount.equals(accountSummary.transactionCount);
   }

}
