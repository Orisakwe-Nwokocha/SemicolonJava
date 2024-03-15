package turtleGraphics;

public class Sketchpad {
    private final int[][] floor;
    public Sketchpad(int row, int column) {
        floor = new int[row][column];
    }

    public int[][] getFloor() {
        return floor;
    }

    public String displayFloor() {
        StringBuilder output = new StringBuilder();
        for (int[] row : floor) {
            for (int number : row) output.append(number == 1 ? "* " : "  ");
            output.append("\n");
        }
        return output.toString();
    }
}
