package mrFemi.chapter14.regex;

public class Scheduler {
    public static void main(String[] args) {
        String regex = "(1[0-2]|(0?[1-9])):[0-5][0-9] PM";
        String time = "10:59 PM";
        boolean result = time.matches(regex);
        System.out.println(result);
    }
}
