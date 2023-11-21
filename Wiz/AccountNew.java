public class AccountNew {
	private int id;
	private double balance;
	private double annualInterestRate;
	private String dateCreated;
	
	public AccountNew() {
	
	}

	public AccountNew(int id, double balance, double annualInterestRate, String dateCreated) {
		this.id = 0;
		this.balance = 0.0;	
	}
	
	public void setId(int id) {
		if (id > 0) 
			this.id = id;
	}
	
	public void setBalance(double balance) {
		if (balance > 0.0) 
			this.balance = balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate > 0.0) 
			this.annualInterestRate = annualInterestRate;
	}

	
	public int getId() {
		return id;
	}
		
	public double getBalance() {
		return balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}

	public String getDateCreated() {
		return dateCreated;
	}


	public double getMonthlyInterestRate() {
		double interestRate = annualInterestRate / 1200;
		return interestRate;
	}

	public double getMonthlyInterest() {
		double monthlyInterest = balance * getMonthlyInterestRate();
		return monthlyInterest;
	}

	
	public void withdraw(double withdrawalAmount) {
		if (withdrawalAmount <= balance) {
			balance = balance - withdrawalAmount;
			System.out.printf("Withdraw successful%n");
		}	
		
		if (withdrawalAmount > balance) {
			balance = balance;
			System.out.printf("%nWithdrawal amount exceeded account balance.%n");
		}
	}

	public void deposit(double depositAmount) {
		if (depositAmount > 0.0) 
			balance = balance + depositAmount;
	}




}