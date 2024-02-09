package dataStructuresAndAlgorithms;

import java.util.Arrays;

public class MyStack {
    private int numberOfElements;
    private int[] elements;

    public MyStack(int capacity) {
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void push(int element) {
        if (size() == capacity()) throw new StackOverflowError("Stack is filled up");
        elements[numberOfElements] = element;
        numberOfElements++;
    }

    public int pop() {
       // if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        int poppedElement = peek();
        numberOfElements--;
        return poppedElement;
    }

    public int capacity() {
        return elements.length;
    }

    public int size() {
        return numberOfElements;
    }

    public int peek() {
        return elements[numberOfElements - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
