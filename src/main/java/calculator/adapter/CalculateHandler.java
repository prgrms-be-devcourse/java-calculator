package calculator.adapter;

import calculator.constant.ErrorMessage;
import calculator.engine.CalculatorEngine;
import calculator.io.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculateHandler implements CalculatorHandler {

    private List<Integer> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private Input input;
    private final static String MATH_PROBLEM_PATTERN = "^\\d+(\\s[+\\-*/]\\s\\d+)+$";

    public CalculateHandler(Input input) {
        this.input = input;
    }

    @Override
    public String process() {
        operands.clear();
        operators.clear();

        String problemInput = input.read();

        if (!isValidatedMathProblem(problemInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MATH_PROBLEM);
        }

        parseRawProblem(problemInput);
        return String.valueOf(calculate());
    }

    private void parseRawProblem(String problem) {
        String[] tokens = problem.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (isNumeric(tokens[i])) {
                operands.add(Integer.parseInt(tokens[i]));
            } else {
                operators.add(tokens[i]);
            }
        }
    }

    private int calculate() {
        int answer = operands.get(0);
        Optional<Integer> result;

        for (int i = 1; i < operands.size(); i++) {
            result = CalculatorEngine.execute(answer, operands.get(i), operators.get(i - 1));
            answer = result.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR));
        }

        return answer;
    }

    private boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private boolean isValidatedMathProblem(String input) {
        return input.matches(MATH_PROBLEM_PATTERN);
    }

}
