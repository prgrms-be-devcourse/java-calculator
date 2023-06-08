package domain;

public class Result {
    private String problem;
    private int answer;

    public Result(String problem, int answer) {
        this.problem = problem;
        this.answer = answer;
    }

    public String getProblem() {
        return problem;
    }

    public int getAnswer() {
        return answer;
    }
}
