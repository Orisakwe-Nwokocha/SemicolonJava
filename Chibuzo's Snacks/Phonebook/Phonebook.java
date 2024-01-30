import java.util.ArrayList;

public class Phonebook {
    private final ArrayList<Contact> contacts;

    public Phonebook() {
        contacts = new ArrayList<>();
    }

    public void addContact(String contactName, String phoneNumber) {
        Contact contact = new Contact(contactName, phoneNumber);
        contacts.add(contact);
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
