package mrFemi.chapter15.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Example1 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        try(FileOutputStream fileOutputStream = new FileOutputStream(location, true);
            PrintStream printStream = new PrintStream(fileOutputStream)) {
            printStream.println("Hello World");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
