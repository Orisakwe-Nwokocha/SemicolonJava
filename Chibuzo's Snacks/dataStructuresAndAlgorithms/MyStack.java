package dataStructuresAndAlgorithms;

import java.util.EmptyStackException;

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
        if (isEmpty()) throw new EmptyStackException();

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
        if (isEmpty()) throw new EmptyStackException();

        return elements[numberOfElements - 1];
    }

    public int search(int element) {
        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index] == element) return numberOfElements - index;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder outputArray = new StringBuilder("[");

        for (int index = 0; index < numberOfElements; index++) {
            outputArray.append(elements[index]);
            if (index != numberOfElements - 1) outputArray.append(", ");
        }
        outputArray.append("]");

        return outputArray.toString();
    }
}
