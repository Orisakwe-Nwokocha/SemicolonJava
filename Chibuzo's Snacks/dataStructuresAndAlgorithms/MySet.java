package dataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class MySet {
    private MyArrayList myArrayList;

    public MySet() {
        this.myArrayList = new MyArrayList();
    }

    public void add(String element) {
        if (!contains(element)) {
            myArrayList.add(element);
        }
    }

    private boolean contains(String element) {
        for (int index = 0; index < size(); index++) {
            boolean isPresent = myArrayList.get(index + 1).equals(element);
            if (isPresent) return true;
        }

        return false;
    }

    public int size() {
        return myArrayList.size();
    }

    public int get(String element) {
        return myArrayList.get(element);
    }

    public boolean isEmpty() {
        return myArrayList.isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(shuffleSet());
    }

    private String[] shuffleSet() {
        String[] shuffledSet = new String[size()];
        for (int index = 0; index < size(); index++) shuffledSet[index] = myArrayList.get(index + 1);

        Collections.shuffle(Arrays.asList(shuffledSet));

        return shuffledSet;
    }

    public boolean remove(String element) {
        myArrayList.remove(element);

        return !contains(element);
    }
}