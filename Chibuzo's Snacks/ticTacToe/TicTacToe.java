package ticTacToe;


import java.util.Arrays;

public class TicTacToe {

    private final Player[] players = new Player[2];
    private final Type[][] positionBoard;
    private Player winner;
    private int numberOfXs = 0;
    private int numberOfOs = 0;

    public TicTacToe(int playerOneId, int playerTwoId) {
         positionBoard = new Type[3][3];

         Type playerOneType = playerOneId == 1 ? Type.X : Type.O;
         Type playerTwoType = playerTwoId == 2 ? Type.O : Type.X;

         players[0] = new Player(1, playerOneType);
         players[1] = new Player(2, playerTwoType);

         for (Type[] position: positionBoard) Arrays.fill(position, Type.EMPTY);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Type[][] getPositionBoard() {
        return positionBoard;
    }

    public void markPosition(int playerId, int square) {
        validateRange(square);

        int row = square % 3 == 0 ? (square / 3) - 1 : square / 3;
        int column = square % 3 == 0 ? (square / 3) - 1 : (square % 3) - 1;
        if (square % 3 == 0) column = 2;

        validate(row, column);

        Player player = getPlayer(playerId);
        positionBoard[row][column] = player.type();

        checkForWinner();
    }

    private Player getPlayer(int playerId) {
        if (players[0].id() == playerId) return players[0];
        return players[1];
    }

    private void checkForWinner() {

        for (int index1 = 0; index1 < 3; index1++) {
            if (isHorizontal(index1)) break;
            numberOfXs = 0;
            numberOfOs = 0;

            if (isVertical(index1)) break;
            numberOfXs = 0;
            numberOfOs = 0;

            if (isDiagonalRight()) break;
            numberOfXs = 0;
            numberOfOs = 0;

            if (isDiagonalLeft()) break;
            numberOfXs = 0;
            numberOfOs = 0;
        }
    }

    private boolean isDiagonalLeft() {
        int index = 0;
        while (index < 3) {
            if (positionBoard[index][2 - index] == Type.X) numberOfXs++;
            if (positionBoard[index][2 - index] == Type.O) numberOfOs++;
            index++;
        }

        if (numberOfXs == 3) {
            winner = getPlayer(Type.X);
            return true;
        }
        if (numberOfOs == 3) {
            winner = getPlayer(Type.O);
            return true;
        }

        return false;
    }

    private boolean isDiagonalRight() {
        int index = 0;
        while (index < 3) {
            if (positionBoard[index][index] == Type.X) numberOfXs++;
            if (positionBoard[index][index] == Type.O) numberOfOs++;
            index++;
        }

        if (numberOfXs == 3) {
            winner = getPlayer(Type.X);
            return true;
        }
        if (numberOfOs == 3) {
            winner = getPlayer(Type.O);
            return true;
        }

        return false;
    }


    private boolean isVertical(int index1) {

        for (int index2 = 0; index2 < 3; index2++) {
            if (positionBoard[index2][index1] == Type.X) numberOfXs++;
            if (positionBoard[index2][index1] == Type.O) numberOfOs++;
        }

        if (numberOfXs == 3) {
            winner = getPlayer(Type.X);
            return true;
        }
        if (numberOfOs == 3) {
            winner = getPlayer(Type.O);
            return true;
        }

        return false;
    }

    private boolean isHorizontal(int index1) {
        for (int index2 = 2; index2 >= 0; index2--) {
            if (positionBoard[index1][index2] == Type.X) numberOfXs++;
            if (positionBoard[index1][index2] == Type.O) numberOfOs++;
        }

        if (numberOfXs == 3) {
            winner = getPlayer(Type.X);
            return true;
        }
        if (numberOfOs == 3) {
            winner = getPlayer(Type.O);
            return true;
        }

        return false;
    }


    private Player getPlayer(Type type) {
        return players[0].type() == type ? players[0] : players[1];
    }

    private void validateRange(int square) {
        boolean isOutOfRange = square < 1 || square > 9;
        if (isOutOfRange) throw new IllegalArgumentException("Square must be between 1 and 9");
    }

    private void validate(int row, int column) {
        boolean isFilled = positionBoard[row][column] != Type.EMPTY;
        if (isFilled) throw new InvalidPositionException("Position is already taken.");
    }

    public Player getWinner() {
        return winner;
    }

    public String displayBoard() {
        String horizontal = "=".repeat(13);
        String vertical = "|";
        String blank = " ";

        StringBuilder board = new StringBuilder();


        for (int row = 0; ; row++) {
            board.append(horizontal).append("\n");

            displayBoard(row, blank, board, vertical);
            board.append(vertical).append("\n");

            if (row == 2) return board.append(horizontal).toString();
        }
    }

    private void displayBoard(int row, String blank, StringBuilder board, String vertical) {
        for (int column = 0; column < 3; column++) {
            Type type = positionBoard[row][column];
            String position = type == Type.EMPTY ? blank : type.toString();

            board.append(vertical).append(blank).append(position).append(blank);
        }
    }

    public boolean isBoardFull() {
        for (Type[] types : positionBoard) for (Type type : types) if (type == Type.EMPTY) return false;
        return true;
    }
}
