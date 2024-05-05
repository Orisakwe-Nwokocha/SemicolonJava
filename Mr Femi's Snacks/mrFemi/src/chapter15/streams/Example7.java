package mrFemi.chapter15.streams;

import java.io.*;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\works.txt";
        try(FileInputStream fileInputStream = new FileInputStream(location);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
