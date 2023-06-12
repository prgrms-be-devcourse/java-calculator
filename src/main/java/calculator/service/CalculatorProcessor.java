package calculator.service;

import calculator.domain.Expression;
import calculator.domain.enums.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.regex.Pattern;

public class CalculatorProcessor {
    private static final Pattern ARITHMETIC_OPERATION_PATTERNS = Pattern.compile("^[+\\-*\\/]*$");
    private static final Pattern NUMBER_PATTERNS = Pattern.compile("^[0-9]*$");

    private final Deque<Integer> operands = new ArrayDeque<>();
    private final Deque<Operator> operators = new ArrayDeque<>();

    public int calculate(Expression expression) {
        Iterator<String> iterator = expression.getIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            if (ARITHMETIC_OPERATION_PATTERNS.matcher(str).matches()) {
                processExpression(str);
            }
            else if (NUMBER_PATTERNS.matcher(str).matches()) {
                operands.push(Integer.parseInt(str));
            }
        }

        return processOperator();
    }

    private void processExpression(String expression) {
        Operator operator = Operator.from(expression);

        while (!Operator.isHigherPriority(operator) && !operators.isEmpty()) {
            int result = apply();
            operands.push(result);
        }

        operators.push(operator);
    }

    private int processOperator() {
        while (!operators.isEmpty()) {
            int result = apply();
            operands.push(result);
        }

        return operands.pop();
    }

    private int apply() {
        int number2 = operands.pop();
        int number1 = operands.pop();

        Operator operator = operators.pop();
        int result = operator.apply(number1, number2);

        return result;
    }
}
