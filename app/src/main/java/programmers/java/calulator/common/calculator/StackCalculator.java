package programmers.java.calulator.common.calculator;

import programmers.java.calulator.common.operator.Operator;
import programmers.java.calulator.common.utils.Number;

import java.util.Stack;

public class StackCalculator implements Calculator {
    private final Stack<Integer> numberStack = new Stack<>();
    private final Stack<Operator> operatorStack = new Stack<>();

    @Override
    public int calculate(String expression) {
        return calculate(expression.split(" "));
    }

    private int calculate(String[] tokens) {
        for (String token : tokens) {
            Number.of(token).ifPresentOrElse(
                    number -> numberStack.push(number.toInt()),
                    () -> handleOperator(Operator.of(token))
            );
        }

        while (!operatorStack.isEmpty()) {
            numberStack.push(calculateTop());
        }
        return numberStack.pop();
    }

    private void handleOperator(Operator operator) {
        while (!operatorStack.isEmpty() && !operator.isHighPriority(operatorStack.peek())) {
            numberStack.push(calculateTop());
        }
        operatorStack.push(operator);
    }

    private int calculateTop() {
        int number2 = numberStack.pop();
        int number1 = numberStack.pop();
        Operator operator = operatorStack.pop();
        return operator.calculate(number1, number2);
    }
}
