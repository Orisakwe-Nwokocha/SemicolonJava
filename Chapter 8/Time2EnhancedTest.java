public class Time2EnhancedTest {
    public static void main(String[] args) {
        Time2Enhanced t1 = new Time2Enhanced(); // 00:00:00
        Time2Enhanced t2 = new Time2Enhanced(2); // 02:00:00
        Time2Enhanced t3 = new Time2Enhanced(21, 34); // 21:34:00
        Time2Enhanced t4 = new Time2Enhanced(12, 25, 42); // 12:25:42
        Time2Enhanced t5 = new Time2Enhanced(t4); // 12:25:42 
        
        System.out.println("Constructed with:");
        displayTime("t1: all default arguments", t1);
        displayTime("t2: hour specified; default minute and second", t2);
        displayTime("t3: hour and minute specified; default second", t3);
        displayTime("t4: hour, minute and second specified", t4);
        displayTime("t5: Time2Enhanced object t4 specified", t5);

        try {
            Time2Enhanced t6 = new Time2Enhanced(27, 74, 99); // invalid values
            displayTime("t6: all invalid arguments", t6);
        }
        catch (IllegalArgumentException e) {
            System.out.printf("%nException while initializing t6: %s%n%n", e.getMessage());
        }
        
        Time2Enhanced t7 = new Time2Enhanced(22, 58, 59); // 12:25:42
        
        displayTime("t7: hour, minute and second specified", t7);
            
        t7.incrementMinute();    
        displayTime("t7: incrementing into the next minute", t7);    

        t7.incrementHour();        
        displayTime("t7: incrementing into the next hour", t7);
            
        t7.tick();        
        displayTime("t7: incrementing into the next day via incrementing the second", t7);    
          
        
    }
    
    private static void displayTime(String header, Time2Enhanced t) {
        System.out.printf("%s%n    %s%n    %s%n    Number of seconds since midnight: %d%n", header, t.toUniversalString(), t.toString(), t.getSecondsSinceMidnight());
    }
}