package dataStructuresAndAlgorithms;

public class MyArrayList {
    private int numberOfElements;
    private String[] elements = new String[5];

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void add(String element) {
        if (size() == elements.length - 2) createNewArray();

        elements[numberOfElements] = element;
        numberOfElements++;
    }

    public void add(int index, String element) {
        boolean indexIsOutOfRange = index < 1 || index > numberOfElements;
        if (indexIsOutOfRange) throw new ArrayIndexOutOfBoundsException("Index is out of range");

        if (size() == elements.length - 2) createNewArray();

        String[] shiftedArray = new String[elements.length];

        for (int listIndex = 0; listIndex < size() + 1; listIndex++) {
            if (listIndex == index - 1) continue;
            if (listIndex > index - 1) {
                shiftedArray[listIndex] = elements[listIndex - 1];
                continue;
            }

            shiftedArray[listIndex] = elements[listIndex];
        }
        shiftedArray[index - 1] = element;

        elements = shiftedArray;
        numberOfElements++;
    }

    public void remove(String element) {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        else if (!contains(element)) throw new IllegalArgumentException(element + " is not in the list");

        removeElementsBy(element);
        numberOfElements--;
    }

    public void remove(int index) {
        if (isEmpty()) throw new IllegalStateException("List is empty");

        boolean indexIsOutOfRange = index < 1 || index > numberOfElements;
        if (indexIsOutOfRange) throw new ArrayIndexOutOfBoundsException("Index is out of range");

        removeElementsBy(index);
        numberOfElements--;
    }

    public String get(int index) {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("List is empty");

        return elements[index -1];
    }

    public int get(String element) {
        for (int index = 0; index < numberOfElements; index++) if (elements[index].equals(element)) return index + 1;

        return -1;
    }

    public int size() {
        return numberOfElements;
    }

    public boolean contains(String element) {
        for (String string : elements) if (element.equals(string)) return true;
        return false;
    }

    private void removeElementsBy(String element) {
        int counter = 0;

        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index].equals(element)) continue;

            elements[counter] = elements[index];
            counter++;
        }
    }

    private void removeElementsBy(int index) {
        int counter = 0;

        for (int listIndex = 0; listIndex < numberOfElements; listIndex++) {
            if (listIndex == index - 1) continue;

            elements[counter] = elements[listIndex];
            counter++;
        }
    }

    private void createNewArray() {
        String[] newArray = new String[elements.length * 2];

        if (size() >= 0) System.arraycopy(elements, 0, newArray, 0, size());
        elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder outputArray;
        outputArray = new StringBuilder("[");

        for (int index = 0; index < numberOfElements; index++) {
            outputArray.append(elements[index]);
            if (index != numberOfElements - 1) outputArray.append(", ");
        }
        outputArray.append("]");

        return outputArray.toString();
    }

}
