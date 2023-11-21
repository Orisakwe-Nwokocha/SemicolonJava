public class Account {
	private String name;
	private double balance;

	public Account(String name, double balance) {
		this.name = name;

		if (balance > 0.0) {
			this.balance = balance;
		}	
	}
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0.0) 
			balance = balance + depositAmount;
	}


	public void withdraw(double withdrawalAmount) {
		if (withdrawalAmount <= balance) {
			balance = balance - withdrawalAmount;
		}	
		
		if (withdrawalAmount > balance) {
			balance = balance;
			System.out.printf("%nWithdrawal amount exceeded account balance.%n");
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