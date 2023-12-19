import java.util.Scanner;
public class RecursionSample {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        userInput(number);
    }

    public static void userInput(int input2){
        switch(input2){
            case 1: System.out.println("one"); break;
            case 2: System.out.println("two"); break;
            case 3: System.out.println("three"); break;
            default:
                System.out.println("Invalid");
                System.out.print("Enter a valid number: ");
                input2 = input.nextInt();
                userInput(input2);
        }
    }
}
