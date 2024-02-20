package lemonLemon;

public class Player {
    private boolean isEliminated;
    private final int id;

    public Player(int id) {
        this.id = id;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public int getId() {
        return id;
    }

    public void changeStatus() {
        isEliminated = true;
    }

    public String toString() {
        return String.format("Player%d: %s", id, (isEliminated ? "eliminated" : "active"));
    }

    public void play(LemonLemon lemonLemon, int playerId) {
        lemonLemon.eliminatePlayer(playerId);
    }
}
