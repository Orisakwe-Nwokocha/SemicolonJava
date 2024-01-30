import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

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
        nokiaPhonebook.addContact("Ajiri", "2348095327891");
        nokiaPhonebook.addContact("Orisha", "2348035729982");
        nokiaPhonebook.addContact("", "08023456789");

        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        assertNotEquals(1,contacts.size());
    }

    @Test
    public void testThatPhonebookCanModifyContactName() {
        nokiaPhonebook.addContact("Orisha", "2348035729982");
        nokiaPhonebook.addContact("", "08023456789");

        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        contacts.get(0).setContactName("Orisakwe Nwokocha");
        contacts.get(1).setContactName("placeholder#");

        assertEquals("Orisakwe Nwokocha", contacts.get(0).getContactName());
        assertEquals("placeholder#", contacts.get(1).getContactName());
    }

    @Test
    public void testThatPhonebookCanModifyContactPhoneNumber() {
        nokiaPhonebook.addContact("Orisha", "2348035729982");

        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        contacts.getFirst().setPhoneNumber("08125358910");

        assertEquals("08125358910", contacts.getFirst().getPhoneNumber());
    }

    @Test
    public void testThatPhonebookCanOnlyAcceptDigits() {
        assertThrows(InputMismatchException.class, () -> nokiaPhonebook.addContact("Orisha", "080357S29982"));

        nokiaPhonebook.addContact("temp", "1234");
        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        assertThrows(InputMismatchException.class, () -> contacts.getFirst().setPhoneNumber("08035O29982"));
    }

    @Test
    public void testThatPhonebookCanEraseContact() {
        nokiaPhonebook.addContact("Orisha", "2348035729982");
        nokiaPhonebook.addContact("", "08023456789");

        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();

        nokiaPhonebook.eraseContact("Orisha");

        assertNotEquals(2, contacts.size());
    }


}
