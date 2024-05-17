package mrFemi.chapter15.streams;

import java.io.*;

public class Example6 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        try (FileWriter fileWriter = new FileWriter(location, true)) {
           fileWriter.write("\nInvest your money wisely, don't buy bone-straight");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
