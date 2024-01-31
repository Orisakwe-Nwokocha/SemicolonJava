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

    public String searchContact(String contactName) {
        StringBuilder contactInfo = new StringBuilder();

        for (Contact contact : contacts) {
            if (contact.getContactName().equalsIgnoreCase(contactName)) contactInfo.append(contact).append("\n");
        }

        if (contactInfo.isEmpty()) return "Phonebook is empty";
        return contactInfo.toString();
    }

}
