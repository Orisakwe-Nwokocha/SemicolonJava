import java.util.Arrays;
import java.util.Scanner;

public class StudentGrade {

    private static final Scanner input = new Scanner(System.in);
    private static int[][] grades;

    public static void setGrades(int[][] grades) {
        StudentGrade.grades = grades;
    }

    public static int getTotal(int[] setOfGrades) {
        int sum = 0;

        for (int grade: setOfGrades) {
            sum += grade;
        }

        return sum;
    }

    public static double getAverage(int[] setOfGrades) {
        int total = 0;

        for (int grade: setOfGrades) {
            total += grade;
        }

        return (double) total / setOfGrades.length;
    }

    public static int getPosition(int[] setOfGrades) {
        int total = 0;
        double average = 0.0;
        int position = 1;

        for (int grade : setOfGrades) {
            total += grade;
            average = (double) total / setOfGrades.length;
        }

        for (int[] grade : grades) {
            if (average < getAverage(grade)) {
                position++;
            }
        }

        return position;
    }

    public static void outputGrades() {
        System.out.println("===============================================================================");
        System.out.print("STUDENT           ");
        for (int subject = 0; subject < grades[0].length; subject++) {
            System.out.printf("SUB%d    ", subject + 1);
        }
        System.out.println(" TOT     AVE     POS");
        System.out.println("===============================================================================");

        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %3d       ", student + 1);

            for (int subject: grades[student]) {
                System.out.printf("%3d     ", subject);
            }

            int total = getTotal(grades[student]);
            double average = getAverage(grades[student]);
            int studentPosition = getPosition(grades[student]);
            System.out.printf("%4d    %5.2f     %d%n", total, average, studentPosition);

        }

        System.out.println("===============================================================================");
        System.out.println("===============================================================================");

    }

    public static void main(String[] args) {

        System.out.println("How many students do you have?");
        int studentsRow = input.nextInt();
        while (studentsRow <= 0) {
            System.out.println("Invalid input\nHow many students do you have?");
            studentsRow = input.nextInt();
        }

        System.out.println("How many subjects do they offer?");
        int subjectsColumn = input.nextInt();
        while (subjectsColumn <= 0) {
            System.out.println("Invalid input\nHow many subjects do they offer?");
            subjectsColumn = input.nextInt();
        }

        int[][] newArray = new int[studentsRow][subjectsColumn];
        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

        for (int student = 0; student < studentsRow; student++) {

            for (int subject = 0; subject < subjectsColumn; subject++) {
                System.out.println("Entering score for student " + (student + 1));
                System.out.println("Enter score for subject " + (subject + 1));
                int score = input.nextInt();

                while (score < 0 || score > 100) {
                    System.out.println("Invalid score\nEnter score for subject " + (subject + 1));
                    score = input.nextInt();
                }

                newArray[student][subject] = score;
                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully");
                System.out.println();
            }
        }

        setGrades(newArray);

        System.out.println(Arrays.deepToString(grades));
        outputGrades();

    }

}
