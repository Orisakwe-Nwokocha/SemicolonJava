package mrFemi.chapter15.streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example10 {
    public static void main(String[] args) throws IOException {
        String location = "C:\\Users\\DELL\\Videos\\works2.txt";
        Path path = Paths.get(location);

        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Happy Birthday, Bolaji.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        /*
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.write("Happy Birthday, Bolaji.");
        writer.close();
        */

    }
}
