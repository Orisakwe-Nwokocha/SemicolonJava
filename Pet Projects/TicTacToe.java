import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
	
public class TicTacToe {
    private static final Scanner input = new Scanner(System.in);
    private static String player1;
    private static String player2;
    private static Status gameStatus;
    
    private static String[][] TIC_TAC_TOE = {{"-", "-", "-"},
				 				  {"-", "-", "-"},
				  				  {"-", "-", "-"}};
				  				  
    private static final ArrayList<String> playersMarkedSpaces = new ArrayList<>();			  				  			  				  

    private enum Status {PLAYER1WINS, PLAYER2WINS};	
    						  
    public static void displayRules() {
	  System.out.println("Welcome!\nHere is a rundown of the rules:");
	  System.out.println("""
			   \t*You can only mark one space at a time labelled a1-c3
			   \t*The player who succeeds in placing three of their marks in a horizontal,
			   \t vertical, or diagonal row is the winner!
			   A sample of the labelled spaces:
			   """);
	  String sampleOutput[][] = {{"a1", "a2", "a3"},
				   {"b1", "b2", "b3"},
				   {"c1", "c2", "c3"}};
	   for (String[] row : sampleOutput) {
	      for (String column : row) {
	    	  System.out.print(column + "  ");
		
	      }
	      System.out.println("\n");
	   }
	 
    }

   public static void tictactoe() {
   	 for (int count = 1; count <= 5; count++) {
	   		
   		System.out.println("Player 1, mark a space (a1-c3)");  
   		player1 = input.next().toUpperCase();
   		
   		while (!player1.equals("A1") && !player1.equals("A2") && !player1.equals("A3")
   		    && !player1.equals("B1") && !player1.equals("B2") && !player1.equals("B3")
   		    && !player1.equals("C1") && !player1.equals("C2") && !player1.equals("C3")) {
   				
   			System.out.println("Invalid input\nPlayer 1, mark a space (a1-c3)");  
   			player1 = input.next().toUpperCase();
   		}
   		
   		while (playersMarkedSpaces.contains(player1)) {   				
   			System.out.println("Invalid input\nPlayer 1, mark a space not including " + player1);  
   			player1 = input.next().toUpperCase();
   			
   			while (!player1.equals("A1") && !player1.equals("A2") && !player1.equals("A3")
   		    	    && !player1.equals("B1") && !player1.equals("B2") && !player1.equals("B3")
   		         && !player1.equals("C1") && !player1.equals("C2") && !player1.equals("C3")) {
   				
   				System.out.println("Invalid input\nPlayer 1, mark a space (a1-c3)");  
   				player1 = input.next().toUpperCase();
   			}	
   		}   
   		
   		playersMarkedSpaces.add(player1);
   		
   		switch (player1) {
   			case "A1" -> TIC_TAC_TOE[0][0] = "X";
   			case "A2" -> TIC_TAC_TOE[0][1] = "X";
   			case "A3" -> TIC_TAC_TOE[0][2] = "X";
   			case "B1" -> TIC_TAC_TOE[1][0] = "X";
   			case "B2" -> TIC_TAC_TOE[1][1] = "X";
   			case "B3" -> TIC_TAC_TOE[1][2] = "X";
   			case "C1" -> TIC_TAC_TOE[2][0] = "X";
   			case "C2" -> TIC_TAC_TOE[2][1] = "X";
   			case "C3" -> TIC_TAC_TOE[2][2] = "X";
   		}
   		
   		System.out.println();
		for (String[] row : TIC_TAC_TOE) {
	    		for (String column : row) {
	    			System.out.print(column + "  ");
	    		}
    			System.out.println("\n");
		}
		
		gameResult();	
		if (gameStatus == Status.PLAYER1WINS) {
			System.out.printf("%nPlayer 1 wins!!!%n");
			break;
		} 
		if (gameStatus == Status.PLAYER2WINS) {
			System.out.printf("%nPlayer 2 wins!!!%n");
			break;
		} 
		
		if (count == 5) {break;}  				 			
   			
   		System.out.println("Player 2, mark a space (a1-c3)"); 
   		player2 = input.next().toUpperCase(); 
   		
   		while (!player2.equals("A1") && !player2.equals("A2") && !player2.equals("A3")
   		    && !player2.equals("B1") && !player2.equals("B2") && !player2.equals("B3")
   		    && !player2.equals("C1") && !player2.equals("C2") && !player2.equals("C3")) {
   				
   			System.out.println("Invalid input\nPlayer 2, mark a space (a1-c3)");  
   			player2 = input.next().toUpperCase();
   		}
   		
   		while (playersMarkedSpaces.contains(player2)) {
   				
   			System.out.println("Invalid input\nPlayer 2, mark a space not including " + player2);  
   			player2 = input.next().toUpperCase();
   			while (!player2.equals("A1") && !player2.equals("A2") && !player2.equals("A3")
   		    	    && !player2.equals("B1") && !player2.equals("B2") && !player2.equals("B3")
   		         && !player2.equals("C1") && !player2.equals("C2") && !player2.equals("C3")) {
   				
   				System.out.println("Invalid input\nPlayer 2, mark a space (a1-c3)");  
   				player2 = input.next().toUpperCase();
   			}	
   		}   
   		
   		playersMarkedSpaces.add(player2);
   		
   		switch (player2) {
   			case "A1" -> TIC_TAC_TOE[0][0] = "O";
   			case "A2" -> TIC_TAC_TOE[0][1] = "O";
   			case "A3" -> TIC_TAC_TOE[0][2] = "O";
   			case "B1" -> TIC_TAC_TOE[1][0] = "O";
   			case "B2" -> TIC_TAC_TOE[1][1] = "O";
   			case "B3" -> TIC_TAC_TOE[1][2] = "O";
   			case "C1" -> TIC_TAC_TOE[2][0] = "O";
   			case "C2" -> TIC_TAC_TOE[2][1] = "O";
   			case "C3" -> TIC_TAC_TOE[2][2] = "O";
   		}
   		
   		System.out.println();
		for (String[] row : TIC_TAC_TOE) {
	    		for (String column : row) {
	    			System.out.print(column + "  ");
	    		}
    			System.out.println("\n");
		}
		
		gameResult();	
		if (gameStatus == Status.PLAYER1WINS) {
			System.out.printf("%nPlayer 1 wins!!!%n");
			break;
		} 
		if (gameStatus == Status.PLAYER2WINS) {
			System.out.printf("%nPlayer 2 wins!!!%n");
			break;
		}			
	 }
	
	 gameResult();	
	 if (gameStatus != Status.PLAYER1WINS && gameStatus != Status.PLAYER2WINS) {
		System.out.printf("%nThe game ends in a draw!!!%n");
	 }
	 
	
   }
   
