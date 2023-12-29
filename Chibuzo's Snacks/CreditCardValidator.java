import java.util.Scanner;

public class CreditCardValidator {
    private static final Scanner input = new Scanner(System.in);
    private String cardNumber;
    private String cardType;

    public static void main(String[] args) {
        CreditCardValidator creditCardValidator = new CreditCardValidator();

        System.out.println("Hello, Kindly Enter Card details to verify");
        String cardDetails = input.nextLine();

        creditCardValidator.setCardNumber(cardDetails);
        creditCardValidator.setCardType(creditCardValidator.getCardNumber());

        sampleOutput(creditCardValidator);
    }

    public void setCardNumber(String cardNumber) {
        while (cardNumber.length() < 13 || cardNumber.length() > 16) {
            System.out.println("Invalid Card Number!\nPlease enter a valid number: ");
            cardNumber = input.nextLine();
        }
        
        this.cardNumber = cardNumber;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public int getCardDigitLength() {
        return cardNumber.length();
    }
    
    public void setCardType(String creditCardNumber) {
        if (creditCardNumber.charAt(0) == '4') {
            cardType = "Visa Cards";
        }
        else if (creditCardNumber.charAt(0) == '5') {
            cardType = "MasterCard";
        }
        else if (creditCardNumber.charAt(0) == '6') {
            cardType = "Discover Cards";
        }
        else if (creditCardNumber.charAt(0) == '3' && creditCardNumber.charAt(1) == '7') {
            cardType = "American Express Cards";
        }
        else {
            cardType = "Invalid card";
        }
    }
    
    public String getCardType() {
        return cardType;
    }
    
    public int[] getCreditCardDigitsArray(){
        long creditCardNumber = Long.parseLong(cardNumber);
        int[] newArray = new int[getCardDigitLength()];

        for(int index = newArray.length - 1; index >= 0; index--){
            newArray[index] = (int) (creditCardNumber % 10);
            creditCardNumber = creditCardNumber / 10;
        }
        return newArray;
    }
    
    public int getEvenPositionsSum() {
        int sum = 0;
        int doubleEverySecondDigit = 0;

        for (int index = getCreditCardDigitsArray().length - 2; index >= 0; index -= 2) {
            doubleEverySecondDigit = getCreditCardDigitsArray()[index] * 2;

            if (doubleEverySecondDigit > 9) {
                int firstDigit = doubleEverySecondDigit % 10;
                int secondDigit = doubleEverySecondDigit / 10;
                doubleEverySecondDigit = firstDigit + secondDigit;
            }
            sum += doubleEverySecondDigit;
        }

        return sum;
    }
    
    public int getOddPositionsSum() {
        int sum = 0;

        for (int index = getCreditCardDigitsArray().length - 1; index >= 0; index -= 2) {
            sum += getCreditCardDigitsArray()[index];
        }

        return sum;
    }
    
    public String getCardValidityStatus() {
        int result = getEvenPositionsSum() + getOddPositionsSum();
        String cardValidityStatus;

        if (cardType.equals("Invalid card")) {
            cardValidityStatus = "Invalid";
        }
        else if (result % 10 == 0) {
            cardValidityStatus = "Valid";
        }
        else {
            cardValidityStatus = "Invalid";
        }

       return cardValidityStatus;
    }

    public static void sampleOutput(CreditCardValidator objectName) {
        System.out.printf("%n***********************************************" +
                "%n**Credit Card Type: %s" +
                "%n**Credit Card Number: %s" +
                "%n**Credit Digit Length: %d" +
                "%n**Credit Card Validity Status: %s" +
                "%n***********************************************%n",
                objectName.getCardType(), objectName.getCardNumber(),
                objectName.getCardDigitLength(), objectName.getCardValidityStatus());
    }

}
