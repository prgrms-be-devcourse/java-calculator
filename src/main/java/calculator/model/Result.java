package calculator.model;

public class Result {
    private String problem;
    private int answer;

    public Result(String problem, int answer) {
        this.problem = problem;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return problem + " = " + answer;
    }
}
