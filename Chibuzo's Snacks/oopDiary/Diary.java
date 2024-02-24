package oopDiary;

import java.util.ArrayList;
import java.util.List;

public class Diary {

    private boolean isLocked;
    private String password;
    private int lastEntryCreated;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String password) {
        validate(password);

        isLocked = false;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        int id = generateEntryId();
        Entry newEntry = new Entry(id, title, body);
        entries.add(newEntry);
    }

    private int generateEntryId() {
        return ++lastEntryCreated;
    }

    public int numberOfEntries() {
        return entries.size();
    }

    public Entry findEntryById(int entryId) {
        for (Entry entry : entries) if (entry.getId() == entryId) return entry;

        throw new NullPointerException("Entry does not exist");
    }

    private void validate(String password) {
        if (!this.password.equals(password)) throw new IncorrectPasswordException("Password is incorrect");
    }

    public void deleteEntry(int entryId) {
        Entry foundEntry = findEntryById(entryId);

        entries.remove(foundEntry);
    }

    public void updateEntry(int entryId, String newTitle, String newBody) {
        entries.add(entryId, new Entry(entryId, newTitle, newBody));
        deleteEntry(entryId);
    }
}
