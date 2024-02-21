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
		if (scoreBoard[3][2] != -1) {
			calculateTotalScores();
			checkForWinner();
		}
	}

	private int generateScore(){
		SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(11);
	}

	public String finalScoreBoard(){
		String horizontal = "=".repeat(41);
		String horizontal2 = "-".repeat(41);
		String vertical = "|";
		String blank = " ";
		String column = "%s\n%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s";
		String row = "%s\n%s%s%4d%4s%s%s%4d%4s%s%s%4d%4s%s%s%4d%4s%s";

		String boardRow = String.format(column, horizontal, vertical, blank, "Player1", blank, vertical, blank,
				"Player2", blank, vertical, blank, "Player3", blank, vertical, blank, "Player4", blank, vertical);

		String firstRow = String.format(row, horizontal, vertical, blank, scoreBoard[0][0], blank, vertical, blank,
				scoreBoard[1][0], blank, vertical, blank, scoreBoard[2][0], blank, vertical, blank, scoreBoard[3][0],
				blank, vertical);
		String secondRow = String.format(row, horizontal2, vertical, blank, scoreBoard[0][1], blank, vertical, blank,
				scoreBoard[1][1], blank, vertical, blank, scoreBoard[2][1], blank, vertical, blank, scoreBoard[3][1],
				blank, vertical);
		String thirdRow = String.format(row, horizontal2, vertical, blank, scoreBoard[0][2], blank, vertical, blank,
				scoreBoard[1][2], blank, vertical, blank, scoreBoard[2][2], blank, vertical, blank, scoreBoard[3][2],
				blank, vertical);
		String totalRow = String.format(row, horizontal, vertical, blank, totalOfScores[0], blank, vertical, blank,
				totalOfScores[1], blank, vertical, blank, totalOfScores[2], blank, vertical, blank, totalOfScores[3],
				blank, vertical);

		return String.format("%s%n%s%n%s%n%s%n%s%n%s%n", boardRow, firstRow, secondRow, thirdRow, totalRow, horizontal);
	}


}