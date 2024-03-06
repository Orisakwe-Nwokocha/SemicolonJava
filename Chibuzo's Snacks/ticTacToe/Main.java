package ticTacToe;

import javax.swing.*;
import java.security.SecureRandom;

public class Main {
    private static TicTacToe game;
    private static boolean isInvalidMove = true;

    public static void main(String[] args) {
        startApp();

    }

    private static void startApp() {
        print("Game loading...", "Welcome, players");

        selectType();
    }

    private static void selectType() {
        int userChoice = getChoice("Player 1, do you want to use X?");

        if (userChoice == JOptionPane.YES_OPTION) game = new TicTacToe(1, 2);
        else game = new TicTacToe(2, 1);

        Player playerOne = game.getPlayers()[0];
        Player playerTwo = game.getPlayers()[1];

        print("Player 1 is " + playerOne.cellType(), "Info");
        print("Player 2 is " + playerTwo.cellType(), "Info");

        playGame();
    }

    private static void playGame() {
        int choice = getChoice("Do you want to play against computer?");

        Player playerOne = game.getPlayers()[0];
        print(game.displayBoard(), "Display board");

        if (choice == JOptionPane.YES_OPTION) playVsComputer(playerOne);
        playVsHuman(playerOne);
    }

    private static void playVsComputer(Player playerOne) {
        Player computer = game.getPlayers()[1];

        playerOneMove(playerOne);

        computerMove(computer);

        boolean gameIsOn = !game.isBoardFull();
        if (gameIsOn) playVsComputer(playerOne);
    }

    private static void computerMove(Player computer) {
        SecureRandom random = new SecureRandom();

        isInvalidMove = true;
        while (isInvalidMove) {
            int computerMove = random.nextInt(1, 10);
            try {
                computer.play(game, computerMove);
                print(game.displayBoard(), "Display board");

                checkGameStatus();
                isInvalidMove = false;
            }
            catch (RuntimeException ignored) {}
        }
    }

    private static void playerOneMove(Player playerOne) {
        isInvalidMove = true;
        while (isInvalidMove) {
            try {
                String playerOnePosition = input("Player 1, select a position (1-9)");
                playerOne.play(game, Integer.parseInt(playerOnePosition));
                print(game.displayBoard(), "Display board");

                checkGameStatus();
                isInvalidMove = false;
            }
            catch (RuntimeException e) {
                displayErrorMessage(e);
            }
        }
    }

    private static void playVsHuman(Player playerOne) {
        Player playerTwo = game.getPlayers()[1];

        playerOneMove(playerOne);
        playerTwoMove(playerTwo);

        boolean gameIsOn = !game.isBoardFull();
        if (gameIsOn) playVsHuman(playerOne);
    }

    private static void playerTwoMove(Player playerTwo) {
        isInvalidMove = true;
        while (isInvalidMove) {
            try {
                String playerTwoPosition = input("Player 2, select a position (1-9)");
                playerTwo.play(game, Integer.parseInt(playerTwoPosition));
                print(game.displayBoard(), "Display board");

                checkGameStatus();
                isInvalidMove = false;
            }
            catch (RuntimeException e) {
                displayErrorMessage(e);
            }
        }
    }

    private static void displayErrorMessage(RuntimeException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void checkGameStatus() {
        boolean isWinnerNull = game.getWinner() == null;

        if (!isWinnerNull) declareWinner();
        if (game.isBoardFull()) declareDraw();
    }

    private static void declareDraw() {
        print("Game ended in a draw", "Status");
        print(game.displayBoard(), "Display board");
        exit();
    }

    private static void exit() {
        print("Thank you for playing our game!!!", "Goodbye");
        System.exit(0);
    }

    private static void declareWinner() {
        print(game.getWinner().toString() + " is the winner!!!", "Champion");
        print(game.displayBoard(), "Display board");
        exit();
    }

    private static void print(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String input(String message) {
        return JOptionPane.showInputDialog(null, message, "Make your move", JOptionPane.QUESTION_MESSAGE);
    }

    private static int getChoice(String message) {
        return JOptionPane.showConfirmDialog(null, message,
                "Select option", JOptionPane.YES_NO_OPTION);
    }

}
