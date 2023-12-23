import java.util.Arrays;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int x = 21;
        int y = 252;

        System.out.println("This is Euclidean algorithm using recursion: " + gcd(x, y));
        System.out.println("This is Euclidean algorithm using a normal loop: " + gcd(x, y));
        System.out.println("This is my own logic, applying brute force principles: " + gcdBruteForce(x, y));

    }
    public static int gcd(int firstNumber, int secondNumber) {
        //GCD(a,b)=GCD(b,amodb)
        if (secondNumber == 0) {
            return firstNumber;
        }
        else {
             return gcd(secondNumber, firstNumber % secondNumber);
        }
    }

    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int placeholder = num2;
            num2 = num1 % num2;
            num1 = placeholder;
        }
        return num1;
    }

    public static int gcdBruteForce(int firstNumber, int secondNumber) {
        int lengthCounter1 = 0;
        int lengthCounter2 = 0;

        for (int i = firstNumber; i >= 1; i--) {
            if (firstNumber % i == 0) {
                lengthCounter1++;
            }
        }

        for (int i = 1; i <= secondNumber; i++) {
            if (secondNumber % i == 0) {
                lengthCounter2++;
            }
        }

        int gcdFoundBruteForce = 0;

        if (secondNumber == 0) {
            return firstNumber;
        }
        else if (firstNumber == 0) {
            return secondNumber;
        }

        else {
            int[] firstArray = new int[lengthCounter1];
            int[] secondArray = new int[lengthCounter2];
            int count = 0;
            int counter = 0;

            for (int i = firstNumber; i >= 1; i--) {
                if (firstNumber % i == 0) {
                    firstArray[count] = i;
                    count++;
                }
            }

            for (int i = 1; i <= secondNumber; i++) {
                if (secondNumber % i == 0) {
                    secondArray[counter] = i;
                    counter++;
                }
            }

            for (int index : firstArray) {
                gcdFoundBruteForce = index;

                for (int loop : secondArray) {
                    if (gcdFoundBruteForce == loop) {
                        return gcdFoundBruteForce;
                    }

                }
            }
        }
        return gcdFoundBruteForce;
    }
}
