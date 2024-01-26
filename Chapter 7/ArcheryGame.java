import java.security.SecureRandom;
import java.util.Arrays;

public class ArcheryGame{

	private Player[] players;
	private int[][] scoreBoard;
	private int[] totalOfScores;
	private Player winner;

	public ArcheryGame(){
		Player playerOne = new Player(1);
		Player playerTwo = new Player(2);
		Player playerThree = new Player(3);
		Player playerFour = new Player(4);

		players = new Player[4];

		players[0] = playerOne;
		players[1] = playerTwo;
		players[2] = playerThree;
		players[3] = playerFour; 

		scoreBoard = new int[4][3];

        for (int[] scores : scoreBoard) {
            Arrays.fill(scores, -1);
        }

		totalOfScores = new int[4];
	}

	public Player[] getPlayers(){
		return players;
	}

	public int[][] getScoreBoard(){
		return scoreBoard;
	}

	private void calculateTotalScores() {
		for (int row = 0; row < scoreBoard.length; row++) {
			for (int column = 0; column < scoreBoard[row].length; column++) {
				totalOfScores[row] += scoreBoard[row][column];
			}
		}
	}

	private void checkForWinner() {
		int maxScore = 0;

		for (int index = 0; index < totalOfScores.length; index++) {
			if (totalOfScores[index] > maxScore) {
				maxScore = totalOfScores[index];
				winner = players[index];
			}
		}
	}

	public Player getWinner() {
		return winner;
	}

	public void markScoreBoard(int playerId){
		int score = generateScore();

		int[] playerRow = scoreBoard[playerId - 1];

		for (int counter = 0; counter < playerRow.length; counter++) {
			if (playerRow[counter] == -1) {
				playerRow[counter] = score;
				break;
			}
		}

		calculateTotalScores();
		checkForWinner();
	}

	private int generateScore(){
		SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(11);
	}


}