public class StudentGrade {
    private int[][] grades;

    public void setGrades(int[][] grades) {
        this.grades = grades;
    }

    public int getTotal(int[] setOfGrades) {
        int sum = 0;
        for (int grade: setOfGrades) sum += grade;

        return sum;
    }

    public double getAverage(int[] setOfGrades) {
        int total = 0;
        for (int grade: setOfGrades) total += grade;

        return (double) total / setOfGrades.length;
    }

    public int getPosition(int[] setOfGrades) {
        int total = 0;
        double average = 0.0;
        int position = 1;

        for (int grade : setOfGrades) {
            total += grade;
            average = (double) total / setOfGrades.length;
        }

        for (int[] grade : grades) if (average < getAverage(grade)) position++;

        return position;
    }

    public void outputGrades() {
        print("===============================================================================");
        System.out.print("STUDENT           ");

        for (int subject = 0; subject < grades[0].length; subject++) System.out.printf("SUB%d    ", subject + 1);

        print(" TOT     AVE     POS");
        print("===============================================================================");

        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %3d       ", student + 1);

            for (int subject: grades[student]) System.out.printf("%3d     ", subject);

            int total = getTotal(grades[student]);
            double average = getAverage(grades[student]);
            int studentPosition = getPosition(grades[student]);

            System.out.printf("%4d    %5.2f     %d%n", total, average, studentPosition);
        }

        print("===============================================================================");
        print("===============================================================================\n");

    }

    public int getHighestScore(int subject) {
        int highestGrade = 0;
        for (int[] grade : grades) if (grade[subject] > highestGrade) highestGrade = grade[subject];
        
        return highestGrade;
    }

    public int getLowestScore(int subject) {
        int lowestGrade = getHighestScore(subject);
        for (int[] student : grades) if (student[subject] < lowestGrade) lowestGrade = student[subject];

        return lowestGrade;
    }

    public int getTotalScore(int subject) {
        int totalGrade = 0;
        for (int[] student : grades) totalGrade += student[subject];

        return totalGrade;
    }

    public double getAverageScore(int subject) {
        return (double) getTotalScore(subject) / grades.length;
    }

    public int getNoOfPasses(int subject) {
        int pass = 0;
        for (int[] student : grades) if (student[subject] >= 50) pass++;

        return pass;
    }

    public int getNoOfFails(int subject) {
        int fail = 0;
        for (int[] student : grades) if (student[subject] < 50) fail++;

        return fail;
    }

    public void getHardestSubject() {
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

        if(fail > 0) System.out.printf("The hardest subject is Subject %d with %d failures%n", hardestSubject, fail);
        else print("There are apparently no hard subjects because there are 0 failures");
    }

    public void getEasiestSubject() {
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

        if (pass > 0) System.out.printf("The easiest subject is Subject %d with %d passes%n", easiestSubject, pass);
        else print("There are apparently no easy subjects because there are 0 passes");
    }

    public void getOverallHighestScore() {
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

        String format = "The overall Highest score is scored by Student %d in subject %d scoring %d%n";
        if (overallHighestScore > 0) System.out.printf(format, overallHighestScoringStudent, subjectScoredIn, overallHighestScore);
        else print("All scores were 0, so there is no overall Highest score");
    }

    public void getOverallLowestScore() {
        int overallLowestScore = grades[0][0];
        int overallLowestScoringStudent = 0;
        int subjectScoredIn = 0;

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (grades[student][subject] < overallLowestScore) {
                    overallLowestScoringStudent = student;
                    subjectScoredIn = subject;
                    overallLowestScore = grades[student][subject];
                }
            }
        }

        String format = "The overall Lowest score is scored by Student %d in subject %d scoring %d%n";
        if (overallLowestScore > 0) System.out.printf(format, (overallLowestScoringStudent + 1), (subjectScoredIn + 1), overallLowestScore);
        else print("All scores were 0, so there is no overall Lowest score");
    }

    public void processGraduatingStudents() {
        int bestSubTotal = 0;
        int bestGraduatingStudent = 0;

        for (int student = 0; student < grades.length; student++) {
            if (getTotal(grades[student]) > bestSubTotal) {
                bestGraduatingStudent = student + 1;
                bestSubTotal = getTotal(grades[student]);
            }
        }

        if (bestSubTotal > 0) System.out.printf("Best Graduating Student is: Student %d scoring %d%n", bestGraduatingStudent, bestSubTotal);
        else print("All scores were 0, so there is no Best Graduating Student");

        print("===============================================================================\n");
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        int worstSubTotal = bestSubTotal;
        int worstGraduatingStudent = 0;

        for (int student = 0; student < grades.length; student++) {
            if (getTotal(grades[student]) < worstSubTotal) {
                worstGraduatingStudent = student + 1;
                worstSubTotal = getTotal(grades[student]);
            }
        }

        if (worstSubTotal > 0) System.out.printf("Worst Graduating Student is: Student %d scoring %d%n", worstGraduatingStudent, worstSubTotal);
        else print("All scores were 0, so there is no Worst Graduating Student");

        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
    }

    public void subjectSummary() {
        print("SUBJECT SUMMARY");

        for (int subject = 0; subject < grades[0].length; subject++) {
            System.out.printf("Subject %d", subject + 1);

            int highestScore = getHighestScore(subject);
            int highestScoringStudent = 0;
            for (int student = 0; student < grades.length; student++) {
                if (highestScore == grades[student][subject]) {
                    highestScoringStudent = student + 1;
                }
            }

            int lowestScoringStudent = 0;
            for (int student = 0; student < grades.length; student++) {
                boolean lowestScore = grades[student][subject] == getLowestScore(subject);
                if (lowestScore) lowestScoringStudent = student + 1;
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
                    """, highestScoringStudent, highestScore, lowestScoringStudent, getLowestScore(subject), totalScore, averageScore, noOfPassScores, noOfFailScores);

            print("");
        }

        getHardestSubject();
        getEasiestSubject();
        getOverallHighestScore();
        getOverallLowestScore();

        print("===============================================================================\n");
        print("CLASS SUMMARY");
        print("===============================================================================");
        processGraduatingStudents();
        print("===============================================================================");

        int classTotal = 0;
        for (int[] student : grades) classTotal += getTotal(student);
        double classAverage = (double) classTotal / grades.length;

        System.out.printf("""
                Class Total score is: %d
                Class Average score is: %.2f
                ===============================================================================
                """, classTotal, classAverage);
    }

    public void processGrades() {
        outputGrades();
        subjectSummary();
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }
}
