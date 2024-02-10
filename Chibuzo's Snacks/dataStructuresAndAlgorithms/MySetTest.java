package dataStructuresAndAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    @Test
    public void givenUniqueElement_whenAddingDuplicate_setRemainsUnchangedTest() {
        MySet set = new MySet();
        set.add("test");
        set.add("Test");
        assertEquals(2, set.size());

        set.add("test");
        assertNotEquals(3, set.size());
        System.out.println(set);
    }

    @Test
    public void givenAddingDuplicate_whenGettingDuplicate_throwsExceptionTest() {
        MySet set = new MySet();
        set.add("test");
        set.add("Test");
        assertEquals("test", set.get(1));
        assertEquals("Test", set.get(2));

        try {
            set.add("test");
            set.get(3);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index is out of range", e.getMessage());
        }
    }


    @Test
    public void givenUniqueElement_whenAddingDuplicateByIndex_setRemainsUnchangedTest() {
        MySet set = new MySet();
        set.add("test");
        set.add("Test");
        set.add("TEST");
        set.add(2, "tesT");
        assertEquals(2, set.get("tesT"));
        assertEquals(4, set.size());

        set.add(2, "test");
        assertEquals(4, set.size());
        System.out.println(set);
    }
}
