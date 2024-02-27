package oopDiary;

public class User {
    private final Diaries diariesShelf = new Diaries();

    public void createDiary(String username, String password){
        diariesShelf.add(username, password);
    }

    public void createDiary(Diary diary) {
        diariesShelf.add(diary);
    }

    public void deleteEntry(String username, int entryId) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        foundDiary.deleteEntry(entryId);
    }

    public void unlockDiary(String username, String password) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        foundDiary.unlockDiary(password);
    }

    public void lockDiary(String username) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        foundDiary.lockDiary();
    }

    public void updateEntry(String username, int entryId, String newTitle, String newBody) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        foundDiary.updateEntry(entryId, newTitle, newBody);
    }

    public Entry findEntryById(String username, int entryId) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        return foundDiary.findEntryById(entryId);
    }

    public void createEntry(String username, String title, String body) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        foundDiary.createEntry(title, body);
    }

    public Diaries getDiaries() {
        return diariesShelf;
    }

    public void deleteDiary(String username, String password) {
        diariesShelf.delete(username, password);
    }

    public Entry[] viewAllEntries(String username) {
        Diary foundDiary = diariesShelf.findByUsername(username);

        return foundDiary.getEntries();
    }
}
