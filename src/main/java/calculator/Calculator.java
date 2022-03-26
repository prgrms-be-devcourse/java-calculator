package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    public static final String DELIMITER = " ";

    public double calculate(String operator, double firstNumber, double secondNumber) {
        return OperatorType.from(operator)
            .calculate(firstNumber, secondNumber);
    }

    public List<String> parsePostfix(String infix) {
        Stack<String> converter = new Stack<>();
        List<String> result = new ArrayList<>();

        String[] inputStrings = split(infix);

        for (String inputString : inputStrings) {
            if (inputString.matches("\\d+(.\\d+)?")) {
                result.add(inputString);
            } else if (inputString.matches("[+-/*]")) {
                if (converter.isEmpty()) {
                    converter.add(inputString);
                } else {
                    while (!converter.isEmpty() && OperatorType.from(converter.peek()).getValue() >= OperatorType.from(
                        inputString).getValue()) {
                        result.add(converter.pop());
                    }
                    converter.add(inputString);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        while (!converter.isEmpty()) {
            result.add(converter.pop());
        }
        return result;
    }

    private String[] split(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.");
        }
        return inputString.split(DELIMITER);
    }
}
