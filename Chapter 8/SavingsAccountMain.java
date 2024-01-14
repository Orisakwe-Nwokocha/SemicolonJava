public class SavingsAccountMain {
    public static void main(String... ori) {
    
    SavingsAccount saver1;
    SavingsAccount saver2;
    try {
        saver1 = new SavingsAccount(2000.00);
        saver2 = new SavingsAccount(3000.00);
    } catch (IllegalArgumentException e) {
              System.out.printf("Exception while initializing saver: %s%n", e.getMessage());
              return;
      } 
    
    SavingsAccount.modifyInterestRate(4);
    System.out.printf("%nInitial savings balance with %.0f%s interest rate:%n", SavingsAccount.getAnnualInterestRate(), "%"); 
    displayOutput("Saver 1", saver1, 12);
    displayOutput("Saver 2", saver2, 12);
    
    SavingsAccount.modifyInterestRate(5);    
    System.out.printf("%nSavings balance after interest rate modification of %.0f%s:%n", SavingsAccount.getAnnualInterestRate(), "%");
    displayOutput("Saver 1", saver1, 1);
    displayOutput("Saver 2", saver2, 1);
    
    }
    
    private static void displayOutput(String header, SavingsAccount saver, int noOfMonths) {
        for (int month = 1; month <= noOfMonths; month++) {
            saver.calculateMonthlyInterest();
        }
        
        System.out.printf("%s%n    New balance: %.2f%n", header, saver.getSavingsBalance());
    }

}