package calculator.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixExpression {
    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";
    private static final Pattern INPUT_FORM = Pattern.compile("\\d+(.\\d+)?( [+-/*] \\d+(.\\d+)?)*");
    private static final Pattern NUMBER = Pattern.compile("\\d+(.\\d+)?");
    private static final Pattern OPERATOR = Pattern.compile("[+-/*]");
    private static final String DELIMITER = " ";

    private final List<String> expression;

    private PostfixExpression(List<String> expression) {
        this.expression = parsePostfix(expression);
    }

    public static PostfixExpression from(String expression) {
        validateExpression(expression);
        return new PostfixExpression(Arrays.stream(expression.split(DELIMITER))
            .collect(toList()));
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

    private List<String> parsePostfix(List<String> expression) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (String value : expression) {
            if (isNumber(value)) {
                result.add(value);
                continue;
            }

            if (isOperator(value)) {
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

    private boolean isNumber(String value) {
        return NUMBER.matcher(value)
            .matches();
    }

    private boolean isOperator(String value) {
        return OPERATOR.matcher(value)
            .matches();
    }

    private boolean hasValueInStack(Stack<String> stack) {
        return !stack.isEmpty();
    }

    private boolean isPopOperator(String stackPeekOperator, String inputOperator) {
        return getOperatorPriorityValue(stackPeekOperator) >= getOperatorPriorityValue(inputOperator);
    }

    private int getOperatorPriorityValue(String operator) {
        return OperatorType.from(operator)
            .getPriorityValue();
    }

    public Double calculate() {
        Stack<Double> stack = new Stack<>();

        for (String value : expression) {
            if (isNumber(value)) {
                stack.add(Double.valueOf(value));
                continue;
            }

            if (isOperator(value)) {
                double secondNumber = stack.pop();
                double firstNumber = stack.pop();
                stack.add(OperatorType.calculate(value, firstNumber, secondNumber));
            }
        }
        return stack.pop();
    }
}
