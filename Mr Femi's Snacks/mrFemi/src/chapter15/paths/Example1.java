package mrFemi.chapter15.paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws IOException {
        String location = "C:\\Users\\DELL\\Downloads\\Video\\Ninja Kamui\\";
        Path path = Path.of(location);
       try {
           Files.createFile(path);
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
//        Files.write(path, "Hello World".getBytes());
//        Files.deleteIfExists(path);
//        System.out.println(Files.readAllLines(path));

       try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
//           directoryStream.forEach(System.out::println);
//           directoryStream.forEach(System.out::println);
           directoryStream.forEach(d -> {
               if (Files.isDirectory(d)) System.out.println(d.getFileName().toString());;
           });
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }

       /*
        * create
        *
        */



    }
}
