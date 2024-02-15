package person;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Problem> problems;

    public Person() {
        problems = new ArrayList<>();
    }

    public void addProblem(Problem problem) {
        if (contains(problem)) throw new IllegalArgumentException("Description and Type already exists");
        problems.add(problem);
    }

    public ArrayList<String> recountProblem() {
        ArrayList<String> unsolvedProblems = new ArrayList<>();

        for (Problem problem: problems) {
            if (problem.isSolved()) continue;
            unsolvedProblems.add(String.valueOf(problem));
        }

        return unsolvedProblems;
    }

    public void solveProblem(Problem problem) {
        if (!contains(problem)) throw new IllegalArgumentException("Problem does not exist");

        problem.changeStatus();
    }

    public boolean contains(Problem problem) {
        for (Problem problemObject: problems) {
            boolean descriptionIsEquals = problemObject.getDescription().equals(problem.getDescription());
            boolean typeIsEquals = problemObject.getType().equals(problem.getType());

            if (descriptionIsEquals && typeIsEquals) return true;
        }

        return false;
    }
}
