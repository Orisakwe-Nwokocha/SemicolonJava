public class AccountModified {
	private String name;
	private double balance;

	public AccountModified(String name, double balance) {
		this.name = name;

		if (balance > 0.0) {
			this.balance = balance;
		}
		if (balance <= 0.0) {
			this.balance = 0.0;
		}	
	}
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0.0) { 
			balance = balance + depositAmount;
		}
	
		else {
			System.out.printf("%nDeposit amount invalid!%n%n");
			balance = balance;		
		}
	}

	public void withdraw(double withdrawalAmount) {
		if (withdrawalAmount <= balance) {
			balance = balance - withdrawalAmount;
		}	
		
		else {
			System.out.printf("%nWithdrawal amount exceeded account balance!%n%n");
			balance = balance;		
		} 
	}
	
	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}



}