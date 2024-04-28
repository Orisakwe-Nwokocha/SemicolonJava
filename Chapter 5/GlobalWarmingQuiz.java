import java.util.Scanner;

public class GlobalWarmingQuiz {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int correctAnswers = 0;

        System.out.println("Welcome to the Global Warming Quiz!");

        String[][] questions = {
                {"Which statement aligns with the perspective of individuals who oppose the idea of human-induced global warming?",
                        "1. The burning of fossil fuels contributes significantly to the rise in greenhouse gas emissions.",
                        "2. The rise in global temperatures is primarily attributed to human activities.",
                        "3. Natural occurrences, not human actions, are solely responsible for the observed climate changes.",
                        "4. Implementing policies to reduce carbon footprint is crucial in combating global warming.",
                        "3"},

                {"What are some potential effects of global warming?",
                        "1. More frequent extreme weather events.",
                        "2. Decreased sea levels.",
                        "3. Increased biodiversity.",
                        "4. Reduction in greenhouse gas emissions.",
                        "1"},

                {"What is the primary cause of global warming?",
                        "1. Increased solar activity.",
                        "2. Natural climate cycles.",
                        "3. Human activities, such as burning fossil fuels.",
                        "4. Volcanic eruptions.",
                        "3"},

                {"Which of the following represents a common view held by skeptics against the concept of human-induced global warming?",
                        "1. Human activities are primarily responsible for the observed increase in global temperatures.",
                        "2. The scientific consensus on global warming is indisputable and universally accepted.",
                        "3. There is robust evidence indicating that reducing carbon emissions is crucial to mitigating global warming.",
                        "4. Climate change is solely a result of natural environmental fluctuations.",
                        "4"},

                {"Which international agreement aimed to combat global warming by reducing greenhouse gas emissions?",
                        "1. Kyoto Protocol.",
                        "2. Paris Climate Agreement.",
                        "3. Copenhagen Accord.",
                        "4. Berlin Mandate.",
                        "2"}
        };

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i][0]);

            for (int j = 1; j <= 4; j++) System.out.println("\t" + questions[i][j]);

            System.out.print("\nEnter your answer: ");
            String userAnswer = input.nextLine();

            if (userAnswer.equals(questions[i][5])) correctAnswers++;
        }

        System.out.printf("%nNumber of correct answers: %d%n", correctAnswers);

        if (correctAnswers == 5) System.out.println("Excellent!");
        else if (correctAnswers == 4) System.out.println("Very good!");
        else System.out.println("Time to brush up on your knowledge of global warming. Here is a starter website: https://en.wikipedia.org/wiki/Climate_change");

        input.close();
    }
}
