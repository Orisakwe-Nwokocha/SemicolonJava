package oopDiary;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<>();

    public int size() {
        return diaries.size();
    }

    public void add(Diary diary) {
        validate(diary);

        diaries.add(diary);
    }

    public void add(String username, String password) {
        validate(new Diary(username, password));

        diaries.add(new Diary(username, password));
    }

    public Diary findByUsername(String username) {
        for (Diary diary : diaries) if (diary.getUsername().equals(username)) return diary;

        throw new NullPointerException("Diary not found");
    }

    private void validate(Diary d) {
        for (Diary diary : diaries) if (diary.equals(d)) throw new IllegalArgumentException("Username already exists");
    }

    public void delete(String username, String password) {
        Diary foundDiary = findByUsername(username);
        if (!foundDiary.verifyPassword(password)) throw new IllegalArgumentException("Password is not valid");

        diaries.remove(foundDiary);
    }
}
