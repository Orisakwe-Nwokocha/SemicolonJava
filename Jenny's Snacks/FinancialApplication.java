public class FinancialApplication {
	private int loanAmount;
	private int years;
	private double interestRate;
	
	public FinancialApplication(){
	}
	public FinancialApplication(int loanAmount, int years, double interestRate) {

		if (loanAmount > 0) {
			this.loanAmount = loanAmount;
		}
		if (loanAmount <= 0) {
			this.loanAmount = 0;
		}	
		this.years = years;
		this.interestRate = interestRate;
	}	

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getLoanAmount() {
		return loanAmount;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public int getYears() {
		return years;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = interestRate / 1200;
		return monthlyInterestRate;
	}

	public double getMonthlyInterest() {
		double monthlyInterest = getMonthlyInterestRate() * loanAmount;
		return monthlyInterest;
	}

	public double getMonthlyPayment() {
		double monthlyPayment = (getMonthlyInterest() * (Math.pow((1 + getMonthlyInterestRate()), (years * 12)))) / (Math.pow((1 + getMonthlyInterestRate()), (years * 12)) - 1);
		return monthlyPayment;
	}
	


}