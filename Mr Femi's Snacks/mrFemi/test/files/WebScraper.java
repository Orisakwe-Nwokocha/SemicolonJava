package files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WebScraper {
    public static void main(String[] args) {
        try {
            String location = "https://www.google.com/";
            URL url = new URL(location);
            InputStream inputStream = url.openStream();

            byte[] bytes = inputStream.readAllBytes();


            for (byte data : bytes) System.out.print(Character.toString(data));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