   public static Status gameResult() {
   	 boolean isMarkedHorizontalXRow1 = TIC_TAC_TOE[0][0].equals("X") && TIC_TAC_TOE[0][1].equals("X") && TIC_TAC_TOE[0][2].equals("X");
   	 boolean isMarkedHorizontalXRow2 = TIC_TAC_TOE[1][0].equals("X") && TIC_TAC_TOE[1][1].equals("X") && TIC_TAC_TOE[1][2].equals("X");
   	 boolean isMarkedHorizontalXRow3 = TIC_TAC_TOE[2][0].equals("X") && TIC_TAC_TOE[2][1].equals("X") && TIC_TAC_TOE[2][2].equals("X");
   	
   	 boolean isMarkedVerticalXRow1 = TIC_TAC_TOE[0][0].equals("X") && TIC_TAC_TOE[1][0].equals("X") && TIC_TAC_TOE[2][0].equals("X");
   	 boolean isMarkedVerticalXRow2 = TIC_TAC_TOE[0][1].equals("X") && TIC_TAC_TOE[1][1].equals("X") && TIC_TAC_TOE[2][1].equals("X");
   	 boolean isMarkedVerticalXRow3 = TIC_TAC_TOE[0][2].equals("X") && TIC_TAC_TOE[1][2].equals("X") && TIC_TAC_TOE[2][2].equals("X");
   	
   	 boolean isMarkedDiagonalXLeft = TIC_TAC_TOE[0][0].equals("X") && TIC_TAC_TOE[1][1].equals("X") && TIC_TAC_TOE[2][2].equals("X");
   	 boolean isMarkedDiagonalXRight = TIC_TAC_TOE[0][2].equals("X") && TIC_TAC_TOE[1][1].equals("X") && TIC_TAC_TOE[2][0].equals("X");
   	
   	 boolean isMarkedHorizontalORow1 = TIC_TAC_TOE[0][0].equals("O") && TIC_TAC_TOE[0][1].equals("O") && TIC_TAC_TOE[0][2].equals("O");
   	 boolean isMarkedHorizontalORow2 = TIC_TAC_TOE[1][0].equals("O") && TIC_TAC_TOE[1][1].equals("O") && TIC_TAC_TOE[1][2].equals("O");
   	 boolean isMarkedHorizontalORow3 = TIC_TAC_TOE[2][0].equals("O") && TIC_TAC_TOE[2][1].equals("O") && TIC_TAC_TOE[2][2].equals("O");
   	
   	 boolean isMarkedVerticalORow1 = TIC_TAC_TOE[0][0].equals("O") && TIC_TAC_TOE[1][0].equals("O") && TIC_TAC_TOE[2][0].equals("O");
   	 boolean isMarkedVerticalORow2 = TIC_TAC_TOE[0][1].equals("O") && TIC_TAC_TOE[1][1].equals("O") && TIC_TAC_TOE[2][1].equals("O");
   	 boolean isMarkedVerticalORow3 = TIC_TAC_TOE[0][2].equals("O") && TIC_TAC_TOE[1][2].equals("O") && TIC_TAC_TOE[2][2].equals("O");
   	
   	 boolean isMarkedDiagonalOLeft = TIC_TAC_TOE[0][0].equals("O") && TIC_TAC_TOE[1][1].equals("O") && TIC_TAC_TOE[2][2].equals("O");
   	 boolean isMarkedDiagonalORight = TIC_TAC_TOE[0][2].equals("O") && TIC_TAC_TOE[1][1].equals("O") && TIC_TAC_TOE[2][0].equals("O");
   	
   	
   	 if (isMarkedHorizontalXRow1 || isMarkedHorizontalXRow2 || isMarkedHorizontalXRow3 || isMarkedVerticalXRow1
   	     || isMarkedVerticalXRow2 || isMarkedVerticalXRow3 || isMarkedDiagonalXLeft || isMarkedDiagonalXRight) {
   	     gameStatus = Status.PLAYER1WINS;
   	 }
   	
     	 else if (isMarkedHorizontalORow1 || isMarkedHorizontalORow2 || isMarkedHorizontalORow3 || isMarkedVerticalORow1
   	          || isMarkedVerticalORow2 || isMarkedVerticalORow3 || isMarkedDiagonalOLeft || isMarkedDiagonalORight) {
   	     gameStatus = Status.PLAYER2WINS;	   	    
   	 }
   	 
   	 return gameStatus;
   	
   	 
    }

   	
   public static void startGame() {
	displayRules();

	System.out.println("Player 1, you are X\nPlayer 2, you are O\n");
	
	tictactoe();

    }
    
 
}