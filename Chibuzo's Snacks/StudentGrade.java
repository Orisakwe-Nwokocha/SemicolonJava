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
        System.out.println("===============================================================================\n");

    }

    public static int getHighestScore(int subject) {
        int highestGrade = 0;

        for (int student = 0; student < grades.length; student++) {

            for (int index = 0; index < grades[student].length; index++) {
                if (grades[student][subject] > highestGrade) {
                    highestGrade = grades[student][subject];
                }
            }

        }
        return highestGrade;
    }

    public static int getLowestScore(int subject) {
        int lowestGrade = getHighestScore(subject);

        for (int[] student : grades) {

            for (int index = 0; index < student.length; index++) {
                if (student[subject] < lowestGrade) {
                    lowestGrade = student[subject];
                }
            }
        }

        return lowestGrade;
    }

    public static int getTotalScore(int subject) {
        int totalGrade = 0;

        for (int[] student : grades) {
                totalGrade += student[subject];
        }
        return totalGrade;
    }

    public static double getAverageScore(int subject) {
        double sum = getTotalScore(subject);

        return sum / grades.length;
    }

    public static int getNoOfPasses(int subject) {
        int passMark = 50;
        int pass = 0;

        for (int[] student : grades) {

            if (student[subject] >= passMark) {
                pass++;
            }
        }

        return pass;
    }

    public static int getNoOfFails(int subject) {
        int passMark = 50;
        int fail = 0;

        for (int[] student : grades) {

            if (student[subject] < passMark) {
                fail++;
            }
        }

        return fail;
    }

    public static void getHardestSubject() {
        int hardestSubject = 0;
        int fail = 0;

        for (int[] student : grades) {

            for (int subject = 0; subject < student.length; subject++) {

                if (getNoOfFails(subject) > fail) {
                    hardestSubject = subject + 1;
                    fail = getNoOfFails(subject);
                }
            }
        }

        if(fail > 0) {
            System.out.printf("The hardest subject is Subject %d with %d failures%n", hardestSubject, fail);
        } else {
            System.out.println("There are apparently no hard subjects because there are 0 failures");
        }

    }

    public static void getEasiestSubject() {
        int easiestSubject = 0;
        int pass = 0;

        for (int[] student : grades) {

            for (int subject = 0; subject < student.length; subject++) {

                if (getNoOfPasses(subject) > pass) {
                    easiestSubject = subject + 1;
                    pass = getNoOfPasses(subject);
                }
            }
        }

        if (pass > 0) {
            System.out.printf("The easiest subject is Subject %d with %d passes%n", easiestSubject, pass);
        } else {
            System.out.println("There are apparently no easy subjects because there are 0 passes");
        }

    }

    public static void getOverallHighestScore() {
        int overallHighestScore = grades[0][0];
        int overallHighestScoringStudent = 0;
        int subjectScoredIn = 0;

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (grades[student][subject] > overallHighestScore) {
                    overallHighestScoringStudent = student + 1;
                    subjectScoredIn = subject + 1;
                    overallHighestScore = grades[student][subject];
                }
            }
        }

        if (overallHighestScore > 0) {
            System.out.printf("The overall Highest score is scored by Student %d in subject %d scoring %d%n",
                    overallHighestScoringStudent, subjectScoredIn, overallHighestScore);
        } else {
            System.out.println("All scores were 0, so there is no overall Highest score");
        }

    }

    public static void getOverallLowestScore() {
        int overallLowestScore = grades[0][0];
        int overallLowestScoringStudent = 0;
        int subjectScoredIn = 0;

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (grades[student][subject] < overallLowestScore) {
                    overallLowestScoringStudent = student + 1;
                    subjectScoredIn = subject + 1;
                    overallLowestScore = grades[student][subject];
                }
            }
        }

        if (overallLowestScore > 0) {
            System.out.printf("The overall Lowest score is scored by Student %d in subject %d scoring %d%n",
                    overallLowestScoringStudent, subjectScoredIn, overallLowestScore);
        } else {
            System.out.println("All scores were 0, so there is no overall Lowest score");
        }

    }

    public static void processGraduatingStudents() {
        int bestSubTotal = 0;
        int bestGraduatingStudent = 0;

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (getTotal(grades[student]) > bestSubTotal) {
                    bestGraduatingStudent = student + 1;
                    bestSubTotal = getTotal(grades[student]);
                }
            }
        }

        if (bestSubTotal > 0) {
            System.out.printf("Best Graduating Student is: Student %d scoring %d%n",
                    bestGraduatingStudent, bestSubTotal);
        } else {
            System.out.println("All scores were 0, so there is no Best Graduating Student");
        }
        System.out.println("===============================================================================\n");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        int worstSubTotal = bestSubTotal;
        int worstGraduatingStudent = 0;

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (getTotal(grades[student]) < worstSubTotal) {
                    worstGraduatingStudent = student + 1;
                    worstSubTotal = getTotal(grades[student]);
                }
            }
        }

        if (worstSubTotal > 0) {
            System.out.printf("Worst Graduating Student is: Student %d scoring %d%n",
                    worstGraduatingStudent, worstSubTotal);
        } else {
            System.out.println("All scores were 0, so there is no Worst Graduating Student");
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

    }

    public static void subjectSummary() {
        for (int subject = 0; subject < grades[0].length; subject++) {

            System.out.println("SUBJECT SUMMARY");
            System.out.printf("Subject %d", subject + 1);

            int highestScore = getHighestScore(subject);
            int highestScoringStudent = 0;
            for (int student = 0; student < grades.length; student++) {
                if (highestScore == grades[student][subject]) {
                    highestScoringStudent = student + 1;
                }
            }

            int lowestScore = getLowestScore(subject);
            int lowestScoringStudent = 0;
            for (int student = 0; student < grades.length; student++) {
                if (lowestScore == grades[student][subject]) {
                    lowestScoringStudent = student + 1;
                }
            }

            int totalScore = getTotalScore(subject);
            double averageScore = getAverageScore(subject);
            int noOfPassScores = getNoOfPasses(subject);
            int noOfFailScores = getNoOfFails(subject);

            System.out.printf("""
                    %nHighest scoring student is: Student %d scoring %d
                    Lowest scoring student is: Student %d scoring %d
                    Total score is: %4d
                    Average score is: %.2f
                    Number of passes: %d
                    Number of fails: %d
                    """, highestScoringStudent, highestScore, lowestScoringStudent, lowestScore, totalScore, averageScore, noOfPassScores, noOfFailScores);

            System.out.println();
        }

        getHardestSubject();
        getEasiestSubject();
        getOverallHighestScore();
        getOverallLowestScore();

        System.out.println("===============================================================================\n");
        System.out.println("CLASS SUMMARY");
        System.out.println("===============================================================================");
        processGraduatingStudents();
        System.out.println("===============================================================================");

        int classTotal = 0;
        for (int[] student : grades) {
            classTotal += getTotal(student);
        }
        double classAverage = (double) classTotal / grades.length;

        System.out.printf("""
                Class Total score is: %d
                Class Average score is: %.2f
                ===============================================================================
                """, classTotal,classAverage);
    }

    public static void processGrades() {
        outputGrades();
        subjectSummary();
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
        System.out.println();

        processGrades();

    }

}