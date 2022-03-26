package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import calculator.domain.OperatorType;

public class ExpressionParser implements Parser {
    public static final Pattern NUMBER = Pattern.compile("\\d+(.\\d+)?");
    public static final Pattern OPERATOR = Pattern.compile("[+-/*]");
    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";
    
    private final String delimiter;

    public ExpressionParser(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> parsePostfix(String expression) {
        Stack<String> converter = new Stack<>();
        List<String> result = new ArrayList<>();

        String[] inputStrings = split(expression);

        for (String inputString : inputStrings) {
            if (isNumber(inputString)) {
                result.add(inputString);
                continue;
            }

            if (isOperator(inputString)) {
                while (!converter.isEmpty() && isPopOperator(converter.peek(), inputString)) {
                    result.add(converter.pop());
                }
                converter.add(inputString);
                continue;
            }

            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }

        while (!converter.isEmpty()) {
            result.add(converter.pop());
        }
        return result;
    }

    private boolean isPopOperator(String converterOperator, String inputOperator) {
        return getOperatorPriorityValue(converterOperator) >= getOperatorPriorityValue(inputOperator);
    }

    private int getOperatorPriorityValue(String operator) {
        return OperatorType.from(operator)
            .getPriorityValue();
    }

    private boolean isOperator(String inputString) {
        return OPERATOR.matcher(inputString)
            .matches();
    }

    private boolean isNumber(String inputString) {
        return NUMBER.matcher(inputString)
            .matches();
    }

    private String[] split(String inputString) {
        if (isNullOrBlank(inputString)) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
        return inputString.split(delimiter);
    }

    private boolean isNullOrBlank(String inputString) {
        return inputString == null || inputString.isBlank();
    }
}
