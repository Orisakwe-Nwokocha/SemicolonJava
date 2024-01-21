import java.security.SecureRandom;
import java.util.Scanner;

public class AirlineReservationsSystem {
    private static final Scanner input = new Scanner(System.in);
    private static final SecureRandom randomNumbers = new SecureRandom();
    private final boolean[] seatingChart = new boolean[11];
    private static final int[] seatValidation = new int[11];

    private boolean getSeatingChart(int index) {
        return seatingChart[index];
    }
    private static int getSeatValidation(int index) {
        return seatValidation[index];
    }
    public void airlineReservationsSystem() {
        int seatSection = collectUserInput();
        int seatNo = getSeatNo(seatSection);
        System.out.println(checkSeatAvailability(seatSection, seatNo));
    }

    public int collectUserInput() {
        System.out.println("Please type 1 for First Class and Please type 2 for Economy:");
        String userInput = input.next();

        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("Seat section provided is not valid");
        }
        else return Integer.parseInt(userInput);
    }

    public int getSeatNo(int seatSection) {
        return switch (seatSection) {
            case 1 -> randomNumbers.nextInt(1, 6);
            case 2 -> randomNumbers.nextInt(6, 11);
            default -> throw new IllegalArgumentException("Seat section provided is not valid");
        };
    }

    private String checkSeatAvailability(int seatSection, int seatNo) {
        if (seatingChart[1] && seatingChart[2] && seatingChart[3] && seatingChart[4] && seatingChart[5]
            && seatingChart[6] && seatingChart[7] && seatingChart[8] && seatingChart[9] && seatingChart[10]) {

            return "\nThe plane is fully booked. Next flight leaves in 3 hours.";
        }
        else if (seatSection == 1 && seatingChart[1] && seatingChart[2] && seatingChart[3]
                && seatingChart[4] && seatingChart[5]) {
            System.out.println("\nFirst-class section is fully booked. " +
                    "Is it acceptable to be placed in the economy section? (y/n)");
            String userChoice = input.next().toLowerCase();

            if (userChoice.equals("y")) return getBoardingPass(2, seatNo);
            else return "Next flight leaves in 3 hours.";
        }
        else if (seatSection == 2 && seatingChart[6] && seatingChart[7] && seatingChart[8] && seatingChart[9] && seatingChart[10]) {
            System.out.println("\nEconomy section is fully booked." +
                    "Is it acceptable to be placed in the first-class section? (y/n)");
            String userChoice = input.next().toLowerCase();

            if (userChoice.equals("y")) return getBoardingPass(1, seatNo);
            else return "Next flight leaves in 3 hours.";
        }
        else return getBoardingPass(seatSection, seatNo);
    }

    private String getBoardingPass(int seatSection, int seatNo) {
        while (seatNo == getSeatValidation(seatNo)) {
            seatNo = getSeatNo(seatSection);
        }

        seatingChart[seatNo] = true;
        seatValidation[seatNo] = seatNo;

        return String.format("Your seat number is %d%nYour plane section is %s%n", seatNo,
                                    (seatSection == 1 ? "First Class" : "Economy"));
    }

}
