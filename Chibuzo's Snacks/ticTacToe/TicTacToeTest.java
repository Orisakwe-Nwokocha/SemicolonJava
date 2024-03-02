package ticTacToe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;
    private final Type empty = Type.EMPTY;
    private final Type[][] testPositionBoard = new Type[][]{{empty, empty, empty},
            {empty, empty, empty},
            {empty, empty, empty}};;

    @BeforeEach
    public void initializeGame() {
        game = new TicTacToe(1, 2);
    }

    @Test
    public void testThatThereAreTwoPlayersInGame() {
        Player[] players = game.getPlayers();
        int numberOfPlayers = players.length;

        assertEquals(2, numberOfPlayers);
    }

    @Test
    public void testThatPlayersHaveUniqueId() {
        Player[] players = game.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        assertEquals(1, playerOne.getId());
        assertEquals(2, playerTwo.getId());
    }

    @Test
    public void testThatGameHasPositionBoard() {
        Type[][] positionBoard = game.getPositionBoard();

        assertArrayEquals(testPositionBoard, positionBoard);
    }

    @Test
    public void testThatBoardIsFilledWithDummyEnumValuesByDefault() {
        Type[][] positionBoard = game.getPositionBoard();

        assertArrayEquals(testPositionBoard, positionBoard);
    }


    @Test
    public void testThatTicTacToeGameCanMarkPosition() {
        Type[][] positionBoard = game.getPositionBoard();
        game.markPosition(1, 1);
        assertNotEquals(Type.EMPTY, positionBoard[0][0]);
    }

    @Test
    public void testThatPlayerOneHasEnumValueX() {
        Player[] players = game.getPlayers();
        Player playerOne = players[0];

        assertEquals(Type.X, playerOne.getType());
    }

    @Test
    public void testThatPlayerTwoHasEnumValueO() {
        Player[] players = game.getPlayers();
        Player playerTwo = players[1];

        assertEquals(Type.O, playerTwo.getType());
    }

    @Test
    public void testThatPlayersCanChooseAnyEnumConstant_playerOneHasEnumValueO_playerTwoHasEnumValueX() {
        game = new TicTacToe(2, 1);
        Player[] players = game.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        assertEquals(Type.O, playerOne.getType());
        assertEquals(Type.X, playerTwo.getType());
    }

    @Test
    public void playerMarksNonEmptyPosition_InvalidPositionExceptionIsThrownTest() {
        game.markPosition(1, 1);
        assertThrows(InvalidPositionException.class, () -> game.markPosition(1, 1));
    }

    @Test
    public void playerMarksNonEmptyPosition_InvalidPositionExceptionIsThrown_testErrorMessage() {
        game.markPosition(1, 1);

        try{
            game.markPosition(1, 1);
        }
        catch(InvalidPositionException e){
            assertEquals("Position is already taken.", e.getMessage());
        }
    }

    @Test
    public void testThatPlayersCanPlayGame() {

    }


}