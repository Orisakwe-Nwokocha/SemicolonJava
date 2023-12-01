import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinancialApplicationMainTest {
    private FinancialApplication financialApplication;

    @Test
    public void getLoanAmountTest() {
        financialApplication = new FinancialApplication();
        financialApplication.setLoanAmount(10000);
        assertEquals(10000, financialApplication.getLoanAmount());
    }

    @Test
    public void getYearsTest(){
        financialApplication = new FinancialApplication();
        financialApplication.setYears(1);
        assertEquals(1, financialApplication.getYears());
    }

    @Test
    public void getInterestRate(){
        financialApplication = new FinancialApplication();
        financialApplication.setInterestRate(7);
        assertEquals(7, financialApplication.getInterestRate());
    }

    @Test
    public void getMonthlyInterestRate(){
        financialApplication = new FinancialApplication();
        financialApplication.setInterestRate(7);
        assertEquals(0.005833333333333334, financialApplication.getMonthlyInterestRate());
    }

    @Test
    public void getMonthlyInterest(){
        financialApplication = new FinancialApplication();
        financialApplication.setInterestRate(7);
        financialApplication.setLoanAmount(10000);
        assertEquals(58.333333333333336, financialApplication.getMonthlyInterest());
    }

    @Test
    public void getMonthlyPayment(){
        financialApplication = new FinancialApplication();
        financialApplication.setLoanAmount(10000);
        financialApplication.setYears(1);
        financialApplication.setInterestRate(7);
        assertEquals(865.2674609813781, financialApplication.getMonthlyPayment());
    }

}