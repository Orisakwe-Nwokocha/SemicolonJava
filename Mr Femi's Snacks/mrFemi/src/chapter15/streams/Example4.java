package mrFemi.chapter15.streams;

import java.io.*;

public class Example4 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        try(FileOutputStream fileOutputStream = new FileOutputStream(location, true)) {
            String data = "\nGo Placidly amid the noise and haste, and remember what peace there may be in silence";
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }

    }
}
