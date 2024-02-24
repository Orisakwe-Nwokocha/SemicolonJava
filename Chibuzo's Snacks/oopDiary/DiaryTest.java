package oopDiary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;

    @BeforeEach
    public void initializeDiary() {
        diary = new Diary("correctPassword");
    }

    @Test
    public void givenDiary_initialState_diaryIsUnLockedTest() {
        assertFalse(diary.isLocked());
    }

    @Test
    public void givenUnLockedDiary_lockDiary_diaryIsLockedTest() {
        assertFalse(diary.isLocked());

        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void givenLockedDiary_unlockDiary_diaryIsUnlockedTest() {
        diary.lockDiary();
        assertTrue(diary.isLocked());

        diary.unlockDiary("correctPassword");
        assertFalse(diary.isLocked());
    }

    @Test
    public void givenLockedDiary_unlockDiaryWithIncorrectPassword_throwsIncorrectPasswordExceptionTest() {
        diary.lockDiary();
        assertTrue(diary.isLocked());

        assertThrows(IncorrectPasswordException.class, ()-> diary.unlockDiary("incorrectPassword"));
    }

    @Test
    public void givenDiary_createEntry_NumberOfEntriesIs1Test() {
        diary.createEntry("title", "body");
        assertEquals(1, diary.numberOfEntries());
    }

    @Test
    public void givenDiary_createEntryTwice_NumberOfEntriesIs2Test() {
        diary.createEntry("title", "body");
        diary.createEntry("title2", "body2");

        assertEquals(2, diary.numberOfEntries());
    }

    @Test
    public void givenEntry_entryIdIs1_NumberOfEntriesIs1Test() {
        diary.createEntry("title", "body");
        Entry foundEntry = diary.findEntryById(1);

        assertEquals(1, foundEntry.getId());
        assertEquals(1, diary.numberOfEntries());
    }

    @Test
    public void given2Entries_secondEntryIdIs2_NumberOfEntriesIs2Test() {
        diary.createEntry("title", "body");
        diary.createEntry("title2", "body2");

        Entry foundEntry = diary.findEntryById(2);
        assertEquals(2, foundEntry.getId());
        assertEquals(2, diary.numberOfEntries());
    }

    @Test
    public void given3Entries_removeSecondEntry_fourthEntryIdIs4_NumberOfEntriesIs3Test() {
        diary.createEntry("title", "body");
        diary.createEntry("title2", "body2");
        diary.createEntry("title3", "body3");
        assertEquals(3, diary.numberOfEntries());

        diary.deleteEntry(2);
        diary.createEntry("title4", "body4");
        Entry foundEntry = diary.findEntryById(4);

        assertEquals(4, foundEntry.getId());
        assertEquals(3, diary.numberOfEntries());
    }

}