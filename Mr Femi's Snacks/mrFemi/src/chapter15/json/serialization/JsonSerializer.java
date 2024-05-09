package mrFemi.chapter15.json.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
