public class AutoPolicy {
	private int accountNumber; 
	private String makeAndModel; 
	private String state; 


 	public AutoPolicy(int accountNumber, String makeAndModel, String state) {
 		this.accountNumber = accountNumber;
 		this.makeAndModel = makeAndModel;
 		this.state = state;
 	}


	 public void setAccountNumber(int accountNumber) {
 		this.accountNumber = accountNumber;
 	}

	public int getAccountNumber() {
 		return accountNumber;
 	}

 	public void setMakeAndModel(String makeAndModel) {
 		this.makeAndModel = makeAndModel;
 	}

 	public String getMakeAndModel() {
 		return makeAndModel;
	 }

 	public void setState(String state) {
		if (state.equalsIgnoreCase("MA") || state.equalsIgnoreCase("NJ") || state.equalsIgnoreCase("NY") || state.equalsIgnoreCase("PA") || state.equalsIgnoreCase("CT") || state.equalsIgnoreCase("ME") || state.equalsIgnoreCase("NH") || state.equalsIgnoreCase("VT")) {
		 this.state = state;
		} 
		
		else { 
			this.state = state;
			System.out.printf("Error: State code %s is not valid!!!%n%n", getState());
		}
		
 	}

	public String getState() {
 		return state;
 	}

	public boolean isNoFaultState() {
		boolean noFaultState;

		switch (getState()) {
			 case "MA": case "NJ": case "NY": case "PA":
 				noFaultState = true;
				break;
 			default:
 				noFaultState = false;
 				break; 
		}

 		return noFaultState;
 	}
}