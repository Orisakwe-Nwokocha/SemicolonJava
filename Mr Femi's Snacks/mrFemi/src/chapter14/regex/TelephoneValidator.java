package mrFemi.chapter14.regex;

public class TelephoneValidator {
    public static void main(String[] args) {
        System.out.println(validate("1 555-555-5555"));
    }

    public static boolean validate(String telephone) {
        String regex = "^1?((\\(\\d{3}\\))|\\d{3})-?\\d{3}-?[0-9]{4}$";
        telephone = telephone.replaceAll(" ", "");
        return telephone.matches(regex);
    }
}
