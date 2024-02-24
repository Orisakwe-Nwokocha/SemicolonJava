package oopDiary;

public class User {

    public Diary createDiary(String password){
        return new Diary(password);
    }

    public void deleteEntry(Diary diary, int entryId) {
        diary.deleteEntry(entryId);
    }

    public void unlockDiary(Diary diary, String password) {
        diary.unlockDiary(password);
    }

    public void lockDiary(Diary diary) {
        diary.lockDiary();
    }

    public void updateEntry(Diary diary, int entryId, String newTitle, String newBody) {
        diary.updateEntry(entryId, newTitle, newBody);
    }

    public Entry findEntryById(Diary diary, int entryId) {
        return diary.findEntryById(entryId);
    }

    public void createEntry(Diary diary, String title, String body) {
        diary.createEntry(title, body);
    }
}
