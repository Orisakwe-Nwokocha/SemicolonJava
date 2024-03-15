package turtleGraphics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static turtleGraphics.Direction.*;

public class TurtleTest {
    private Turtle turtle;
    private Sketchpad sketchpad;
    private final int[][] testFloor = new int[20][20];


    @BeforeEach
    public void initialiseTurtle() {
        turtle = new Turtle();
        sketchpad = new Sketchpad(20, 20);
    }

    @Test
    public void testThatTurtlePenIsUp() {
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void givenTurtlePenIsUp_putPenDown_penIsDownTest() {
        assertTrue(turtle.isPenUp());

        turtle.penDown();
        assertFalse(turtle.isPenUp());
    }

    @Test
    public void givenTurtlePenIsDown_putPenUp_penIsUpTest() {
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.penUp();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void testThatTurtleIsFacingEastByDefault() {
        assertSame(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeftWhileFacingEast_turtleIsNowFacingNorth() {
        assertSame(EAST, turtle.getCurrentDirection());

        turtle.turnLeft();
        assertSame(NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeftWhileFacingNorth_turtleIsNowFacingWest() {
        assertSame(EAST, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertSame(NORTH, turtle.getCurrentDirection());

        turtle.turnLeft();
        assertSame(WEST, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeftWhileFacingWest_turtleIsNowFacingSouth() {
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(WEST, turtle.getCurrentDirection());

        turtle.turnLeft();
        assertSame(SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeftWhileFacingSouth_turtleIsNowFacingEast() {
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(SOUTH, turtle.getCurrentDirection());

        turtle.turnLeft();
        assertSame(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnRightWhileFacingEast_turtleIsNowFacingSouth() {
        assertSame(EAST, turtle.getCurrentDirection());

        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnRightWhileFacingSouth_turtleIsNowFacingWest() {
        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());

        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnRightWhileFacingWest_turtleIsNowFacingNorth() {
        turtle.turnRight();
        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());

        turtle.turnRight();
        assertSame(NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnRightWhileFacingNorth_turtleIsNowFacingEast() {
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertSame(NORTH, turtle.getCurrentDirection());

        turtle.turnRight();
        assertSame(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanMoveForwardWhileFacingEast() {
        assertSame(EAST, turtle.getCurrentDirection());
        assertEquals(new Position(0, 0), turtle.getCurrentPosition());

        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanWriteOnSketchpadWhileFacingEast() {
        assertSame(EAST, turtle.getCurrentDirection());
        assertEquals(new Position(0, 0), turtle.getCurrentPosition());

        int[][] floor = sketchpad.getFloor();
        assertArrayEquals(testFloor, floor);
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.moveForward(5, sketchpad);
        assertEquals(1, floor[0][0]);
        assertEquals(1, floor[0][1]);
        assertEquals(1, floor[0][2]);
        assertEquals(1, floor[0][3]);
        assertEquals(1, floor[0][4]);

        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveForwardWhileFacingSouth() {
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(SOUTH, turtle.getCurrentDirection());

        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 4), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanWriteOnSketchpadWhileFacingSouth() {
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(SOUTH, turtle.getCurrentDirection());

        int[][] floor = sketchpad.getFloor();
        assertArrayEquals(testFloor, floor);
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.moveForward(5, sketchpad);
        assertEquals(1, floor[0][4]);
        assertEquals(1, floor[1][4]);
        assertEquals(1, floor[2][4]);
        assertEquals(1, floor[3][4]);
        assertEquals(1, floor[4][4]);

        assertEquals(new Position(4, 4), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveForwardWhileFacingWest() {
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(WEST, turtle.getCurrentDirection());

        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 0), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanWriteOnSketchpadWhileFacingWest() {
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(WEST, turtle.getCurrentDirection());

        int[][] floor = sketchpad.getFloor();
        assertArrayEquals(testFloor, floor);
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.moveForward(5, sketchpad);
        assertEquals(1, floor[4][4]);
        assertEquals(1, floor[4][3]);
        assertEquals(1, floor[4][2]);
        assertEquals(1, floor[4][1]);
        assertEquals(1, floor[4][0]);

        assertEquals(new Position(4, 0), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveForwardWhileFacingNorth() {
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 0), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(NORTH, turtle.getCurrentDirection());

        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(0, 0), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanWriteOnSketchpadWhileFacingNorth() {
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(4, 0), turtle.getCurrentPosition());
        turtle.turnRight();
        assertEquals(NORTH, turtle.getCurrentDirection());

        int[][] floor = sketchpad.getFloor();
        assertArrayEquals(testFloor, floor);
        turtle.penDown();
        assertFalse(turtle.isPenUp());

        turtle.moveForward(5, sketchpad);
        assertEquals(1, floor[4][0]);
        assertEquals(1, floor[3][0]);
        assertEquals(1, floor[2][0]);
        assertEquals(1, floor[1][0]);
        assertEquals(1, floor[0][0]);

        assertEquals(new Position(0, 0), turtle.getCurrentPosition());
    }

    @Test
    public void testThatSketchpadCanDisplayFloor() {
        int[][] floor = sketchpad.getFloor();
        assertArrayEquals(testFloor, floor);

        String displayedFloor = sketchpad.displayFloor();
        System.out.println(displayedFloor);

        turtle.penDown();
        assertFalse(turtle.isPenUp());
        turtle.moveForward(20, sketchpad);
        turtle.turnRight();
        turtle.moveForward(20, sketchpad);
        turtle.turnRight();
        turtle.moveForward(20, sketchpad);
        turtle.turnRight();
        turtle.moveForward(20, sketchpad);
        assertEquals(NORTH, turtle.getCurrentDirection());
        assertEquals(new Position(0, 0), turtle.getCurrentPosition());

        displayedFloor = sketchpad.displayFloor();
        System.out.println(displayedFloor);
    }

    @Test
    public void testThatTurtleMovesForwardOutsideFloorLengthWhileFacingEast_InvalidMoveExceptionIsThrown() {
        sketchpad = new Sketchpad(5, 5);

        assertSame(EAST, turtle.getCurrentDirection());
        assertEquals(new Position(0, 0), turtle.getCurrentPosition());
        turtle.moveForward(3, sketchpad);
        assertEquals(new Position(0, 2), turtle.getCurrentPosition());

        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(4, sketchpad));
        assertEquals(new Position(0, 2), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleMovesForwardOutsideFloorLengthWhileFacingSouth_InvalidMoveExceptionIsThrown() {
        sketchpad = new Sketchpad(5, 5);

        turtle.moveForward(3, sketchpad);
        assertEquals(new Position(0, 2), turtle.getCurrentPosition());
        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());
        turtle.moveForward(3, sketchpad);
        assertEquals(new Position(2, 2), turtle.getCurrentPosition());

        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(4, sketchpad));
        assertEquals(new Position(2, 2), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleMovesForwardOutsideFloorLengthWhileFacingWest_InvalidMoveExceptionIsThrown() {
        sketchpad = new Sketchpad(5, 5);

        turtle.moveForward(3, sketchpad);
        turtle.moveForward(3, sketchpad);
        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        turtle.moveForward(4, sketchpad);
        assertEquals(new Position(3, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());
        turtle.moveForward(2, sketchpad);
        assertEquals(new Position(3, 3), turtle.getCurrentPosition());

        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(5, sketchpad));
        assertEquals(new Position(3, 3), turtle.getCurrentPosition());
    }

    @Test
    public void testThatTurtleMovesForwardOutsideFloorLengthWhileFacingNorth_InvalidMoveExceptionIsThrown() {
        sketchpad = new Sketchpad(5, 5);

        turtle.moveForward(3, sketchpad);
        turtle.moveForward(3, sketchpad);
        assertEquals(new Position(0, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        turtle.moveForward(4, sketchpad);
        assertEquals(new Position(3, 4), turtle.getCurrentPosition());
        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());
        turtle.moveForward(5, sketchpad);
        assertEquals(new Position(3, 0), turtle.getCurrentPosition());
        turtle.turnRight();
        turtle.moveForward(2, sketchpad);
        assertEquals(new Position(2, 0), turtle.getCurrentPosition());

        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(4, sketchpad));
        assertEquals(new Position(2, 0), turtle.getCurrentPosition());
    }

    @Test
    public void turtleMovesForwardWithNonPositiveNumberOfSteps_InvalidMoveExceptionIsThrown() {
        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(0, sketchpad));
        assertThrows(InvalidMoveException.class, () -> turtle.moveForward(-1, sketchpad));
    }

    @Test
    public void testInvalidMoveExceptionMessage1() {
        sketchpad = new Sketchpad(5, 5);

        try {
            turtle.moveForward(0, sketchpad);
        }
        catch (InvalidMoveException e) {
            assertEquals(e.getMessage(), "Number of steps must be greater than 0");
        }
    }

    @Test
    public void testInvalidMoveExceptionMessage2() {
        sketchpad = new Sketchpad(5, 5);

        try {
            turtle.moveForward(6, sketchpad);
        }
        catch (InvalidMoveException e) {
            assertEquals(e.getMessage(), "Invalid move. PLease try again.");
        }
    }
}