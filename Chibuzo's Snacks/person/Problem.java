package person;

public class Problem {
    private final String description;
    private final Type type;
    private boolean isSolved;
    
    public Problem(String description, Type type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void changeStatus() {
        isSolved = true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", description, type);
    }
}
