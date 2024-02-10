package dataStructuresAndAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    public void myStackIsEmptyTest() {
        MyStack myStack = new MyStack(3);
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void addXItemToStack_myStackIsNotEmptyTest() {
        MyStack myStack = new MyStack(5);
        assertTrue(myStack.isEmpty());

        myStack.push(97);
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void addXYZItemsToStack_removeZItem_myStackIsNotEmptyTest() {
        MyStack myStack = new MyStack(5);
        assertTrue(myStack.isEmpty());

        myStack.push(97);
        myStack.push(6);
        myStack.push(5);

        myStack.pop();
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void checkCapacityOfStackTest() {
        MyStack myStack = new MyStack(5);
        assertTrue(myStack.isEmpty());

        assertEquals(5, myStack.capacity());
    }

    @Test
    public void addXItems_sizeOfStackIs2Test() {
        MyStack myStack = new MyStack(5);
        assertTrue(myStack.isEmpty());
        assertEquals(5, myStack.capacity());

        myStack.push(6);
        myStack.push(5);

        assertEquals(2, myStack.size());
    }

    @Test
    public void sizeIs3_popItem_sizeIs2Test() {
        MyStack myStack = new MyStack(5);
        myStack.push(6);
        myStack.push(5);
        myStack.push(7);
        assertEquals(3, myStack.size());

        myStack.pop();
        assertEquals(2, myStack.size());
    }

    @Test
    public void savePoppedItemToAVariableTest() {
        MyStack myStack = new MyStack(5);
        myStack.push(6);
        myStack.push(5);
        myStack.push(7);
        assertEquals(3, myStack.size());

        int poppedElement = myStack.pop();
        assertEquals(7, poppedElement);
    }

    @Test
    public void addItemToAFilledSTack_throwsOverflowExceptionTest() {
        MyStack myStack = new MyStack(3);
        myStack.push(6);
        myStack.push(5);
        myStack.push(7);

        assertThrows(StackOverflowError.class, ()-> myStack.push(2));
    }

    @Test
    public void popFromAnEmptyList_throwsOutOfBoundsExceptionTest() {
        MyStack myStack = new MyStack(3);
        assertTrue(myStack.isEmpty());

        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> myStack.pop());
    }

    @Test
    public void popLastItem_pushNewItem_newItemIsTopOfStackTest() {
        MyStack myStack = new MyStack(3);
        myStack.push(6);
        myStack.push(5);
        myStack.push(7);

        assertEquals(3, myStack.size());
        assertEquals(3, myStack.capacity());
        assertEquals(7, myStack.peek());

        myStack.pop();
        myStack.push(15);
        assertEquals(3, myStack.size());
        assertEquals(3, myStack.capacity());
        assertEquals(15, myStack.peek());
        System.out.println(myStack);
    }
}
