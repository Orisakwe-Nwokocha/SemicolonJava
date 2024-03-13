import java.util.Scanner;

public class CreditCardValidatorMain {
    public static void main(String[] args) {
        CreditCardValidator creditCardValidator = new CreditCardValidator();
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, Kindly Enter Card details to verify:");
        String cardNumber = input.nextLine().replaceAll(" ", "");

        try {
            creditCardValidator.setCardNumber(cardNumber);
            creditCardValidator.setCardType(creditCardValidator.getCardNumber());

            System.out.println(creditCardValidator.output());
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            main(args);
        }

        input.close();
    }
}
