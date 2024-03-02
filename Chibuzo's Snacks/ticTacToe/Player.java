package ticTacToe;

public class Player {
    private final int id;
    private final Type type;

    public Player(int id) {
        this.id = id;
        this.type = id == 1 ? Type.X : Type.O;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}
