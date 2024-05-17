package mrFemi.chapter15.streams;

import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Example9 {
    public static void main(String[] args) {
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter) ) {
            writer.write("Hello guys, it's break time and everyone is gonna eat");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

//        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
//                 ) {
//            String text = "Hello guys, it's break time and everyone is gonna eat";
//            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
////            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter, text.length());
//            bufferedWriter.write(text);
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            System.err.println("Error: " + e.getMessage());
//        }
    }
}
