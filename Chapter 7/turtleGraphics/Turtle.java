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
        validate(numberOfSteps, sketchpad);

        if (!isPenUp) writeOn(sketchpad, numberOfSteps);

        switch (currentDirection) {
            case EAST -> moveForwardEastward(numberOfSteps);
            case SOUTH -> moveForwardSouthward(numberOfSteps);
            case WEST -> moveForwardWestward(numberOfSteps);
            case NORTH -> moveForwardNorthward(numberOfSteps);
        }
    }

    private void validate(int numberOfSteps, Sketchpad sketchpad) {
        if (numberOfSteps < 1) throw new InvalidMoveException("Number of steps must be greater than 0");

        switch (currentDirection) {
            case EAST -> validateEastward(numberOfSteps, sketchpad);
            case SOUTH -> validateSouthward(numberOfSteps, sketchpad);
            case WEST -> validateWestward(numberOfSteps);
            case NORTH -> validateNorthward(numberOfSteps);
        }
    }

    private void validateNorthward(int numberOfSteps) {
        int rowMovement = (currentPosition.getRow() + 1) - numberOfSteps;

        if (rowMovement < 0) throw new InvalidMoveException("Invalid move. PLease try again.");
    }

    private void validateWestward(int numberOfSteps) {
        int columnMovement = (currentPosition.getColumn() + 1) - numberOfSteps;

        if (columnMovement < 0) throw new InvalidMoveException("Invalid move. PLease try again.");

    }

    private void validateSouthward(int numberOfSteps, Sketchpad sketchpad) {
        int floorRow = sketchpad.getFloor().length;
        int rowMovement = numberOfSteps + currentPosition.getRow();

        if (rowMovement > floorRow) throw new InvalidMoveException("Invalid move. PLease try again.");
    }

    private void validateEastward(int numberOfSteps, Sketchpad sketchpad) {
        int[] floorColumn = sketchpad.getFloor()[currentPosition.getRow()];
        int columnMovement = numberOfSteps + currentPosition.getColumn();

        if (columnMovement > floorColumn.length) throw new InvalidMoveException("Invalid move. PLease try again.");
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

        currentPosition = new Position(currentRow - numberOfSteps, currentPosition.getColumn());
    }

    private void moveForwardWestward(int numberOfSteps) {
        int currentColumn = currentPosition.getColumn() + 1;

        currentPosition = new Position(currentPosition.getRow(), currentColumn - numberOfSteps);
    }

    private void moveForwardSouthward(int numberOfSteps) {
        currentPosition = new Position((numberOfSteps - 1) + currentPosition.getRow(), currentPosition.getColumn());
    }

    private void moveForwardEastward(int numberOfSteps) {
        currentPosition = new Position(currentPosition.getRow(), (numberOfSteps - 1) + currentPosition.getColumn());
    }
}
