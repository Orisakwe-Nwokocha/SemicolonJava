import java.util.ArrayList;
import java.util.Comparator;

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
        contacts.removeIf(contact -> contact.getContactName().equals(contactName));
    }

    public String searchContact(String contactName) {
        StringBuilder contactInfo = new StringBuilder();

        for (Contact contact : contacts) if (contact.getContactName().equalsIgnoreCase(contactName)) contactInfo.append(contact).append("\n");

        if (contactInfo.isEmpty()) return "No contact found";
        return contactInfo.toString();
    }

    public String viewContacts() {
        StringBuilder allContacts = new StringBuilder();

        contacts.sort(Comparator.comparing(Contact::toString));

        for (Contact contact : contacts) allContacts.append(contact).append("\n\n");

        if (allContacts.isEmpty()) return "Phonebook is empty";
        return allContacts.toString();
    }

    public void editContactName(String contactName, String newName) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equals(contactName)) {
                contact.setContactName(newName);
                break;
            }
        }
    }

    public void editContactPhoneNumber(String contactName, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equals(contactName)) {
                contact.setPhoneNumber(newNumber);
                break;
            }
        }
    }

    public void editContact(String contactName, String newName, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getContactName().equals(contactName)) {
                contact.setContactName(newName);
                contact.setPhoneNumber(newNumber);
                break;
            }
        }
    }

}
