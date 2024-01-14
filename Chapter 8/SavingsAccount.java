public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;
    
    public SavingsAccount() {
        this(0.0);
    }
    
    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial savings balance must be a non-negative number");
        
        this.savingsBalance = initialBalance;
    }
    
    public static void modifyInterestRate(double annualInterestRate) {
        if (annualInterestRate < 0 || annualInterestRate > 100) throw new IllegalArgumentException("Annual interest rate must be between 0 and 100");
        
        SavingsAccount.annualInterestRate = annualInterestRate;
    }
    
    public void setSavingsBalance(double newSavingsBalance) {
        if (newSavingsBalance < 0) throw new IllegalArgumentException("Savings balance must be a non-negative number");
        
        this.savingsBalance = newSavingsBalance;
    }
    
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }    
      
    public void calculateMonthlyInterest() {
        savingsBalance += (savingsBalance * getAnnualInterestRate()) / 1200;
    }
    
    public double getSavingsBalance() {
        return savingsBalance;
    }  

}