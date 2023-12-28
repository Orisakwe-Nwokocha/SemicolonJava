import java.security.SecureRandom;
import java.util.Scanner;

public class Craps {
    private static final SecureRandom randomNumbers = new SecureRandom();

    private enum Status {CONTINUE, WON, LOST}

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int myPoint = 0;
        Status gameStatus;

        double bankBalance = 1000.0;
        System.out.println("Enter a wager:");
        double wager = input.nextInt();
        while (wager < 0.0 || wager > bankBalance) {
            System.out.println("Wager is not valid\nPlease enter a valid wager:");
            wager = input.nextInt();
        }
        System.out.println();

        int sumOfDice = rollDice();

        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("Point is %d%n", myPoint);
        }

        while (gameStatus == Status.CONTINUE) {
            System.out.println(getChatter() + "\n");
            sumOfDice = rollDice();


            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else if (sumOfDice == SEVEN) {
                gameStatus = Status.LOST;
            }

        }

        if (gameStatus == Status.WON) {
            System.out.println("\nPlayer wins");

            bankBalance +=  wager;
            System.out.printf("Your balance is: $%.2f%n", bankBalance);
        }
        else {
            System.out.println("\nPlayer loses");

            bankBalance -=  wager;
            System.out.printf("Your balance is: $%.2f%n", bankBalance);

            if (bankBalance == 0) {
                System.out.println("Sorry. You busted!");
            }
        }
    }

    public static int rollDice() {
        int die1 = randomNumbers.nextInt(1, 7);
        int die2 = randomNumbers.nextInt(1, 7);

        int sum = die1 + die2;

        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

        return sum;
    }

    public static String getChatter() {
        String chatter = null;
        int chatterNumber = randomNumbers.nextInt(1, 11);

        switch (chatterNumber) {
            case 1 -> chatter = "You are getting warmer";
            case 2 -> chatter = "You wish you were close :)";
            case 3 -> chatter = "Oga, nothing for you";
            case 4 -> chatter = "You sef don try";
            case 5 -> chatter = "Lottery is not your thing";
            case 6 -> chatter = "Better go find work, madam";
            case 7 -> chatter = "Keep going";
            case 8 -> chatter = "Oh, you're going for broke, huh?";
            case 9 -> chatter = "Aw c'mon, take a chance!";
            case 10 -> chatter = "You're up big. Now's the time to cash in your chips!";
        }

        return chatter;
    }
}
