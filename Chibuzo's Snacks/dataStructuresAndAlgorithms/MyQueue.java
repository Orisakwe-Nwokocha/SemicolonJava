package dataStructuresAndAlgorithms;

import java.util.NoSuchElementException;

public class MyQueue {
    private int numberOfElements;
    private int[] numbers;

    public MyQueue(int capacity) {
        numbers = new int[capacity];
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean add(int element) {
        ensureCapacity();

        numbers[numberOfElements++] = element;
        
        return true;
    }

    private void ensureCapacity() {
        boolean isFull = numberOfElements == numbers.length;
        if (isFull) throw new IllegalStateException("Queue is full");
    }

    public int size() {
        return numberOfElements;
    }

    public int remove() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int topOfQueue = peek();
        rearrangeArray();
        numberOfElements--;

        return topOfQueue;
    }

    public Integer poll() {
        if (isEmpty()) return null;
        int topOfQueue = peek();
        rearrangeArray();
        numberOfElements--;

        return topOfQueue;
    }

    private void rearrangeArray() {
        for (int index = 1; index < numberOfElements; index++) numbers[index - 1] = numbers[index];
    }

    public Integer peek() {
        if (isEmpty()) return null;
        
        return numbers[0];
    }

    @Override
    public String toString() {
        StringBuilder outputArray = new StringBuilder("[");

        for (int index = 0; index < numberOfElements; index++) {
            outputArray.append(numbers[index]);
            if (index != numberOfElements - 1) outputArray.append(", ");
        }
        outputArray.append("]");

        return outputArray.toString();
    }

    public boolean contains(int element) {
        for (int number: numbers) if (number == element) return true;
        return false;
    }
}
