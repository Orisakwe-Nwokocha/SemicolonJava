package oopDiary;

import oopAccount.Account;

import javax.swing.*;

public class MainApplication {
    private static Diary diary;
    private static final User user = new User();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        print("Welcome to the Diary Application");
        int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to create a new diary?",
                "Create Diary", JOptionPane.YES_NO_OPTION);

        if (userChoice == JOptionPane.YES_OPTION) createDiary();
        exitApp();
    }

    private static void createDiary() {
        String password = input("Enter a password: ");
        diary = user.createDiary(password);

        goToMainMenu();
    }

    private static void goToMainMenu() {
        String mainMenu = """         
                What do you want to do today?
                                
                1. Add Entry
                2. Lock Diary
                3. Unlock Diary
                4. Find Entry by ID
                5. Update Entry
                6. Delete Entry
                7. Exit
                                
                Select option:""";


        String userChoice = input(mainMenu);

        switch (userChoice) {
            case "1" -> addEntry();
            case "2" -> lockDiary();
            case "3" -> unlockDiary();
            case "4" -> findEntryById();
            case "5" -> updateEntry();
            case "6" -> deleteEntry();
            case "7" -> exitApp();
            default -> goToMainMenu();
        }
    }

    private static void addEntry() {
    }

    private static void lockDiary() {
        try {
            user.lockDiary(diary);
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            print("Diary has been locked");
            goToMainMenu();
        }
    }

    private static void findEntryById() {
        String entryId = input("Enter ID of the entry you would like to find: ");

        try {
            Entry foundEntry = user.findEntryById(diary, Integer.parseInt(entryId));
            print(foundEntry.toString());
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            print("Diary has been updated");

            goToMainMenu();
        }
    }

    private static void updateEntry() {
        String entryId = input("Enter ID of the entry you want to update: ");
        String newTitle = input("Enter the new title of the entry: ");
        String newBody = input("Enter the new body of the entry: ");

        try {
            user.updateEntry(diary, Integer.parseInt(entryId), newTitle, newBody);
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            print("Diary has been updated");

            goToMainMenu();
        }
    }

    private static void unlockDiary() {
        String password = input("Enter a password: ");

        try {
            user.unlockDiary(diary, password);
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            print(String.valueOf(diary.isLocked()));
            print("Diary has been unlocked");

            goToMainMenu();
        }
    }

    private static void deleteEntry() {
        print(String.valueOf(diary.isLocked()));
        if (diary.isLocked()) {
            print("Diary is locked");
            unlockDiary();
        }

        String entryID = input("Enter ID of the entry you want to delete: ");
        try {
            user.deleteEntry(diary, Integer.parseInt(entryID));
        }
        catch (RuntimeException e) {
            print("There was an error while deleting the entry.\n" + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void exitApp() {
        try {
            print("exiting...");
            Thread.sleep(1500);
        }
        catch (InterruptedException ignored) {
        }

        System.exit(0);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }
}
