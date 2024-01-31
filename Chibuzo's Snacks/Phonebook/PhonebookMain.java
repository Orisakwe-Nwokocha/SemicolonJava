import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookMain {
    private static Scanner input = new Scanner(System.in);
    private static Phonebook nokiaPhonebook = new Phonebook();

    public static void main(String[] args) {
        nokiaPhonebook.addContact("Orisha", "2348035729982");
        nokiaPhonebook.addContact("Ajiri", "08023456789");
        nokiaPhonebook.addContact("Izu", "08029853637");

        System.out.println("Type <Ctrl> z then press Enter to terminate the program at any point\n");
        displayPhonebookMenu();

    }

    private static void displayPhonebookMenu() {
        System.out.print("""
                1. Search
                2. View contacts
                3. Add contact
                4. Edit
                5. Erase
                
                Select an option:
                """);
        String userChoice = input.next();
        input.nextLine();

        switch (userChoice) {
            case "1" -> search();
            case "2" -> viewContacts();
            case "3" -> addContact();
//            case "4" -> search();
//            case "5" -> search();
            default -> displayPhonebookMenu();
        }

    }

    private static void search() {
        System.out.println("\nSearch contact by name:");
        String contactName = input.nextLine();

        String contactInfo = nokiaPhonebook.searchContact(contactName);
        System.out.println("\n" + contactInfo);

        System.out.println();
        displayPhonebookMenu();
    }

    private static void viewContacts() {
        ArrayList<Contact> contacts = nokiaPhonebook.getContacts();
        StringBuilder allContacts = new StringBuilder();

        System.out.println();

        for (Contact contact : contacts) {
            allContacts.append(contact).append("\n\n");
        }

        if (allContacts.isEmpty()) System.out.println("No contact found");
        else System.out.println(allContacts.toString());

        System.out.println();
        displayPhonebookMenu();
    }

    private static void addContact() {
        System.out.println("\nEnter contact name:");

        String contactName = input.nextLine();

        System.out.println("Enter contact phone number:");
        String phoneNumber = input.nextLine();

        nokiaPhonebook.addContact(contactName, phoneNumber);

        System.out.println();
        displayPhonebookMenu();
    }
}
