import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class ArcheryGameTest{

	private int[][] testScoreBoard = new int[][]{{-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}};


	@Test
	public void testArcheryGameExists(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		assertNotNull(archeryGame);
	}


	@Test
	public void testThatThereAreFourPlayersInGame(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		Player[] players = archeryGame.getPlayers();
		int numberOfPlayers = players.length;

		assertEquals(4, numberOfPlayers);

	}


	@Test
	public void testThatGameHasScoreBoard(){

		ArcheryGame archeryGame = new ArcheryGame(); 

		int[][] scoreBoard = archeryGame.getScoreBoard();

		assertArrayEquals(testScoreBoard, scoreBoard);

	}

	@Test
	public void testThatBoardIsFilledWithDummyValuesByDefault(){
		ArcheryGame archeryGame = new ArcheryGame();

		int[][] scoreBoard = archeryGame.getScoreBoard();

		assertArrayEquals(testScoreBoard, scoreBoard);
	}

	@Test
	public void testThatArcheryGameCanMarkScore(){
		ArcheryGame archeryGame = new ArcheryGame();

		int[][] scoreBoard = archeryGame.getScoreBoard();

		archeryGame.markScoreBoard(1);
		assertNotEquals(-1, scoreBoard[0][0]);

		archeryGame.markScoreBoard(1);
		assertNotEquals(-1, scoreBoard[0][1]);

		archeryGame.markScoreBoard(1);
		assertNotEquals(-1, scoreBoard[0][2]);

	}


	@Test
	public void testThatPlayersCanPlayGame(){
		ArcheryGame archeryGame = new ArcheryGame();
		Player[] players = archeryGame.getPlayers();

		int[][] scoreBoard = archeryGame.getScoreBoard();
		
		for (int counter = 0; counter < scoreBoard[0].length; counter++) {
			for (Player player : players) player.play(archeryGame, player);

		}

		System.out.println(Arrays.deepToString(scoreBoard));

		Player player = archeryGame.getWinner();
		System.out.println("Winner ===> Player " + player.getId());
		
	}


}
