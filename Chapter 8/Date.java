public class Date {
    private int month; 
    private int day;     
    private int year; 

    private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");
        }
        
        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }
        
        if (month == 2 && day == 29 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        }
        
        if (year <= 0) {
            throw new IllegalArgumentException("year (" + year + ") must be a positive number");
        }
    
        this.month = month;
        this.day = day;
        this.year = year;
        
        System.out.printf("Date object constructor for date %s%n", this);
    }
    
    public void nextDay() {
        day++;
        if (day > daysPerMonth[month] && !(month == 2 && day == 29)) {
            day = 1;
            month++;
            
            if (month > 12) {
                month = 1;
                year++;              
            }
        }
        
        if (month == 2 && day >= 29 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            day = 1;
            month++;
            
            if (month > 12) {
                month = 1;
                year++;              
            }        
        }
    }
    
    public int getDay() {return day;}

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}