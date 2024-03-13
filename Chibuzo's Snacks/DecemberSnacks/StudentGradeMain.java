import java.util.Scanner;

public class StudentGradeMain {
    private static int row = 0;
    private static int column = 0;
    private static int score = 0;
    private static final StudentGrade gradeApp = new StudentGrade();

    public static void main(String[] args) {
        int[][] gradeArray = {{67, 21, 49}, {98, 62, 56}, {93, 34, 27}, {78, 83, 66}};
        gradeApp.setGrades(gradeArray);
        //setGrades();
        gradeApp.processGrades();
    }

    public static void setGrades() {
        int studentsRow = getRow();
        int subjectsColumn = getColumn();
        System.out.println(studentsRow);
        System.out.println(subjectsColumn);

        int[][] grades = new int[studentsRow][subjectsColumn];
        print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");

        for (int student = 0; student < studentsRow; student++) {
            collectGrades(subjectsColumn, student, grades);
            print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved successfully\n");
        }

        gradeApp.setGrades(grades);
    }

    private static void collectGrades(int subjectsColumn, int student, int[][] grades) {
        for (int subject = 0; subject < subjectsColumn; subject++) {
            int score = getScore(student, subject);
            grades[student][subject] = score;
        }
    }

    private static int getScore(int student, int subject) {
        print("Entering score for student " + (student + 1));
        String studentScore = input("Enter score for subject " + (subject + 1));
        try {
            score = Integer.parseInt(studentScore);
            if (score < 0 || score > 100) throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
            getScore(student, subject);
        }

       return score;
    }

    private static int getColumn() {
        String subjectsColumn = input("How many subjects do they offer?");
        try {
            column = Integer.parseInt(subjectsColumn);
            if (column < 1) throw new IllegalArgumentException("Number of subjects must be a positive number");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
            getColumn();
        }

        return column;
    }

    private static int getRow() {
        String studentsRow = input("How many students do you have?");
        try {
            row = Integer.parseInt(studentsRow);
            if (row < 1) throw new IllegalArgumentException("Number of students must be a positive number");
        }
        catch (RuntimeException e) {
            print(e.getMessage());
            getRow();
        }

        return row;
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static String input(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }



}
