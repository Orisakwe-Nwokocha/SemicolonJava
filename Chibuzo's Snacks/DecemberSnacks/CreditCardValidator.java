public class CreditCardValidator {
    private String cardNumber;
    private String cardType;

    public void setCardNumber(String cardNumber) {
        validate(cardNumber);

        this.cardNumber = cardNumber;
    }

    private static void validate(String cardNumber) {
        boolean isDigit = cardNumber.matches("\\d+");
        if (!isDigit) throw new IllegalArgumentException("Invalid input");

        boolean isOutOfRange = cardNumber.length() < 13 || cardNumber.length() > 16;
        if (isOutOfRange) throw new IllegalArgumentException("Card number length must be between 13 and 16");
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
    
    public int[] convertToArray(){
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

        for (int index = convertToArray().length - 2; index >= 0; index -= 2) {
            int doubleEverySecondDigit = convertToArray()[index] * 2;
            if (doubleEverySecondDigit > 9) doubleEverySecondDigit = 1 + doubleEverySecondDigit % 10;

            sum += doubleEverySecondDigit;
        }

        return sum;
    }
    
    public int getOddPositionsSum() {
        int sum = 0;
        for (int index = convertToArray().length - 1; index >= 0; index -= 2) sum += convertToArray()[index];

        return sum;
    }
    
    public String getCardValidityStatus() {
        int result = getEvenPositionsSum() + getOddPositionsSum();

        if (cardType.equals("Invalid card")) return "Invalid";
        else if (result % 10 == 0) return "Valid";

        return "Invalid";
    }

    public String output() {
        return String.format("%n***********************************************" +
                "%n**Credit Card Type: %s" +
                "%n**Credit Card Number: %s" +
                "%n**Credit Digit Length: %d" +
                "%n**Credit Card Validity Status: %s" +
                "%n***********************************************%n",
                getCardType(), getCardNumber(),
                getCardDigitLength(), getCardValidityStatus());
    }

}
