package turtleGraphics;

public class Position {
    private int row;
    private int column;
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("Position[row: %d, column: %d]", row, column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position position) return row == position.row && column == position.column;

        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
