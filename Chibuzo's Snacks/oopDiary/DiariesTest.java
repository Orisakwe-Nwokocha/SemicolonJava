package oopDiary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    private Diaries shelf;
    private Diary diary;

    @BeforeEach
    public void initializeShelf() {
        shelf = new Diaries();
        diary = new Diary("username", "correctPassword");
    }
    @Test
    public void givenDiariesShelf_defaultStateIsEmpty_numberOfDiariesIs0Test() {
        assertEquals(0, shelf.size());
    }

    @Test
    public void givenDiaryShelf_addDiary_numberOfDiariesIs1Test() {
        shelf.add(diary);
        assertEquals(1, shelf.size());
    }

    @Test
    public void givenDiaryShelf_addDiaryTwice_numberOfDiariesIs2Test() {
        shelf.add(diary);
        shelf.add(new Diary("differentUsername", "correctPassword"));
        assertEquals(2, shelf.size());
    }

    @Test
    public void givenSameUsername_whenEquals_thenDiariesEqualTest() {
        Diary diary2 = new Diary("username", "correctPassword");

        assertEquals(diary, diary2);
    }

    @Test
    public void givenDifferentUsername_whenEquals_thenDiariesNotEqualTest() {
        Diary diary2 = new Diary("differentUsername", "correctPassword");

        assertNotEquals(diary, diary2);
    }


    @Test
    public void givenDiaryInShelf_whenUsernameDoesNotMatch_throwsNullPointerExceptionTest() {
        shelf.add("username", "correctPassword");
        assertEquals(1, shelf.size());

        assertThrows(NullPointerException.class, () -> shelf.findByUsername("anotherUsername"));
    }

    @Test
    public void addDiaryTwiceWithSameUsername_throwsIllegalArgumentExceptionTest() {
        shelf.add(diary);
        assertEquals(1, shelf.size());

        Diary diary2 = new Diary("username", "correctPassword");

        assertThrows(IllegalArgumentException.class, () -> shelf.add(diary2));
        assertThrows(IllegalArgumentException.class, () -> shelf.add("username", "correctPassword"));
        assertEquals(1, shelf.size());
    }

    @Test
    public void givenDiaryInShelf_whenDeleted_numberOfDiariesIs0Test() {
        shelf.add("username", "correctPassword");
        assertEquals(1, shelf.size());

        shelf.delete("username", "correctPassword");
        assertEquals(0, shelf.size());

    }
}