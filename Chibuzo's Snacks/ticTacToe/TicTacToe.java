package ticTacToe;


import java.util.Arrays;

public class TicTacToe {

    private final Player[] players = new Player[2];
    private final CellType[][] positionBoard;
    private Player winner;

    public TicTacToe(int playerOneId, int playerTwoId) {
         positionBoard = new CellType[3][3];

         CellType playerOneCellType = playerOneId == 1 ? CellType.X : CellType.O;
         CellType playerTwoCellType = playerTwoId == 2 ? CellType.O : CellType.X;

         players[0] = new Player(1, playerOneCellType);
         players[1] = new Player(2, playerTwoCellType);

         for (CellType[] position: positionBoard) Arrays.fill(position, CellType.EMPTY);
    }

    public Player[] getPlayers() {
        return players;
    }

    public CellType[][] getPositionBoard() {
        return positionBoard;
    }

    public void markPosition(int playerId, int square) {
        validateRange(square);

        int row = square % 3 == 0 ? (square / 3) - 1 : square / 3;
        int column = square % 3 == 0 ? 2 : (square % 3) - 1;
        validate(row, column);

        Player player = getPlayer(playerId);
        positionBoard[row][column] = player.cellType();

        if (isWinner()) winner = player;
    }

    private Player getPlayer(int playerId) {
        if (players[0].id() == playerId) return players[0];
        return players[1];
    }

    private boolean isWinner() {
        for (int index = 0; index < 3; index++) {
            if (isHorizontal(index)) return true;
            else if (isVertical(index)) return true;
        }

        if (isLeftDiagonal()) return true;
        else return isRightDiagonal();
    }

    private boolean isRightDiagonal() {
        return isWinner(0, -2, 1, -1);
    }

    private boolean isLeftDiagonal() {
        return isWinner(0, 0, 1, 1);
    }

    private boolean isVertical(int index) {
        return isWinner(0, index, 1, 0);
    }

    private boolean isHorizontal(int index) {
        return isWinner(index, 0, 0, 1);
    }

    private boolean isWinner(int startRow, int startColumn, int rowIncrement, int columnIncrement) {
        int numberOfXs = 0;
        int numberOfOs = 0;

        for (int index = 0; index < 3; index++) {
            int row = (startRow + index) * rowIncrement;
            int column = (startColumn + index) * columnIncrement;

            CellType type = positionBoard[row][column];

            if (type == CellType.X) numberOfXs++;
            else if (type == CellType.O) numberOfOs++;
        }

        if (numberOfXs == 3) return true;
        else return numberOfOs == 3;
    }

    private void validateRange(int square) {
        boolean isOutOfRange = square < 1 || square > 9;
        if (isOutOfRange) throw new IllegalArgumentException("Square must be between 1 and 9");
    }

    private void validate(int row, int column) {
        boolean isFilled = positionBoard[row][column] != CellType.EMPTY;
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
            CellType cellType = positionBoard[row][column];
            String position = cellType == CellType.EMPTY ? blank : cellType.toString();

            board.append(vertical).append(blank).append(position).append(blank);
        }
    }

    public boolean isBoardFull() {
        for (CellType[] cellTypes : positionBoard) for (CellType cellType : cellTypes) if (cellType == CellType.EMPTY) return false;
        return true;
    }
}
