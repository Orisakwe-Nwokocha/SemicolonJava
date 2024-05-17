package mrFemi.chapter15.json.serialization;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static mrFemi.chapter15.json.serialization.JsonSerializer.deSerialize;
import static mrFemi.chapter15.json.serialization.JsonSerializer.serialize;
import static mrFemi.chapter15.json.serialization.Sex.MALE;
import static mrFemi.chapter15.json.serialization.Sex.SHIM;
import static org.junit.jupiter.api.Assertions.*;

public class JsonSerializerTest {
    @Test
    public void testJsonSerializer() {
        Person person = new Person();
        person.setName("Bob");
        LocalDate dateOfBirth = LocalDate.of(2024, 3, 3);
        person.setDateOfBirth(dateOfBirth);
        person.setGender(SHIM);
        person.setPhoneNumber("08023578906");

        String json = serialize(person);
        String expected = "{\"name\":\"Bob\",\"gender\":\"SHIM\",\"phoneNumber\":\"08023578906\",\"dob\":[2024,3,3]}";
        assertEquals(expected, json);
    }

    @Test
    public void testDeserialize() {
        Person person = new Person();
        person.setName("John");
        LocalDate dateOfBirth = LocalDate.of(2024, 3, 3);
        person.setDateOfBirth(dateOfBirth);
        person.setGender(MALE);
        person.setPhoneNumber("08023578906");

        System.out.println("person as a java object: " + person);

        String json = serialize(person);
        System.out.println("json: " + json);
        Person personFromJson = deSerialize(json);
        System.out.println("person from json: " + personFromJson);

        assertNotNull(personFromJson);
        assertEquals(person.getDateOfBirth(), personFromJson.getDateOfBirth());
        assertEquals(MALE, personFromJson.getGender());
        assertEquals("John", personFromJson.getName());
        assertEquals("08023578906", personFromJson.getPhoneNumber());
    }
}