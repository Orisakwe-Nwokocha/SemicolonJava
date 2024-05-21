package json.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.serialization.transaction.Transaction;

public class JsonSerializer {

    public static String serialize(Person person) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing person: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Person deSerialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Transaction deSerializeTransactions(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Transaction.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
