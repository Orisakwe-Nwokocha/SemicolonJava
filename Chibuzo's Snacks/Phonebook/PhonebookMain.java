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
                Phonebook
                
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
            case "4" -> edit();
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
        System.out.println();

        System.out.println(nokiaPhonebook.viewContacts());
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

    private static void edit() {
        String allContacts = nokiaPhonebook.viewContacts();

        if (allContacts.equals("Phonebook is empty")) System.out.println("Phonebook is empty");

        else {
            System.out.println(allContacts);

            System.out.println("Enter contact you want to edit:");
            String contactName = input.nextLine();

            System.out.println(nokiaPhonebook.searchContact(contactName));

            System.out.println("Type 1 to edit contact name or Type 2 to edit contact number or Type 3 to edit both");
            String userChoice = input.nextLine();
            while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3")) {
                System.out.println("Invalid input\n" +
                        "Type 1 to edit contact name or Type 2 to edit contact number or Type 3 to edit both");
                userChoice = input.nextLine();
            }


            if (userChoice.equals("1")) {
                System.out.printf("Enter new name for %s:%n", contactName);
                String newName = input.nextLine();
                nokiaPhonebook.editContactName(contactName, newName);
            }

            else if (userChoice.equals("2")) {
                System.out.printf("Enter new phone number for %s:%n", contactName);
                String newPhoneNumber = input.nextLine();
                nokiaPhonebook.editContactPhoneNumber(contactName, newPhoneNumber);
            }

            else {
                System.out.printf("Enter new name for %s:%n", contactName);
                String newName = input.nextLine();
                System.out.printf("Enter new phone number for %s:%n", contactName);
                String newPhoneNumber = input.nextLine();

                nokiaPhonebook.editContact(contactName, newName, newPhoneNumber);
            }
        }
        System.out.println();
        displayPhonebookMenu();
    }
}
