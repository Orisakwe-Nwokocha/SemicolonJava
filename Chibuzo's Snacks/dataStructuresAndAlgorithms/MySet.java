package dataStructuresAndAlgorithms;

public class MySet extends MyArrayList {

    @Override
    public void add(String element) {
        if (!contains(element)) super.add(element);
    }

    @Override
    public void add(int index, String element) {
        if (!contains(element)) super.add(index, element);
    }
}