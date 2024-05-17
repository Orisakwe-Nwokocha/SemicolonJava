package mrFemi.chapter15.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Example8 {
    public static void main(String[] args) {
        try(InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            System.out.println("Enter a text: ");
            System.out.println("You entered: " + bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
