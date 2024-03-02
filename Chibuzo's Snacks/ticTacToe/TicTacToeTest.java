package ticTacToe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe ticTacToeGame;
    private final Type empty = Type.EMPTY;
    private final Type[][] testPositionBoard = new Type[][]{{empty, empty, empty},
            {empty, empty, empty},
            {empty, empty, empty}};;

    @BeforeEach
    public void initializeGame() {
        ticTacToeGame = new TicTacToe(1, 2);
    }

    @Test
    public void testThatThereAreTwoPlayersInGame() {
        Player[] players = ticTacToeGame.getPlayers();
        int numberOfPlayers = players.length;

        assertEquals(2, numberOfPlayers);
    }

    @Test
    public void testThatPlayersHaveUniqueId() {
        Player[] players = ticTacToeGame.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        assertEquals(1, playerOne.id());
        assertEquals(2, playerTwo.id());
    }

    @Test
    public void testThatGameHasPositionBoard() {
        Type[][] positionBoard = ticTacToeGame.getPositionBoard();

        assertArrayEquals(testPositionBoard, positionBoard);
    }

    @Test
    public void testThatBoardIsFilledWithDummyEnumValuesByDefault() {
        Type[][] positionBoard = ticTacToeGame.getPositionBoard();

        assertArrayEquals(testPositionBoard, positionBoard);
    }

    @Test
    public void testThatPlayerOneHasEnumValueX() {
        Player[] players = ticTacToeGame.getPlayers();
        Player playerOne = players[0];

        assertEquals(Type.X, playerOne.type());
    }

    @Test
    public void testThatPlayerTwoHasEnumValueO() {
        Player[] players = ticTacToeGame.getPlayers();
        Player playerTwo = players[1];

        assertEquals(Type.O, playerTwo.type());
    }

    @Test
    public void testThatPlayersCanChooseAnyEnumConstant_playerOneHasEnumValueO_playerTwoHasEnumValueX() {
        ticTacToeGame = new TicTacToe(2, 1);
        Player[] players = ticTacToeGame.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        assertEquals(Type.O, playerOne.type());
        assertEquals(Type.X, playerTwo.type());
    }

    @Test
    public void testThatGameCanMarkPosition() {
        Type[][] positionBoard = ticTacToeGame.getPositionBoard();
        ticTacToeGame.markPosition(1, 1);
        assertNotEquals(Type.EMPTY, positionBoard[0][0]);
        assertEquals(Type.X, positionBoard[0][0]);

        ticTacToeGame.markPosition(2, 5);
        assertNotEquals(Type.EMPTY, positionBoard[1][1]);
        assertEquals(Type.O, positionBoard[1][1]);

        ticTacToeGame.markPosition(1, 9);
        assertNotEquals(Type.EMPTY, positionBoard[2][2]);
        assertEquals(Type.X, positionBoard[2][2]);
    }

    @Test
    public void playerMarksPositionOutOfRange_illegalArgumentExceptionIsThrownTest() {
        assertThrows(IllegalArgumentException.class, () -> ticTacToeGame.markPosition(1, 0));
        assertThrows(IllegalArgumentException.class, () -> ticTacToeGame.markPosition(1, 10));
    }

    @Test
    public void playerMarksNonEmptyPosition_invalidPositionExceptionIsThrownTest() {
        ticTacToeGame.markPosition(1, 1);
        assertThrows(InvalidPositionException.class, () -> ticTacToeGame.markPosition(1, 1));
    }

    @Test
    public void playerMarksNonEmptyPosition_InvalidPositionExceptionIsThrown_testErrorMessage() {
        ticTacToeGame.markPosition(1, 1);

        try{
            ticTacToeGame.markPosition(1, 1);
        }
        catch(InvalidPositionException e){
            assertEquals("Position is already taken.", e.getMessage());
        }
    }

    @Test
    public void testThatPlayersCanPlayGame() {
        Player[] players = ticTacToeGame.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        for (int count = 1; count <= 9; count +=2) {
            playerOne.play(ticTacToeGame, count);
            if (count == 9) break;
            playerTwo.play(ticTacToeGame, count + 1);
        }

        Type[][] positionBoard = ticTacToeGame.getPositionBoard();
        assertNotEquals(Type.EMPTY, positionBoard[0][0]);
        assertNotEquals(Type.EMPTY, positionBoard[1][1]);
        assertNotEquals(Type.EMPTY, positionBoard[2][2]);
    }

    @Test
    public void testThatGameCanDetermineWinnerHorizontallyForEnumX() {
        ticTacToeGame.markPosition(1, 1);
        ticTacToeGame.markPosition(1, 2);
        ticTacToeGame.markPosition(1, 3);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.X, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerHorizontallyForEnumO() {
        ticTacToeGame.markPosition(2, 1);
        ticTacToeGame.markPosition(2, 2);
        ticTacToeGame.markPosition(2, 3);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.O, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerVerticallyForEnumX() {
        ticTacToeGame.markPosition(1, 1);
        ticTacToeGame.markPosition(1, 4);
        ticTacToeGame.markPosition(1, 7);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.X, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerVerticallyForEnumO() {
        ticTacToeGame.markPosition(2, 1);
        ticTacToeGame.markPosition(2, 4);
        ticTacToeGame.markPosition(2, 7);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.O, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerLeftDiagonalAxisForEnumX() {
        ticTacToeGame.markPosition(1, 1);
        ticTacToeGame.markPosition(1, 5);
        ticTacToeGame.markPosition(1, 9);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.X, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerLeftDiagonalAxisForEnumO() {
        ticTacToeGame.markPosition(2, 1);
        ticTacToeGame.markPosition(2, 5);
        ticTacToeGame.markPosition(2, 9);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.O, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerRightDiagonalAxisForEnumX() {
        ticTacToeGame.markPosition(1, 3);
        ticTacToeGame.markPosition(1, 5);
        ticTacToeGame.markPosition(1, 7);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.X, ticTacToeGame.getWinner().type());
    }

    @Test
    public void testThatGameCanDetermineWinnerRightDiagonalAxisForEnumO() {
        ticTacToeGame.markPosition(2, 3);
        ticTacToeGame.markPosition(2, 5);
        ticTacToeGame.markPosition(2, 7);

        assertNotNull(ticTacToeGame.getWinner());
        assertEquals(Type.O, ticTacToeGame.getWinner().type());
    }

    @Test
    public void displayBoardTest() {
        Player[] players = ticTacToeGame.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        for (int count = 1; count <= 9; count += 2) {
            playerOne.play(ticTacToeGame, count);
            System.out.println(ticTacToeGame.displayBoard());

            if (count == 9) break;
            playerTwo.play(ticTacToeGame, count + 1);

            if (!ticTacToeGame.isBoardFull()) System.out.println(ticTacToeGame.displayBoard());
        }

        System.out.println(ticTacToeGame.displayBoard());
        System.out.println(ticTacToeGame.getWinner());
    }


}