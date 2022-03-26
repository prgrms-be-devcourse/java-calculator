package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import calculator.domain.OperatorType;

public class ExpressionParser implements Parser {
    public static final Pattern INPUT_FORM = Pattern.compile("\\d+(.\\d+)?( [+-/*] \\d+(.\\d+)?)*");
    public static final Pattern NUMBER = Pattern.compile("\\d+(.\\d+)?");
    public static final Pattern OPERATOR = Pattern.compile("[+-/*]");
    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";

    private final String delimiter;

    public ExpressionParser(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> parsePostfix(String input) {

        validateInput(input);

        Stack<String> converter = new Stack<>();
        List<String> result = new ArrayList<>();

        String[] inputStrings = input.split(delimiter);

        for (String inputString : inputStrings) {
            if (isNumber(inputString)) {
                result.add(inputString);
                continue;
            }

            if (isOperator(inputString)) {
                while (hasValueInStack(converter) && isPopOperator(converter.peek(), inputString)) {
                    result.add(converter.pop());
                }
                converter.add(inputString);
            }
        }

        while (hasValueInStack(converter)) {
            result.add(converter.pop());
        }
        return result;
    }

    private void validateInput(String input) {
        if (input == null || isNotCorrectInput(input)) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private boolean isNotCorrectInput(String input) {
        return !INPUT_FORM.matcher(input)
            .matches();
    }

    private boolean isNumber(String value) {
        return NUMBER.matcher(value)
            .matches();
    }

    private boolean isOperator(String value) {
        return OPERATOR.matcher(value)
            .matches();
    }

    private boolean hasValueInStack(Stack<String> converter) {
        return !converter.isEmpty();
    }

    private boolean isPopOperator(String converterOperator, String inputOperator) {
        return getOperatorPriorityValue(converterOperator) >= getOperatorPriorityValue(inputOperator);
    }

    private int getOperatorPriorityValue(String operator) {
        return OperatorType.from(operator)
            .getPriorityValue();
    }
}
