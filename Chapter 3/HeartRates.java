public class HeartRates {
	private String firstName;
	private String lastName;
	private int dobMonth;
	private int dobDay;
	private int dobYear;
	
	public HeartRates() {

	}

	public HeartRates(String firstName, String lastName, int dobMonth, int dobDay, int dobYear) {
		this.firstName = firstName;
		this.lastName = lastName;
	
		if (dobMonth > 0) {
			this.dobMonth = dobMonth;
		}
		
		if (dobDay > 0) {
			this.dobDay = dobDay;
		}

		if (dobYear > 0) {
			this.dobYear = dobYear;
		}

	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
	 	return firstName;
	}

	public void setLastName(String lastName) {
	  	this.lastName = lastName;
	}
	
	public String getLastName() {
	  	return lastName;
	}

	public void setDobMonth(int dobMonth) {
	  this.dobMonth = dobMonth;
	}

	public int getDobMonth() {
	  return dobMonth;
	}

	public void setDobDay(int dobDay) {
	  this.dobDay = dobDay;
	}

	public int getDobDay() {
	  return dobDay;
	}

	public void setDobYear(int dobYear) {
	  this.dobYear = dobYear;
	}

	public int getDobYear() {
	  return dobYear;
	}

	public int getAge() {
		int userAge = 2023 - dobYear;
		return userAge;
	}

	
	public int getMaxHeartRate() {
		int maxHeartRate = 220 - getAge();
		return maxHeartRate;
	}

	
	public double getLowHeartRate() {		
		double lowTargetHeartRate = getMaxHeartRate() * 0.50;
		return lowTargetHeartRate;
	}

	public double getHighHeartRate() {		
		double highTargetHeartRate = getMaxHeartRate() * 0.85;
		return highTargetHeartRate;
	}




}