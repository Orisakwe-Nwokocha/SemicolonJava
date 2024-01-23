public class DateTest {
    public static void main(String... args) {
        try {
            Date d1 = new Date(1, 1, 2024);
            displayDate(d1);
            
            for (int day = 1; day <= 425; day++) {         
                d1.nextDay();        
                displayDate(d1);
            }               
        }
        
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void displayDate(Date date) {
        System.out.printf("%nDate: %s%nDay: %d%n", date, date.getDay());
    }
}