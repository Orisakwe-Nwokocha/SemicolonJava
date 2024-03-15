package turtleGraphics;

public enum Direction {
    EAST("NORTH", "SOUTH"),
    NORTH("WEST", "EAST"),
    WEST("SOUTH", "NORTH"),
    SOUTH("EAST", "WEST");

    private final String left;
    private final String right;

    Direction(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public Direction turnLeft() {
        return Direction.valueOf(this.left);
    }

    public Direction turnRight() {
        return Direction.valueOf(this.right);
    }
}
