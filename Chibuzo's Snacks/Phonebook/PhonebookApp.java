import java.util.InputMismatchException;
import java.util.Scanner;

public class PhonebookApp {
    private static Scanner input = new Scanner(System.in);

    public static void startApp(Phonebook nokiaPhonebook) {
       displayPhonebookMenu(nokiaPhonebook);
/*        search(nokiaPhonebook);
        viewContacts(nokiaPhonebook);
        addContact(nokiaPhonebook);
        edit(nokiaPhonebook);
        erase(nokiaPhonebook);*/

    }
    private static void displayPhonebookMenu(Phonebook nokiaPhonebook) {
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
            case "1" -> search(nokiaPhonebook);
            case "2" -> viewContacts(nokiaPhonebook);
            case "3" -> addContact(nokiaPhonebook);
            case "4" -> edit(nokiaPhonebook);
            case "5" -> erase(nokiaPhonebook);
            default -> displayPhonebookMenu(nokiaPhonebook);
        }

    }

    private static void search(Phonebook nokiaPhonebook) {
        System.out.println("\nSearch contact by name:");
        String contactName = input.nextLine();

        String contactInfo = nokiaPhonebook.searchContact(contactName);
        System.out.println("\n" + contactInfo);

        System.out.println("Type 0 to go back to the main menu or Enter any key to end program");
        String userChoice = input.nextLine();

        if (userChoice.equals("0")){
            System.out.println();
            displayPhonebookMenu(nokiaPhonebook);
        }
    }

    private static void viewContacts(Phonebook nokiaPhonebook) {
        System.out.println();

        System.out.println(nokiaPhonebook.viewContacts());

        System.out.println("Type 0 to go back to the main menu or Enter any key to end program");
        String userChoice = input.nextLine();

        if (userChoice.equals("0")){
            System.out.println();
            displayPhonebookMenu(nokiaPhonebook);
        }
    }

    private static void addContact(Phonebook nokiaPhonebook) {
        System.out.println("\nEnter contact name:");

        String contactName = input.nextLine();

        System.out.println("Enter contact phone number:");
        String phoneNumber = input.nextLine();

        try {
            nokiaPhonebook.addContact(contactName, phoneNumber);
            System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nType 0 to go back to the main menu or Enter any key to end program");
        String userChoice = input.nextLine();

        if (userChoice.equals("0")){
            System.out.println();
            displayPhonebookMenu(nokiaPhonebook);
        }
    }

    private static void edit(Phonebook nokiaPhonebook) {
        String allContacts = nokiaPhonebook.viewContacts();

        if (allContacts.equals("Phonebook is empty")) System.out.println("Phonebook is empty");

        else {
            System.out.println("\n" + allContacts);

            System.out.println("Enter contact you want to edit:");
            String contactName = input.nextLine();

            String contactInfo = nokiaPhonebook.searchContact(contactName);

            if (contactInfo.equals("No contact found")) System.out.println(contactInfo);

            else {
                System.out.println(contactInfo);

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
                    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

                } else if (userChoice.equals("2")) {
                    System.out.printf("Enter new phone number for %s:%n", contactName);
                    String newPhoneNumber = input.nextLine();
                    nokiaPhonebook.editContactPhoneNumber(contactName, newPhoneNumber);
                    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

                } else {
                    System.out.printf("Enter new name for %s:%n", contactName);
                    String newName = input.nextLine();
                    System.out.printf("Enter new phone number for %s:%n", contactName);
                    String newPhoneNumber = input.nextLine();

                    nokiaPhonebook.editContact(contactName, newName, newPhoneNumber);
                    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");
                }

                allContacts = nokiaPhonebook.viewContacts();
                System.out.println("\n" + allContacts);
            }
        }

        System.out.println("Type 0 to go back to the main menu or Enter any key to end program");
        String userChoice = input.nextLine();

        if (userChoice.equals("0")){
            System.out.println();
            displayPhonebookMenu(nokiaPhonebook);
        }
    }

    private static void erase(Phonebook nokiaPhonebook) {
        String allContacts = nokiaPhonebook.viewContacts();

        if (allContacts.equals("Phonebook is empty")) System.out.println("Phonebook is empty");

        else {
            System.out.println("\n" + allContacts);

            System.out.println("Enter contact you want to delete:");
            String contactName = input.nextLine();

            String contactInfo = nokiaPhonebook.searchContact(contactName);

            if (contactInfo.equals("No contact found")) System.out.println(contactInfo);

            else {
                System.out.println(contactInfo);

                nokiaPhonebook.eraseContact(contactName);
                System.out.println("Deleting >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nDeleted successfully\n");
            }

            allContacts = nokiaPhonebook.viewContacts();
            System.out.println("\n" + allContacts);
        }

        System.out.println("\nType 0 to go back to the main menu or Enter any key to end program");
        String userChoice = input.nextLine();

        if (userChoice.equals("0")){
            System.out.println();
            displayPhonebookMenu(nokiaPhonebook);
        }
    }
}
