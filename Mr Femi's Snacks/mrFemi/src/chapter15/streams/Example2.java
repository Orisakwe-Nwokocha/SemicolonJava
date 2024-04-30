package mrFemi.chapter15.streams;

import java.io.IOException;
import java.io.PrintStream;

public class Example2 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";

        try(PrintStream printStream = new PrintStream(location)) {
            System.out.println("Hello World: sout");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
