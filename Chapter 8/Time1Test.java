public class Time1Test {
    public static void main(String... orisha){
        Time1 time = new Time1();
        try {
            time.setTime(23, 50, 30);
        }
        catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        } 

        displayTime("The time represented in two formats", time);
        
     //   System.out.println(time1.toUniversalString());
       //  System.out.println(time1.toString());
    }
    
     private static void displayTime(String header, Time1 t) {
         System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n", header, t.toUniversalString(), t.toString());
    }
    
    

}