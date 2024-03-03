package ticTacToe;

public record Player(int id, CellType cellType) {

    public void play(TicTacToe ticTacToeGame, int square) {
        ticTacToeGame.markPosition(this.id, square);
    }

    @Override
    public String toString() {
        return String.format("Player %d", id);
    }
}
