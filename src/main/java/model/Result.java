package model;

public class Result {
    private String problem;
    private int answer;

    public Result(String problem, int answer) {
        this.problem = problem;
        this.answer = answer;
    }

    public String toString() {
        return problem + " = " + answer;
    }

}
