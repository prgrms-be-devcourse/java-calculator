package programmers.java.calulator.common.calculator;

import programmers.java.calulator.common.operator.Operator;
import programmers.java.calulator.common.utils.Number;

import java.util.Stack;

public class StackCalculator implements Calculator {
    private final Stack<Integer> numberStack = new Stack<>();
    private final Stack<Operator> operatorStack = new Stack<>();
    private String[] tokens;

    @Override
    public int calculate(String expression) {
        this.tokens = expression.split(" ");
        parse(tokens);
        finalizeCalculation();
        return numberStack.pop();
    }

    private void parse(String[] tokens) {
        for (String token : tokens) {
            Number.of(token).ifPresentOrElse(
                    number -> numberStack.push(number.toInt()),
                    () -> handleOperator(Operator.of(token))
            );
        }
    }

    private void handleOperator(Operator operator) {
        while (!operatorStack.isEmpty() && !operator.isHighPriority(operatorStack.peek())) {
            calculateTop();
        }

        operatorStack.push(operator);
    }

    private void finalizeCalculation() {
        while (!operatorStack.isEmpty()) {
            calculateTop();
        }
    }

    private void calculateTop() {
        int number2 = numberStack.pop();
        int number1 = numberStack.pop();
        Operator operator = operatorStack.pop();

        numberStack.push(operator.calculate(number1, number2));
    }
}
