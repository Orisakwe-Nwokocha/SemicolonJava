import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhonebookTest {
    private Phonebook nokiaPhonebook;

    @BeforeEach
    public void setUp() {
        nokiaPhonebook = new Phonebook();
    }

    @Test
    public void testThatPhonebookExists() {
        assertNotNull(nokiaPhonebook);
    }

    @Test
    public void testThatPhonebookCanContainMultipleContacts() {
        nokiaPhonebook.addContact("Ajiri", "234 809 532 7891");
        nokiaPhonebook.addContact("Orisha", "234 803 572 9982");
        nokiaPhonebook.addContact("", "08023456789");

        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        System.out.println(contacts);

        assertNotEquals(1,contacts.size());
    }

    @Test
    public void testThatPhonebookCanAddContacts() {

    }


}
