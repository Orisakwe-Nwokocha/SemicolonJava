import java.util.Scanner;
public class ParkingCharges {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int customer1, customer2, customer3;

        while (true) {
            System.out.print("Enter hour(s) parked for customer 1: ");
            customer1 = input.nextInt();
            while (customer1 <= 0) {
                System.out.println("Invalid input");
                System.out.print("Enter valid hour(s) parked: ");
                customer1 = input.nextInt();
            }

            System.out.print("Enter hour(s) parked for customer 2: ");
            customer2 = input.nextInt();
            while (customer2 <= 0) {
                System.out.println("Invalid input");
                System.out.print("Enter valid hour(s) parked: ");
                customer2 = input.nextInt();
            }

            System.out.print("Enter hour(s) parked for customer 3: ");
            customer3 = input.nextInt();
            while (customer3 <= 0) {
                System.out.println("Invalid input");
                System.out.print("Enter valid hour(s) parked: ");
                customer3 = input.nextInt();
            }
            break;
        }

        double totalChargesOfTheDay =  calculateCharges(customer1) +  calculateCharges(customer2) +  calculateCharges(customer3);

        System.out.printf("%nThe parking charge for customer 1 is $%.2f%n",  calculateCharges(customer1));
        System.out.printf("%nThe parking charge for customer 2 is $%.2f%n",  calculateCharges(customer2));
        System.out.printf("%nThe parking charge for customer 3 is $%.2f%n",  calculateCharges(customer3));
        System.out.printf("%nThe running total of the day’s receipt is $%.2f%n",  totalChargesOfTheDay);
    }

    public static double calculateCharges(int hours){
        double charges = 0.0;
        if (hours >= 1 && hours <= 3){charges = 2.00;}
        else if (hours >= 24) {charges = 10.00;}
        else if (hours > 3 && hours < 24){charges = ((hours - 3) * 0.50) + 2.00;}

        return charges;
    }
}