package data.repositories;

import data.models.Diary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    private DiaryRepository repository;

    @BeforeEach
    public void startWithThis() {
        repository = new DiaryRepositoryImpl();
    }

    @AfterEach
    public void endWithThis() {
        repository.findAll().clear();
    }


    @Test
    public void saveDiary_numberOfDiariesIs1Test() {
        assertEquals(0L, repository.count());

        Diary diary = new Diary();
        diary.setUsername("username");
        diary.setPassword("password");

        repository.save(diary);

        assertEquals(1L, repository.count());
    }

    @Test
    public void updateSavedDiary_numberOfDiaries1Test() {
        Diary diary = new Diary();
        diary.setUsername("username");
        diary.setPassword("password");

        repository.save(diary);
        assertEquals(1L, repository.count());

        Diary updatedDiary = new Diary();
        updatedDiary.setId(1);
        updatedDiary.setPassword("newPassword");
        repository.save(updatedDiary);

        assertEquals(1L, repository.count());
    }

    @Test
    public void save2Diaries_deleteOneSavedDiaryByUsername_numberOfDiaries1Test() {
        Diary diary1 = new Diary();
        diary1.setUsername("username");
        diary1.setPassword("password");
        repository.save(diary1);
        Diary diary2 = new Diary();
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary2);

        assertEquals(2L, repository.findAll().size());

        repository.delete("username");
        assertEquals(1L, repository.findAll().size());
    }

    @Test
    public void save2Diaries_delete1SavedDiaryByDiary_numberOfDiaries1Test() {
        Diary diary1 = new Diary();
        diary1.setUsername("username");
        diary1.setPassword("password");
        repository.save(diary1);
        Diary diary2 = new Diary();
        diary2.setUsername("username2");
        diary2.setPassword("password");
        repository.save(diary2);
        assertEquals(2L, repository.count());

        repository.delete(diary2);
        assertEquals(1L, repository.findAll().size());
    }

}