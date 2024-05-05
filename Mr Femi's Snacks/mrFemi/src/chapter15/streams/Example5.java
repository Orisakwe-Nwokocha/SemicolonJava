package mrFemi.chapter15.streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example5 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        char[] fileChars = new char[1024];
        try (FileReader fileReader = new FileReader(location)) {
            int numberOfCharactersRead = fileReader.read(fileChars);
            System.out.println(new String(fileChars, 0, numberOfCharactersRead));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
