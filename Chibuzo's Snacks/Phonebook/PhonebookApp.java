import java.util.InputMismatchException;
import java.util.Scanner;

public class PhonebookApp {
    private static final Scanner input = new Scanner(System.in);

    public static void startApp(Phonebook nokiaPhonebook) {
       displayPhonebookMenu(nokiaPhonebook);

    }
    private static void displayPhonebookMenu(Phonebook nokiaPhonebook) {
        System.out.print("""
                Phonebook
                
                1. Search
                2. Add contact
                3. View contacts
                4. Edit
                5. Erase
                6. Exit app
                
                Select an option:
                """);
        String userChoice = input.next();
        input.nextLine();

        switch (userChoice) {
            case "1" -> search(nokiaPhonebook);
            case "2" -> addContact(nokiaPhonebook);
            case "3" -> viewContacts(nokiaPhonebook);
            case "4" -> edit(nokiaPhonebook);
            case "5" -> erase(nokiaPhonebook);
            case "6" -> exit();
            default -> displayPhonebookMenu(nokiaPhonebook);
        }

    }

    private static void exit() {
        print("Thank you for using Phonebook App!");

        System.exit(0);
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static void search(Phonebook nokiaPhonebook) {
        print("\nSearch contact by name:");
        String contactName = input.nextLine();

        String contactInfo = nokiaPhonebook.searchContact(contactName);
        print("\n" + contactInfo);

        print("");
        displayPhonebookMenu(nokiaPhonebook);
    }

    private static void viewContacts(Phonebook nokiaPhonebook) {
        System.out.println();

        print(nokiaPhonebook.viewContacts());

        print("");
        displayPhonebookMenu(nokiaPhonebook);
    }

    private static void addContact(Phonebook nokiaPhonebook) {
        print("\nEnter contact name:");

        String contactName = input.nextLine();

        print("Enter contact phone number:");
        String phoneNumber = input.nextLine();

        try {
            nokiaPhonebook.addContact(contactName, phoneNumber);
            print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

        } catch (InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            print("");
            displayPhonebookMenu(nokiaPhonebook);
        }
    }

    private static void edit(Phonebook nokiaPhonebook) {
        String allContacts = nokiaPhonebook.viewContacts();

        if (allContacts.equals("Phonebook is empty")) print("Phonebook is empty");

        else {
            print("\n" + allContacts);

            print("Enter contact you want to edit:");
            String contactName = input.nextLine();

            String contactInfo = nokiaPhonebook.searchContact(contactName);

            if (contactInfo.equals("No contact found")) print(contactInfo);

            else {
                print(contactInfo);

                print("Type 1 to edit contact name or Type 2 to edit contact number or Type 3 to edit both");
                String userChoice = input.nextLine();

                while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3")) {
                    print("Invalid input\n" +
                            "Type 1 to edit contact name or Type 2 to edit contact number or Type 3 to edit both");
                    userChoice = input.nextLine();
                }

                if (userChoice.equals("1")) {
                    System.out.printf("Enter new name for %s:%n", contactName);
                    String newName = input.nextLine();
                    nokiaPhonebook.editContactName(contactName, newName);
                    print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

                } else if (userChoice.equals("2")) {
                    System.out.printf("Enter new phone number for %s:%n", contactName);
                    String newPhoneNumber = input.nextLine();
                    nokiaPhonebook.editContactPhoneNumber(contactName, newPhoneNumber);
                    print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

                } else {
                    System.out.printf("Enter new name for %s:%n", contactName);
                    String newName = input.nextLine();
                    System.out.printf("Enter new phone number for %s:%n", contactName);
                    String newPhoneNumber = input.nextLine();

                    nokiaPhonebook.editContact(contactName, newName, newPhoneNumber);
                    print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");
                }

                allContacts = nokiaPhonebook.viewContacts();
                print("\n" + allContacts);
            }
        }

        print("");
        displayPhonebookMenu(nokiaPhonebook);
    }

    private static void erase(Phonebook nokiaPhonebook) {
        String allContacts = nokiaPhonebook.viewContacts();

        if (allContacts.equals("Phonebook is empty")) print("Phonebook is empty");

        else {
            print("\n" + allContacts);

            print("Enter contact you want to delete:");
            String contactName = input.nextLine();

            String contactInfo = nokiaPhonebook.searchContact(contactName);

            if (contactInfo.equals("No contact found")) print(contactInfo);

            else {
                print(contactInfo);

                nokiaPhonebook.eraseContact(contactName);
                print("Deleting >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nDeleted successfully\n");
            }

            allContacts = nokiaPhonebook.viewContacts();
            print("\n" + allContacts);
        }

        print("");
        displayPhonebookMenu(nokiaPhonebook);
    }
}
