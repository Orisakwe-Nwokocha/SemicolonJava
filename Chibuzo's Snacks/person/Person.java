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

    public String[] recountProblem() {
        ArrayList<String> problemsArray = new ArrayList<>();

        for (Problem problem: problems) {
            if (problem.isSolved()) continue;
            problemsArray.add(String.valueOf(problem));
        }

        return problemsArray.toArray(new String[0]);
    }

    public void solveProblem(Problem problem) {
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
