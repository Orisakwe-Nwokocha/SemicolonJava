package ticTacToe;

public record Player(int id, Type type) {

    public void play(TicTacToe ticTacToeGame, int square) {
        ticTacToeGame.markPosition(this.id, square);
    }

    @Override
    public String toString() {
        return String.format("Player %d", id);
    }
}
