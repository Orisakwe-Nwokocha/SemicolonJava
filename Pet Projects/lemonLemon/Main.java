package lemonLemon;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    private static LemonLemon lemonLemon;
    private static Player player;
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        String numberOfPlayers = JOptionPane.showInputDialog( "Enter the number of players: ");

        try {
            lemonLemon = new LemonLemon(Integer.parseInt(numberOfPlayers));
        }
        catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            startApp();
        }
        finally {
            String playerId = JOptionPane.showInputDialog("Enter your player ID: ");
            player = new Player(Integer.parseInt(playerId));

            playGame();
        }
    }

    private static void playGame() {
        try {
            generateRandomActivePlayers();
        }
        catch (RuntimeException ignored) {}
        finally {
            String eliminatedPlayerId = JOptionPane.showInputDialog("Enter eliminated player ID: ");
            player.play(lemonLemon, Integer.parseInt(eliminatedPlayerId));
            displayEliminatedPlayers();
            displayWinners();
            while (lemonLemon.getWinners() == null) playGame();

        }

//        JOptionPane.showMessageDialog(4null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);










    }

    private static void displayWinners() {
        if (lemonLemon.getWinners() != null) JOptionPane.showMessageDialog(null, lemonLemon.getWinners(),
                "Winners", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayEliminatedPlayers() {
        System.out.println(Arrays.toString(lemonLemon.getEliminatedPlayers()));
        JOptionPane.showMessageDialog(null, lemonLemon.getEliminatedPlayers());
    }

    private static void generateRandomActivePlayers() {
        JOptionPane.showMessageDialog(null, lemonLemon.generateTwoLemonNumbers(),
                "Call these players: ", JOptionPane.INFORMATION_MESSAGE);
    }
}

