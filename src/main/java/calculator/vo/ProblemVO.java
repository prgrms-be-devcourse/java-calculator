package calculator.vo;

import calculator.constant.ErrorMessage;

public class ProblemVO {
    private final String problem;
    private final String MATH_PROBLEM_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";


    public ProblemVO(String problem) {
        validateProblem(problem);
        this.problem = problem;
    }

    public String get() {
        return problem;
    }

    private void validateProblem(String input) {
        if (!input.matches(MATH_PROBLEM_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MATH_PROBLEM);
        }
    }
}
