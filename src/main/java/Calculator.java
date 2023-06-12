import io.Input;
import io.Output;
import utils.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Input input;
    private Output output;
    private boolean go = true;
    private List<Integer> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {

        String optionInput;
        String problemInput;

        while (go) {
            optionInput = input.readWithPrompt("0. 종료\n1. 조회\n2. 계산\n\n선택 : ");

            if (!InputValidation.isValidatedOption(optionInput)) {
                output.inputError("0, 1, 2 중에 하나를 선택하세요.");
                continue;
            }

            switch (optionInput) {
                case "0":
                    go = false;
                    break;
                case "1":
                    output.results(new ArrayList<>());
                    break;
                case "2":
                    operands.clear();
                    operators.clear();
                    problemInput = input.read();

                    if (InputValidation.isValidatedMathProblem(problemInput)) {
                        try {
                            parseRawProblem(problemInput);
                            output.answer(calculate());
                        } catch (Exception e) {
                            output.inputError(e.getMessage());
                        }
                    } else {
                        output.inputError("잘못된 형식입니다.");
                    }
            }
        }
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

        for (int i = 1; i < operands.size(); i++) {
            answer = basicCalculate(answer, operands.get(i), operators.get(i - 1));
        }

        return answer;
    }

    private int basicCalculate(int operand1, int operand2, String operator) {
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    if (operand2 != 0) {
                        return operand1 / operand2;
                    }
                default:
                    throw new ArithmeticException("올바르지 않은 수식입니다.");
        }
    }

    private boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}
