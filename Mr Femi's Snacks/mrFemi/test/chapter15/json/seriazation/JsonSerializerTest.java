package mrFemi.chapter15.json.seriazation;

import org.junit.jupiter.api.Test;

import static mrFemi.chapter15.json.seriazation.JsonSerializer.serialize;
import static mrFemi.chapter15.json.seriazation.Sex.SHIM;
import static org.junit.jupiter.api.Assertions.*;

public class JsonSerializerTest {
    @Test
    public void testJsonSerializer() {
        Person person = new Person();
        person.setName("Bob");
        person.setDateOfBirth("2024-03-03");
        person.setGender(SHIM);
        person.setPhoneNumber("08023578906");

        String json = serialize(person);
        String expected = "{\"name\":\"Bob\",\"dateOfBirth\":\"2024-03-03\",\"gender\":\"SHIM\",\"phoneNumber\":\"08023578906\"}";
        assertEquals(expected, json);
    }
}