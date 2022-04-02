package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.domain.OperatorType;

public class PostfixParser {
    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";
    private static final Pattern INPUT_FORM = Pattern.compile("-?\\d+(.\\d+)?( [+-/*] -?\\d+(.\\d+)?)*");
    private static final String DELIMITER = " ";

    private PostfixParser() {
    }

    public static List<String> parse(String expression) {
        validateExpression(expression);

        List<String> splitExpression = split(expression);
        return parsePostfix(splitExpression);
    }

    private static List<String> parsePostfix(List<String> splitExpression) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (String value : splitExpression) {
            if (ValidatorString.isNumber(value)) {
                result.add(value);
                continue;
            }

            if (ValidatorString.isOperator(value)) {
                while (hasValueInStack(stack) && isPopOperator(stack.peek(), value)) {
                    result.add(stack.pop());
                }
                stack.add(value);
            }
        }

        while (hasValueInStack(stack)) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void validateExpression(String expression) {
        if (expression == null || isNotCorrectInput(expression)) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private static boolean isNotCorrectInput(String input) {
        return !INPUT_FORM.matcher(input)
            .matches();
    }

    private static List<String> split(String expression) {
        return Arrays.stream(expression.split(DELIMITER))
            .collect(Collectors.toList());
    }

    private static boolean hasValueInStack(Stack<String> stack) {
        return !stack.isEmpty();
    }

    private static boolean isPopOperator(String stackPeekOperator, String inputOperator) {
        return getOperatorPriorityValue(stackPeekOperator) >= getOperatorPriorityValue(inputOperator);
    }

    private static int getOperatorPriorityValue(String operator) {
        return OperatorType.from(operator)
            .getPriorityValue();
    }
}
