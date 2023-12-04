import java.util.Scanner;

public class GlobalWarming {

   public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	int wrongAnswer = 0;
	int correctAnswer = 0;

	System.out.println("Welcome. Trust you are ready for today's quiz!!!");
	System.out.println();

	for (int i = 1; i <= 5; i++) {
	    switch (i) {
		case 1:
			System.out.print("""
				 	Which statement aligns with the perspective of individuals who oppose the idea of human-induced global warming?
				    	1. The burning of fossil fuels contributes significantly to the rise in greenhouse gas emissions.
				    	2. The rise in global temperatures is primarily attributed to human activities.
				     	3. Natural occurrences, not human actions, are solely responsible for the observed climate changes.
				     	4. Implementing policies to reduce carbon footprint is crucial in combating global warming.""");

			System.out.printf("%n%nEnter your answer: ");		
			int num = input.nextInt();
			switch (num) {
				case 3:
					correctAnswer++;
					break;
				default:
					wrongAnswer++;
			}
			break;

		case 2:
			System.out.println();
			System.out.print("""
				 	What are some potential effects of global warming?
				    	1. More frequent extreme weather events.
				    	2. Decreased sea levels.
				     	3. Increased biodiversity.
				     	4. Reduction in greenhouse gas emissions.""");

			System.out.printf("%n%nEnter your answer: ");		
			num = input.nextInt();
			switch (num) {
				case 1:
					correctAnswer++;
					break;
				default:
					wrongAnswer++;
			}
			break;

		case 3:
			System.out.println();
			System.out.print("""
				 	What is the primary cause of global warming?
				    	1. Increased solar activity.
				    	2. Natural climate cycles.
				     	3. Human activities, such as burning fossil fuels.
				     	4. Volcanic eruptions.""");

			System.out.printf("%n%nEnter your answer: ");		
			num = input.nextInt();
			switch (num) {
				case 3:
					correctAnswer++;
					break;
				default:
					wrongAnswer++;
			}
			break;
	
		case 4:
			System.out.println();
			System.out.print("""
				 	Which of the following represents a common view held by skeptics against the concept of human-induced global warming?
				    	1. Human activities are primarily responsible for the observed increase in global temperatures.
				    	2. The scientific consensus on global warming is indisputable and universally accepted.
				     	3. There is robust evidence indicating that reducing carbon emissions is crucial to mitigating global warming.
				     	4. Climate change is solely a result of natural environmental fluctuations.""");

			System.out.printf("%n%nEnter your answer: ");		
			num = input.nextInt();
			switch (num) {
				case 4:
					correctAnswer++;
					break;
				default:
					wrongAnswer++;
			}
			break;

		case 5:
			System.out.println();
			System.out.print("""
				 	Which international agreement aimed to combat global warming by reducing greenhouse gas emissions?
				    	1. Kyoto Protocol.
				    	2. Paris Climate Agreement.
				     	3. Copenhagen Accord.
				     	4. Berlin Mandate.""");

			System.out.printf("%n%nEnter your answer: ");		
			num = input.nextInt();
			switch (num) {
				case 2:
					correctAnswer++;
					break;
				default:
					wrongAnswer++;
			}
			break;

	    }


	}

	System.out.printf("%nNumber of correct answer(s) is: %d", correctAnswer);
	System.out.printf("%nNumber of wrong answer(s) is: %d", wrongAnswer);
	
	if (correctAnswer == 5){System.out.printf("%n%nExcellent");}
	else if (correctAnswer == 4){System.out.printf("%n%nVery good");}
	else if (correctAnswer <= 3){System.out.printf("%n%nTime to brush up on your knowledge of global warming, here is a starter website: https://en.wikipedia.org/wiki/Climate_change");}

   }

}