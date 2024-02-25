package dataStructuresAndAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    private MyQueue myQueue;

    @BeforeEach
    public void startWith() {
        myQueue = new MyQueue(3);
    }

    @Test
    public void myQueueIsEmptyTest() {
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void givenQueue_whenElementIsAdded_returnsTrue_thenQueueIsNotEmptyTest() {
        assertTrue(myQueue.isEmpty());

        assertTrue(myQueue.add(5));
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void givenQueue_addElement_thenNumberOfElementsIs1Test() {
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add(5));
        assertFalse(myQueue.isEmpty());

        assertEquals(1, myQueue.size());
    }

    @Test
    public void givenQueue_addElementTwice_thenNumberOfElementsIs2Test() {
        assertTrue(myQueue.add(5));
        assertTrue(myQueue.add(3));

        assertEquals(2, myQueue.size());
    }

    @Test
    public void givenMaxCapacityOf3_whenAdding_throwsIllegalStateExceptionTest() {
        assertTrue(myQueue.add(5));
        assertTrue(myQueue.add(3));
        assertTrue(myQueue.add(2));
        assertEquals(3, myQueue.size());

        assertThrows(IllegalStateException.class, () -> assertTrue(myQueue.add(1)));
        System.out.println(myQueue);
    }

    @Test
    public void givenElement_whenRemoved_thenQueueIsEmptyTest() {
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add(5));
        assertFalse(myQueue.isEmpty());
        assertEquals(1, myQueue.size());

        myQueue.remove();
        assertTrue(myQueue.isEmpty());
        assertEquals(0, myQueue.size());
    }

    @Test
    public void given3Elements_whenRemoved_returnsTopOfQueue_numberOfElementsIs2Test() {
        assertTrue(myQueue.add(5));
        assertTrue(myQueue.add(3));
        assertTrue(myQueue.add(8));
        assertEquals(3, myQueue.size());

        int topOfQueue = myQueue.remove();
        assertEquals(5, topOfQueue);
        assertEquals(2, myQueue.size());
    }

    @Test
    public void givenEmptyQueue_whenRemoving_throwsNoSuchElementExceptionTest() {
        assertTrue(myQueue.isEmpty());
        assertEquals(0, myQueue.size());

        assertThrows(NoSuchElementException.class, () -> myQueue.remove());
    }

    @Test
    public void givenElement_whenPolled_thenQueueIsEmptyTest() {
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add(5));
        assertFalse(myQueue.isEmpty());
        assertEquals(1, myQueue.size());

        myQueue.poll();
        assertTrue(myQueue.isEmpty());
        assertEquals(0, myQueue.size());
    }

    @Test
    public void given3Elements_whenPolled_returnsTopOfQueue_numberOfElementsIs2Test() {
        assertTrue(myQueue.add(9));
        assertTrue(myQueue.add(6));
        assertTrue(myQueue.add(2));
        assertEquals(3, myQueue.size());

        int topOfQueue = myQueue.poll();
        assertEquals(9, topOfQueue);
        assertEquals(2, myQueue.size());
    }

    @Test
    public void givenEmptyQueue_whenPolling_returnsNull() {
        assertTrue(myQueue.isEmpty());
        assertEquals(0, myQueue.size());

        assertNull(myQueue.poll());
    }

    @Test
    public void given3Elements_whenPeeked_returnsTopOfQueue_numberOfElementsIs3Test() {
        assertTrue(myQueue.add(9));
        assertTrue(myQueue.add(6));
        assertTrue(myQueue.add(2));
        assertEquals(3, myQueue.size());

        int topOfQueue = myQueue.peek();
        assertEquals(9, topOfQueue);
        assertEquals(3, myQueue.size());
    }

    @Test
    public void givenEmptyQueue_whenPeeking_returnsNull() {
        assertTrue(myQueue.isEmpty());
        assertEquals(0, myQueue.size());

        assertNull(myQueue.peek());
    }

    @Test
    public void given3Elements_whenRemoved_removesTopOfQueue_secondElementIsTop_numberOfElementsIs2Test() {
        assertTrue(myQueue.add(5));
        assertTrue(myQueue.add(3));
        assertTrue(myQueue.add(8));
        assertEquals(3, myQueue.size());

        assertEquals(5, myQueue.remove());

        int topOfQueue = myQueue.peek();
        assertEquals(3, topOfQueue);
        assertEquals(2, myQueue.size());
    }

    @Test
    public void givenMaxCapacityOf3_whenRemoved_removesTopOfQueue_addElement_numberOfElementsIs3Test() {
        assertTrue(myQueue.add(90));
        assertTrue(myQueue.add(23));
        assertTrue(myQueue.add(833));
        assertEquals(3, myQueue.size());

        assertEquals(90, myQueue.remove());
        assertEquals(2, myQueue.size());

        assertTrue(myQueue.add(67));
        int topOfQueue = myQueue.peek();
        assertEquals(23, topOfQueue);
        assertEquals(3, myQueue.size());
    }

    @Test
    public void given3Elements_whenPolled_removesTopOfQueue_secondElementIsTop_numberOfElementsIs2Test() {
        assertTrue(myQueue.add(5));
        assertTrue(myQueue.add(3));
        assertTrue(myQueue.add(8));
        assertEquals(3, myQueue.size());

        assertEquals(5, myQueue.poll());

        int topOfQueue = myQueue.peek();
        assertEquals(3, topOfQueue);
        assertEquals(2, myQueue.size());
    }

    @Test
    public void givenMaxCapacityOf3_whenPolled_removesTopOfQueue_addElement_numberOfElementsIs3Test() {
        assertTrue(myQueue.add(90));
        assertTrue(myQueue.add(23));
        assertTrue(myQueue.add(833));
        assertEquals(3, myQueue.size());

        assertEquals(90, myQueue.poll());
        assertEquals(2, myQueue.size());

        assertTrue(myQueue.add(67));
        int topOfQueue = myQueue.peek();
        assertEquals(23, topOfQueue);
        assertEquals(3, myQueue.size());
    }

    @Test
    public void givenExistingElement_whenSearched_returnsTrueTest() {
        myQueue.add(48);
        assertTrue(myQueue.contains(48));
    }

    @Test
    public void givenNonExistingElement_whenSearched_returnsFalseTest() {
        myQueue.add(48);
        assertFalse(myQueue.contains(78));
    }

}