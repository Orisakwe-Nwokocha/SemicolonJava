package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private static final List<Diary> diaries = new ArrayList<>();
    private int lastDiaryId;
    @Override
    public Diary save(Diary diary) {
        if (isNew(diary)) addIdTo(diary);
        else update(diary);

        diaries.add(diary);

        return diary;
    }

    private void update(Diary diary) {
        diaries.removeIf(d -> d.getId() == diary.getId());
    }

    private void addIdTo(Diary diary) {
        diary.setId(generateId());
    }

    private int generateId() {
        return ++lastDiaryId;
    }

    private boolean isNew(Diary diary) {
        return diary.getId() == 0;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(String username) {
        for (Diary diary : diaries) if (diary.getUsername().equals(username)) return diary;

        return null;
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(String username) {
        Diary foundDiary = findById(username);

        diaries.remove(foundDiary);
    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);
    }
}
