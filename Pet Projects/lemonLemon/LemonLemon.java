package lemonLemon;

import java.security.SecureRandom;
import java.util.ArrayList;

public class LemonLemon {
    private final Player[] players;
    private final ArrayList<Player> eliminatedPlayers;
    private Player[] winners = new Player[2];

    public LemonLemon(int numberOfPlayers) {
        validateNumberOfPlayers(numberOfPlayers);

        players = new Player[numberOfPlayers];
        eliminatedPlayers = new ArrayList<>();

        addPlayers(numberOfPlayers);
    }

    private static void validateNumberOfPlayers(int numberOfPlayers) {
        boolean isValid = numberOfPlayers >= 4;

        if (!isValid) throw new IllegalArgumentException("Number of players is not enough for game");
    }

    private void addPlayers(int numberOfPlayers) {
        for (int count = 0; count < numberOfPlayers; count++) players[count] = new Player(count + 1);
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayer(int playerId) {
        return players[playerId - 1];
    }

    public void eliminatePlayer(int playerId) {
        players[playerId - 1].changeStatus();

        Player player = getPlayer(playerId);

        boolean condition = contains(playerId) && !containsEliminatedPlayer(player);
        if (condition) eliminatedPlayers.add(player);

        if (condition()) determineWinners();
    }

    private boolean containsEliminatedPlayer(Player player) {
        for (Player eliminatedPlayer : eliminatedPlayers) if (eliminatedPlayer.equals(player)) return true;
        return false;
    }

    private boolean contains(int playerId) {
        for (Player player : players) if (player.getId() == playerId) return true;
        return false;
    }

    private boolean condition() {
        return (players.length - eliminatedPlayers.size()) == 2;
    }

    private void determineWinners() {
        ArrayList<Player> temp = new ArrayList<>();

        for (Player player : players) {
            if (!player.isEliminated()) temp.add(player);
            if (temp.size() == 2) break;
        }

        winners = temp.toArray(new Player[0]);
    }

    public String[] generateTwoLemonNumbers() {
        validateNumberOfPlayers();

        String[] output = new String[2];

        SecureRandom secureRandom = new SecureRandom();
        int randomNumber1 = generateValidRandomNumber(secureRandom);
        int randomNumber2 = generateValidRandomNumber(secureRandom);

        output[0] = ("Lemon" + randomNumber1);
        output[1] = ("Lemon" + randomNumber2);

        return output;
    }

    private int generateValidRandomNumber(SecureRandom secureRandom) {
        int randomNumber = secureRandom.nextInt(1, players.length);
        Player randomPlayer = getPlayer(randomNumber);

        if (randomPlayer.isEliminated()) return generateValidRandomNumber(secureRandom);

        return randomNumber;
    }

    private void validateNumberOfPlayers() {
        boolean condition = (players.length - eliminatedPlayers.size()) < 4;

        if (condition) throw new IllegalStateException("Number of players is less than 4");
    }

    public Player[] getWinners() {

        if (condition()) return winners;
        return null;
    }

    public Player[] getEliminatedPlayers() {
        return eliminatedPlayers.toArray(new Player[0]);
    }
}