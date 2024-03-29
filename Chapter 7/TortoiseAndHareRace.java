import java.security.SecureRandom;

public class TortoiseAndHareRace {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static int TORTOISE_POSITION = 0;
    private static int HARE_POSITION = 0;
    private static int noOfGames = 0;
    private static Status gameStatus;
    
    private enum Status {TORTOISE, HARE, TIE, DRAW, UNFINISHED};
    
    public void startTortoiseAndHareRace() throws InterruptedException {
        String[] raceTrack = new String[71];

        System.out.println("BANG !!!!!\nAND THEY'RE OFF !!!!!");
        
        for (int race = 1; race < raceTrack.length; race++) {
            racePositionsTortoise();
            racePositionsHare();
            
            if (TORTOISE_POSITION < 1) TORTOISE_POSITION = 1;
            if (TORTOISE_POSITION > 70) TORTOISE_POSITION = 70;
            
            if (HARE_POSITION < 1) HARE_POSITION = 1;
            if (HARE_POSITION > 70) HARE_POSITION = 70;
            
            System.out.println("Tortoise position: " + TORTOISE_POSITION);
            System.out.println("Hare position: " + HARE_POSITION);

            
            for (int index = 1; index < raceTrack.length; index++) {
                raceTrack[index] = "-";                
                raceStatus(TORTOISE_POSITION, HARE_POSITION);
                
                if (gameStatus == Status.TIE) {
                    raceTrack[TORTOISE_POSITION] = "OUCH!!!";
                    System.out.print(raceTrack[index] + " ");
                } else {
                    raceTrack[TORTOISE_POSITION] = "T";
                    raceTrack[HARE_POSITION] = "H";
                    System.out.print(raceTrack[index] + " ");
                } 
            }
            
            System.out.println();
            
            ++noOfGames;  
            raceStatus(TORTOISE_POSITION, HARE_POSITION);
            
            if (gameStatus == Status.TORTOISE) {
                System.out.println("\nTORTOISE WINS!!! YAY!!!");
                break;
            }            
            if (gameStatus == Status.HARE) {
                System.out.println("\nHare wins. Yuch");
                break;
            }            
            if (gameStatus == Status.DRAW) {
                System.out.println("\nIt's a tie\nThe tortoise as the underdog is rewarded with a carrot and a lettuce!!!");
                break;
            }
            Thread.sleep(3_000);
        }
        
        raceStatus(TORTOISE_POSITION, HARE_POSITION);
        
        if (gameStatus == Status.UNFINISHED) {                    
            System.out.println("\nNeither animal won");
        }
        
        System.out.println("Number of laps: " + noOfGames);
    }
    
     private static int racePositionsTortoise() {
         int i = randomNumbers.nextInt(1, 11);

         return switch (i) {
             case 1, 2, 3, 4, 5 -> TORTOISE_POSITION += 3;
             case 6, 7 -> TORTOISE_POSITION -= 6;
             case 8, 9, 10 -> TORTOISE_POSITION += 1;
             default -> racePositionsTortoise();
         };
     }
     
     private static int racePositionsHare() {
         int i = randomNumbers.nextInt(1, 11);

         return switch (i) {
             case 1, 2 -> HARE_POSITION;
             case 3, 4 -> HARE_POSITION += 9;
             case 5 -> HARE_POSITION -= 12;
             case 6, 7, 8 -> HARE_POSITION += 1;
             case 9, 10 -> HARE_POSITION -= 2;
             default -> racePositionsHare();
         };
     }     
     
     private static void raceStatus(int tortoisePosition, int harePosition) {
         if (tortoisePosition == harePosition && tortoisePosition < 70) {
             gameStatus = Status.TIE;
         } 
         
         else if (tortoisePosition == harePosition) {
             gameStatus = Status.DRAW;
         }
           
         else if (tortoisePosition == 70) {
             gameStatus = Status.TORTOISE;
         }
         
         else if (harePosition == 70) {
             gameStatus = Status.HARE;
         }
           
         else {
             gameStatus = Status.UNFINISHED;
         }

     }
    
     public static void main(String... ori) throws InterruptedException {
         TortoiseAndHareRace race1 = new TortoiseAndHareRace();
         race1.startTortoiseAndHareRace();
     }

}
