package ticTacToe;


import java.util.Arrays;

public class TicTacToe {

    private final Player[] players = new Player[2];
    private final Type[][] positionBoard;

    public TicTacToe(int playerOneId, int playerTwoId) {
         positionBoard = new Type[3][3];

         players[0] = new Player(playerOneId);;
         players[1] = new Player(playerTwoId);;

         for (Type[] position: positionBoard) Arrays.fill(position, Type.EMPTY);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Type[][] getPositionBoard() {
        return positionBoard;
    }

    public void markPosition(int playerId, int square) {
        validate(square);
        Player player = players[playerId - 1];
        positionBoard[square - 1][square - 1] = player.getType();

    }

    private void validate(int square) {
        boolean isFilled = positionBoard[square - 1][square - 1] != Type.EMPTY;
        if (isFilled) throw new InvalidPositionException("Position is already taken.");
    }
}
