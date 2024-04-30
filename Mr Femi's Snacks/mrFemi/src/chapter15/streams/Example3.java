package mrFemi.chapter15.streams;

import java.io.*;
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        try(InputStream inputStream = new FileInputStream(location);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            )
        {
            byte[] dataFile = dataInputStream.readAllBytes();
            System.out.println(new String(dataFile));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }

    }
}
