package dataStructuresAndAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyArrayList strings;

    @BeforeEach
    public void createInstanceOfMyArrayList() {
        strings = new MyArrayList();
    }

    @Test
    public void newListIsEmptyTest() {
        assertTrue(strings.isEmpty());
    }

    @Test
    public void addNewElementToEmptyList_listIsNotEmptyTest() {
        assertTrue(strings.isEmpty());

        strings.add("G-String");
        assertFalse(strings.isEmpty());
    }

    @Test
    public void addNewElement_removeElement_listIsEmptyTest() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        assertFalse(strings.isEmpty());

        strings.remove("G-String");
        assertTrue(strings.isEmpty());
    }

    @Test
    public void addTwoElements_removeOneElement_listIsNotEmptyTest() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        strings.add("A-String");
        assertFalse(strings.isEmpty());

        strings.remove("G-String");
        assertFalse(strings.isEmpty());
    }

    @Test
    public void removeElementFromEmptyList_throwOutOfBoundsExceptionTest() {
        assertTrue(strings.isEmpty());

        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> strings.remove("G-String"));
    }

    @Test
    public void addOneElement_getByIndex_returnsElementTest() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        assertFalse(strings.isEmpty());

        assertEquals("G-String", strings.get(1));
    }

    @Test
    public void addTwoElements_getElementTwo_returnsIndex2Test() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        strings.add("A-String");
        assertFalse(strings.isEmpty());

        assertEquals(2, strings.get("A-String"));
    }

    @Test
    public void addThreeElements_removeElementTwo_ElementThreeIndexIs2Test() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        strings.add("A-String");
        strings.add("D-String");
        assertFalse(strings.isEmpty());

        assertEquals(2, strings.get("A-String"));
        assertEquals(3, strings.get("D-String"));

        strings.remove("A-String");
        assertEquals(2, strings.get("D-String"));
    }

    @Test
    public void addThreeElements_removeIndex1_ElementTwoIndexIs1Test() {
        assertTrue(strings.isEmpty());
        strings.add("G-String");
        strings.add("A-String");
        strings.add("D-String");
        assertFalse(strings.isEmpty());

        assertEquals(1, strings.get("G-String"));
        assertEquals(2, strings.get("A-String"));

        strings.remove(1);
        assertEquals(1, strings.get("A-String"));
    }

}
