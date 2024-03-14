package turtleGraphics;

import static turtleGraphics.Direction.*;

public class Turtle {
    private boolean isPenUp = true;
    private Direction currentDirection = EAST;
    private Position currentPosition = new Position(0, 0);

    public boolean isPenUp() {
        return isPenUp;
    }

    public void penDown() {
        isPenUp = false;
    }

    public void penUp() {
        isPenUp = true;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnLeft() {
        currentDirection = currentDirection.turnLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.turnRight();
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void moveForward(int numberOfSteps, Sketchpad sketchpad) {
        if (!isPenUp) writeOn(sketchpad, numberOfSteps);

        switch (currentDirection) {
            case EAST -> moveForwardEastward(numberOfSteps);
            case SOUTH -> moveForwardSouthward(numberOfSteps);
            case WEST -> moveForwardWestward(numberOfSteps);
            case NORTH -> moveForwardNorthward(numberOfSteps);
        }
    }

    private void writeOn(Sketchpad sketchpad, int numberOfSteps) {
        switch (currentDirection) {
            case EAST -> writeEastwardOn(sketchpad, numberOfSteps);
            case SOUTH -> writeSouthwardOn(sketchpad, numberOfSteps);
            case WEST -> writeWestwardOn(sketchpad, numberOfSteps);
            case NORTH -> writeNorthwardOn(sketchpad, numberOfSteps);
        }
    }

    private void writeNorthwardOn(Sketchpad sketchpad, int numberOfSteps) {
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();

        int[][] floor = sketchpad.getFloor();

        for (int row = 0; row < numberOfSteps; row++) floor[currentRow - row][currentColumn] = 1;
    }

    private void writeWestwardOn(Sketchpad sketchpad, int numberOfSteps) {
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();

        int[][] floor = sketchpad.getFloor();

        for (int column = 0; column < numberOfSteps; column++) floor[currentRow][currentColumn - column] = 1;
    }

    private void writeSouthwardOn(Sketchpad sketchpad, int numberOfSteps) {
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();

        int[][] floor = sketchpad.getFloor();

        for (int row = 0; row < numberOfSteps; row++) floor[currentRow + row][currentColumn] = 1;
    }

    private void writeEastwardOn(Sketchpad sketchpad, int numberOfSteps) {
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();

        int[][] floor = sketchpad.getFloor();

        for (int column = 0; column < numberOfSteps; column++) floor[currentRow][currentColumn + column] = 1;
    }

    private void moveForwardNorthward(int numberOfSteps) {
        int currentRow = currentPosition.getRow() + 1;

        currentPosition = new Position(numberOfSteps - currentRow, currentPosition.getColumn());
    }

    private void moveForwardWestward(int numberOfSteps) {
        int currentColumn = currentPosition.getColumn() + 1;

        currentPosition = new Position(currentPosition.getRow(), numberOfSteps - currentColumn);
    }

    private void moveForwardSouthward(int numberOfSteps) {
        currentPosition = new Position(numberOfSteps - 1, currentPosition.getColumn());
    }

    private void moveForwardEastward(int numberOfSteps) {
        currentPosition = new Position(currentPosition.getRow(), numberOfSteps - 1);
    }
}
