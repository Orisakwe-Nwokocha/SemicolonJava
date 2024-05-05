package mrFemi.chapter15.json.seriazation;

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
}
