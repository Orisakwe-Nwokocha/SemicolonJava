package dataStructuresAndAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    @Test
    public void givenUniqueElement_whenAddingDuplicate_setRemainsUnchangedTest() {
        MySet set = new MySet();
        assertTrue(set.isEmpty());
        set.add("test");
        set.add("Test");
        assertEquals(2, set.size());

        set.add("test");
        assertNotEquals(3, set.size());
        System.out.println(set);
    }

    @Test
    public void givenUniqueElement_whenAddingDuplicateByIndex_setRemainsUnchangedTest() {
        MySet set = new MySet();
        set.add("test");
        set.add("Test");
        set.add("TEST");
        set.add("tesT");
        assertEquals(4, set.get("tesT"));
        assertEquals(4, set.size());

        set.add("test");
        assertEquals(4, set.size());
        System.out.println(set);
    }

    @Test
    public void givenElement_whenRemoved_returnsTrue() {
        MySet set = new MySet();
        set.add("check");
        set.add("TEST");
        set.add("TEST");
        assertEquals(2, set.size());

        boolean isRemoved = set.remove("TEST");

        assertEquals(1, set.size());
        assertTrue(isRemoved);
    }
}
