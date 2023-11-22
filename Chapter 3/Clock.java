public class Clock {
	private int hour;
	private int minute;	
	private int second;
	
	public Clock(int hour, int minute, int second) {	
		if (hour <= 23) {		
			this.hour = hour;
		}
		
		if (minute <= 59) {		
			this.minute = minute;
		}
		
		if (second <= 59) {		
			this.second = second;
		}					
	}
	
	public void setHour(int hour) {
		if (hour > 23) {		
			this.hour = 0;
		}
		else {
			this.hour = hour;
		}
	}
	
	public int getHour() {
		return hour;
	}

	public void setMinute(int minute) {
		if (minute > 59) {		
			this.minute = 0;
		}
		else {
			this.minute = minute;
		}
	}
	
	public int getMinute() {
		return minute;
	}

	public void setSecond(int second) {
		if (second > 59) {		
			this.second = 0;
		}
		else {
			this.second = second;
		}

	}

	public int getSecond() {
		return second;
	}

	public String displayTime() {
	  	String display = ("The time is " + hour + ":" + minute + ":" + second);
		return display;
	}


 	
} 