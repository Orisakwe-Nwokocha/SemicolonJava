package lemonLemon;

public class LemonLemon {
    private final Player[] players;

    public LemonLemon(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        addPlayers(numberOfPlayers);
    }

    private void addPlayers(int numberOfPlayers) {
        for (int count = 0; count < numberOfPlayers; count++) {
            players[count] = new Player(count + 1);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayer(int playerId) {
        return players[playerId - 1];
    }

    public void eliminatePlayer(int playerId) {
        players[playerId - 1].changeStatus();
    }
}
