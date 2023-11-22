public class HealthProfile {
	private String firstName;
	private String lastName;
	private String gender;
	private int dobMonth;
	private int dobDay;
	private int dobYear;
	private double weight;
	private double height;
	
	public HealthProfile() {

	}

	public HealthProfile(String firstName, String lastName, String gender, int dobMonth, int dobDay, int dobYear, double weight, double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	
		if (dobMonth > 0) {
			this.dobMonth = dobMonth;
		}
		
		if (dobDay > 0) {
			this.dobDay = dobDay;
		}

		if (dobYear > 0) {
			this.dobYear = dobYear;
		}

		if (weight > 0.0) {
			this.weight = weight;
		}

		if (height > 0.0) {
			this.height = height;
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

	public void setGender(String gender) {
	  	this.gender = gender;
	}
	
	public String getGender() {
	  	return gender;
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

	public void setWeight(double weight) {
	  this.weight = weight;
	}

	public double getWeight() {
	  return weight;
	}

	public void setHeight(double height) {
	  this.height = height;
	}

	public double getHeight() {
	  return height;
	}

	public int getAge() {
		int userAge = 2023 - dobYear;
		return userAge;
	}
	
	public int getMaxHeartRate() {
		int maxHeartRate = 220 - getAge();
		return maxHeartRate;
	}

	public void targetHeartRate() {
		double lowTargetHeartRate = getMaxHeartRate() * 0.50;		
		double highTargetHeartRate = getMaxHeartRate() * 0.85;
		System.out.printf("%nThe maximum heart rate and target heart rate range for user %s %s of %d years is:%n%nMaximum heart rate: %d%nTarget heart rate range: low %.1f - %.1f high beats per minute%n", firstName, lastName, getAge(), getMaxHeartRate(), lowTargetHeartRate, highTargetHeartRate);		
		
	}
	
	public void bmi() {
		double bmiResult = (weight * 703) / (height * height);

		if (bmiResult < 18.5)
        		System.out.printf("Your BMI is %.1f, indicating Underweight!!!%n", bmiResult);
		if (bmiResult >= 18.5 && bmiResult < 25)
        		System.out.printf("Your BMI is %.1f, indicating Normal weight!!!%n", bmiResult);
		if (bmiResult >= 25 && bmiResult < 30)
        		System.out.printf("Your BMI is %.1f, indicating Overweight!!!%n", bmiResult);
		if (bmiResult >= 30)
        		System.out.printf("Your BMI is %.1f, indicating Obesity!!!%n", bmiResult);

	}



}