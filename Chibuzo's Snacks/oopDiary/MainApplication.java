package oopDiary;

import javax.swing.*;

public class MainApplication {
    private static Diary diary;
    private static final User user = new User();
    private static final Diaries shelf = user.getDiaries();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        print("Welcome to C19 Diary Application");

        int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to create a new diary?",
                "Create Diary", JOptionPane.YES_NO_OPTION);

        if (userChoice == JOptionPane.YES_OPTION) createDiary();

        goToMainMenu();
    }

    private static void goToMainMenu() {
        String mainMenu = """         
                What do you want to do today?
                                
                1. Create Diary
                2. Delete Diary
                3. Add Entry
                4. Lock Diary
                5. Unlock Diary
                6. Find Entry by ID
                7. Update Entry
                8. Delete Entry
                9. Exit
                                
                Select option:""";


        String userChoice = input(mainMenu);

        switch (userChoice) {
            case "1" -> createDiary();
            case "2" -> deleteDiary();
            case "3" -> addEntry();
            case "4" -> lockDiary();
            case "5" -> unlockDiary();
            case "6" -> findEntryById();
            case "7" -> updateEntry();
            case "8" -> deleteEntry();
            case "9" -> exitApp();
            default -> goToMainMenu();
        }
    }

    private static void createDiary() {
        String username = input("Enter a username for the diary: ");
        String password = input("Enter a password for  the diary: ");
        diary = new Diary(username, password);

        try {
            user.createDiary(diary);
            print("Diary has been created");
        }
        catch (RuntimeException e) {
            print("Diary has not been created");
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void deleteDiary() {
        String username = getDiaryUsername();
        String password = input("Enter the password of  the diary: ");

        try {
            user.deleteDiary(username, password);
            print("Diary has been deleted successfully");
        }
        catch (RuntimeException e) {
            print("Error in deleting diary");
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }
    
    private static void addEntry() {
        String username = getDiaryUsername();
        ensureDiaryIsUnlocked(username);

        String title = input("Enter Title: ");
        String body = input("Enter Body: ");
        try {
            user.createEntry(username, title, body);
            print("Entry has been created successfully");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static String getDiaryUsername() {
        return input("Enter the username of the diary: ");
    }

    private static void lockDiary() {
        try {
            user.lockDiary(diary);
            print("Diary has been locked");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void findEntryById() {
        String username = getDiaryUsername();
        ensureDiaryIsUnlocked(username);

        String entryId = input("Enter ID of the entry you would like to find: ");
        try {
            Entry foundEntry = user.findEntryById(username, Integer.parseInt(entryId));
            print(foundEntry.toString());
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void updateEntry() {
        ensureDiaryIsUnlocked("");

        String entryId = input("Enter ID of the entry you want to update: ");
        String newTitle = input("Enter the new title of the entry: ");
        String newBody = input("Enter the new body of the entry: ");

        try {
            user.updateEntry(diary, Integer.parseInt(entryId), newTitle, newBody);
            print("Diary has been updated");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void ensureDiaryIsUnlocked(String username) {
        diary = shelf.findByUsername(username);
        if (diary.isLocked()) {
            print("Diary is locked");
            unlockDiary();
        }
    }

    private static void unlockDiary() {
        String password = input("Enter password to unlock diary: ");

        try {
            user.unlockDiary(diary, password);
            print("Diary has been unlocked");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {

            goToMainMenu();
        }
    }

    private static void deleteEntry() {
        ensureDiaryIsUnlocked("");

        String entryID = input("Enter ID of the entry you want to delete: ");
        try {
            user.deleteEntry(diary, Integer.parseInt(entryID));
            print("Entry has been deleted");
        }
        catch (RuntimeException e) {
            print("There was an error while deleting the entry.\n" + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void exitApp() {
        print("exiting...");

        System.exit(0);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }
}
