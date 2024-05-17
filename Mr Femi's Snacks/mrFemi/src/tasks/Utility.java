package mrFemi.tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mrFemi.chapter15.json.serialization.JsonSerializer;
import mrFemi.chapter15.json.serialization.transactions.Transactions;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Character.isWhitespace;

public class Utility {
    public static void main(String[] args) {
        String location = "C:\\Users\\User\\Videos\\Transactions.json";
        System.out.println(sum(location));
        System.out.println(total(location));
    }

    public static BigDecimal total(String location) {
        List<Transactions> transactions = getTransactions(location);
        BigDecimal sum = BigDecimal.ZERO;

        for (Transactions transaction : transactions) sum = sum.add(transaction.getAmount());
        return sum;
    }

    private static List<Transactions> getTransactions(String location) {
        String file = getWords(location);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return List.of(objectMapper.readValue(file, Transactions[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    public static BigDecimal sum(String location) {
        List<String> data = getJsons(location);

        List<Transactions> transactions = new ArrayList<>();
        for (String object : data) {
            Transactions transaction = JsonSerializer.deSerializeTransactions(object);
            transactions.add(transaction);
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (Transactions transaction : transactions) sum = sum.add(transaction.getAmount());
        return sum;
    }

    private static List<String> getJsons(String location) {
        String contents = new String(getFile(location));
        List<String> jsons = new ArrayList<>();
        StringBuilder json = new StringBuilder();

        for (int index = 0; index < contents.length(); index++) {
            if (contents.charAt(index) == '[' || contents.charAt(index) == ']') continue;
            json.append(contents.charAt(index));

            if (json.toString().equals("},")) json = new StringBuilder();

            if (contents.charAt(index) == '}') {
                jsons.add(json.toString().trim());
                json = new StringBuilder("}");
            }
        }

        return jsons;
    }

    private static byte[] getFile(String location) {
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

        return dataFile;
    }


    public static int countNumberOfDigitsOf(String location) {
        String words = getWords(location);

        int counter = 0;
        for (char character : words.toCharArray()) if (isDigit(character)) counter++;
        return counter;
    }

    public static int countNumberOfSentencesOf(String location) {
        String words = getWords(location);
        words = words.replaceAll("\\d\\.\\d", "a");
        String[] split = words.split("[A-z0-9]\\.");
        return split.length;
    }

    public static int countNumberOfParagraphsOf(String location) {
        String words = getWords(location);
        words = words.trim();
        if (words.isBlank()) return 0;

        String[] split = words.split("\n");

        int counter = 1;
        for (String s : split) {
            if (s.length() > 1) s = s.trim();
            if (isWhitespace(s.charAt(0))) counter++;
        }

        return counter;
    }

    private static String getWords(String location) {
        Path path = Paths.get(location);
        String words = "";

        try {
            words = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
