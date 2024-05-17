package mrFemi.chapter15.json.serialization.transactions;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {

    public static double sum(String location) {
        byte[] dataFile = new byte[0];

        try(InputStream inputStream = new FileInputStream(location);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
        )
        {
            dataFile = dataInputStream.readAllBytes();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
        String contents = new String(dataFile);

        List<String> data = new ArrayList<>();
        String obj = "";
        for (int index = 0; index < contents.length(); index++) {
            if (contents.charAt(index) == '[' || contents.charAt(index) == ']') continue;
            obj += contents.charAt(index);
            if (contents.charAt(index) == '}') {
                data.add(obj.trim());
                obj = "";
            }
        }
        System.out.println(data);

//        System.out.println(data);
        return 0;
    }

    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\Videos\\Transactions.json";
        System.out.println(sum(location));
    }
}
