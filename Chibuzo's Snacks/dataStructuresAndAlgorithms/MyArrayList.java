package dataStructuresAndAlgorithms;

public class MyArrayList {
    private int numberOfElements;
    private String[] elements = new String[5];

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void add(String element) {
        elements[numberOfElements] = element;
        numberOfElements++;
    }

    public void remove(String element) {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("List is empty");

        elements = removeElementsBy(element);
        numberOfElements--;
    }

    public void remove(int index) {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("List is empty");

        elements = removeElementsBy(index);
        numberOfElements--;
    }

    public String get(int index) {
        return elements[index -1];
    }

    public int get(String element) {
        for (int index = 0; index < elements.length; index++)
            if (elements[index].equals(element)) return index + 1;

        return 0;
    }

    private String[] removeElementsBy(String element) {
        String[] temp = new String[elements.length];
        int counter = 0;

        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index].equals(element)) continue;
            temp[counter] = elements[index];
            counter++;
        }
        return temp;
    }

    private String[] removeElementsBy(int index) {
        String[] temp= new String[elements.length];
        int counter = 0;

        for (int row = 0; row < numberOfElements; row++) {
            if (row == index -1) continue;
            temp[counter] = elements[row];
            counter++;
        }
        return temp;
    }

}
