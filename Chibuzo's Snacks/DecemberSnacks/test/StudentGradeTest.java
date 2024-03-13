import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    @BeforeEach
    public void testSetUp() {
        int[][] gradeArray = {{67, 21, 49}, {98, 62, 56}, {93, 34, 27}, {78, 83, 66}};
        StudentGrade.setGrades(gradeArray);
    }

    @Test
    public void getTotal() {
        int[] grade = {67, 21, 49};
        int actual = StudentGrade.getTotal(grade);
        int expected = 137;

        assertEquals(expected, actual);
    }

    @Test
    public void getAverage() {
        int[] grade = {98, 62, 56};
        double actual = StudentGrade.getAverage(grade);
        double expected = 72.00;

        assertEquals(expected, actual);
    }

    @Test
    public void getPosition() {
        int[] grade = {67, 21, 49};
        int actual = StudentGrade.getPosition(grade);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void getHighestScore() {
        int actual = StudentGrade.getHighestScore(2);
        int expected = 66;

        assertEquals(expected, actual);
    }

    @Test
    public void getLowestScore() {
        int actual = StudentGrade.getLowestScore(0);
        int expected = 67;

        assertEquals(expected, actual);
    }

    @Test
    public void getTotalScore() {
        int actual = StudentGrade.getTotalScore(1);
        int expected = 200;

        assertEquals(expected, actual);
    }

    @Test
    public void getAverageScore() {
        double actual = StudentGrade.getAverageScore(2);
        double expected = 49.50;

        assertEquals(expected, actual);
    }

    @Test
    public void getNoOfPasses() {
        int actual = StudentGrade.getNoOfPasses(0);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    public void getNoOfFails() {
        int actual = StudentGrade.getNoOfFails(1);
        int expected = 2;

        assertEquals(expected, actual);
    }
}
