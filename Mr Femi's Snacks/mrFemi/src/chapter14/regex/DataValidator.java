package mrFemi.chapter14.regex;

public class DataValidator {
    public static boolean isPhoneNumberValid(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll(" ", "");
        String regex = "((234|\\+234)-?|0)?(70|[8-9][0-1])\\d{8}";
        return phoneNumber.matches(regex);
    }

    public static boolean isEmailValid(String email) {
        email = email.toLowerCase();
        String regex = "([a-z]\\.)?[a-z]+@(enum|learnspace|semicolon|native.semicolon).africa";
        return email.matches(regex);
    }

    public static boolean isTelephoneValid(String telephone) {
        String regex = "^1?((\\(\\d{3}\\))|\\d{3})-?\\d{3}-?[0-9]{4}$";
        telephone = telephone.replaceAll(" ", "");
        return telephone.matches(regex);
    }
}
