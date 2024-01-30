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

    public void eraseContact(String contactName) {
        for (int index = 0; index < contacts.size(); index++) {
            if (contacts.get(index).getContactName().equals(contactName)) {
                contacts.remove(index);
                break;
            }
        }
    }

    public String displayPhonebookMenu() {
        return """
                1. Search
                2. View contacts
                3. Add name
                4. Edit
                5. Erase
                """;
    }

    public String
}
