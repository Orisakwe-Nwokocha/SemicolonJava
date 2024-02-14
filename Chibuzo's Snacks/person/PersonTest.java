package person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void instantiatePersonObject() {
        person = new Person();
    }

    @Test
    public void create1Problem_listOfProblemsIs1Test() {
        Type type = Type.EDUCATION;
        Problem problem = new Problem("education", type);

        person.addProblem(problem);

        assertEquals(1, person.recountProblem().length);
    }

    @Test
    public void given1Problem_whenAdded_listOfProblemsIs2Test() {
        Type type = Type.EDUCATION;
        Type type2 = Type.FINANCIAL;
        Problem problem = new Problem("education", type);
        Problem problem2 = new Problem("financial", type2);

        person.addProblem(problem);
        person.addProblem(problem2);

        assertEquals(2, person.recountProblem().length);
    }

    @Test
    public void givenProblem_whenSolved_recountUnsolvedProblemsTest() {
        Type type = Type.EDUCATION;
        Type type2 = Type.FINANCIAL;
        Type type3 = Type.SPIRITUAL;

        Problem problem = new Problem("education", type);
        Problem problem2 = new Problem("financial", type2);
        Problem problem3 = new Problem("spiritual", type3);
        person.addProblem(problem);
        person.addProblem(problem2);
        person.addProblem(problem3);
        assertEquals(3, person.recountProblem().length);

        person.solveProblem(problem3);
        assertEquals(2, person.recountProblem().length);
        String[] expected = {"education: EDUCATION", "financial: FINANCIAL"};
        assertArrayEquals(expected, person.recountProblem());
    }

    @Test
    public void givenProblem_whenSameDescriptionAndType_throwsExceptionTest() {
        Type type = Type.EDUCATION;
        Type type2 = Type.FINANCIAL;
        Type type3 = Type.FINANCIAL;
        Type type4 = Type.BUSINESS;
        Type type5 = Type.SPIRITUAL;


        Problem problem = new Problem("education", type);
        Problem problem2 = new Problem("financial", type2);
        Problem problem3 = new Problem("financial", type2);
        Problem problem4 = new Problem("financial", type4);
        Problem problem5 = new Problem("spiritual", type5);


        person.addProblem(problem);
        person.addProblem(problem2);
        person.addProblem(problem4);
        person.addProblem(problem5);

        assertThrows(IllegalArgumentException.class, ()-> person.addProblem(problem3));
    }

}