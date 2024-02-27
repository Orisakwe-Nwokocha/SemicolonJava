package oopDiary;

import javax.swing.*;

public class MainApplication {
    private static Diary diary;
    private static final User user = new User();
    private static final Diaries diariesShelf = user.getDiaries();

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
                9. View ALl Entries
                10. Exit
                                
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
            case "9" -> viewAllEntries();
            case "10" -> exitApp();
            default -> goToMainMenu();
        }
    }


    private static void createDiary() {
        String username = input("Enter a username for the diary: ");
        String password = input("Enter a password for  the diary: ");

        try {
            user.createDiary(new Diary(username, password));
            print("Diary has been created");
        }
        catch (RuntimeException e) {
            print("Error: " + e.getMessage());
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
            print("Error: " + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void addEntry() {
        String username = getDiaryUsername();
        ensureDiaryIsUnlocked(username);

        String title = input("Enter the title: ");
        String body = input("Enter the body: ");

        try {
            user.createEntry(username, title, body);
            print("Entry has been created successfully");
        }
        catch (RuntimeException e) {
            print("Error: " + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void lockDiary() {
        String username = getDiaryUsername();

        try {
            checkLockStatus(username);

            user.lockDiary(username);
            print("Diary has been locked");
        }
        catch (RuntimeException e) {
            print("Error: " + e.getMessage());
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
            print("Error: " + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void updateEntry() {
        String username = getDiaryUsername();
        ensureDiaryIsUnlocked(username);

        String entryId = input("Enter ID of the entry you want to update: ");
        String newTitle = input("Enter the new title of the entry: ");
        String newBody = input("Enter the new body of the entry: ");

        try {
            user.updateEntry(username, Integer.parseInt(entryId), newTitle, newBody);
            print("Diary has been updated");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void unlockDiary() {
        String username = getDiaryUsername();

        try {
            checkUnlockStatus(username);

            String password = input("Enter password to unlock diary: ");
            user.unlockDiary(username, password);
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
        String username = getDiaryUsername();
        ensureDiaryIsUnlocked(username);

        String entryID = input("Enter ID of the entry you want to delete: ");

        try {
            user.deleteEntry(username, Integer.parseInt(entryID));
            print("Entry has been deleted successfully");
        }
        catch (RuntimeException e) {
            print("Error: " + e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void viewAllEntries() {
    }

    private static void exitApp() {
        print("exiting...");

        System.exit(0);
    }

    private static void ensureDiaryIsUnlocked(String username) {
        try {
            diary = diariesShelf.findByUsername(username);
            if (diary.isLocked()) throw new IllegalStateException("Diary is locked");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
            goToMainMenu();
        }
    }

    private static void checkLockStatus(String username) {
        diary = diariesShelf.findByUsername(username);
        if (diary.isLocked()) throw new IllegalStateException("Diary is already locked");
    }

    private static void checkUnlockStatus(String username) {
        diary = diariesShelf.findByUsername(username);
        if (!diary.isLocked()) throw new IllegalStateException("Diary is already unlocked");
    }

    private static String getDiaryUsername() {
        return input("Enter the username of the diary: ");
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void print(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }
}
