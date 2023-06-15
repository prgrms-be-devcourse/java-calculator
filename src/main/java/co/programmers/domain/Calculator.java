package co.programmers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private final Stack<String> operators = new Stack<>();
    private final Stack<Integer> calculationBuffer = new Stack<>();
    private final List<String> postfix = new ArrayList<>();
    private String delimiter;
    private String expression;

    public Calculator(String delimiter, String expression) {
        this.delimiter = delimiter;
        this.expression = expression;
    }

    public static boolean isNumeric(String stringNumber) {
        return stringNumber.chars().allMatch(Character::isDigit);
    }

    public Integer calculate() throws ArithmeticException {
        String postfixExpression = convertInfixToPostfix();
        for (String component : postfixExpression.split(delimiter)) {
            evaluatePostfixComponent(component);
        }
        return calculationBuffer.pop();
    }

    private void evaluatePostfixComponent(String component) throws ArithmeticException {
        if (isNumeric(component)) {
            calculationBuffer.push(Integer.parseInt(component));
            return;
        }
        int operand2 = calculationBuffer.pop();
        int operand1 = calculationBuffer.pop();
        int intermediateResult = Operator.calculate(component, operand1, operand2);
        calculationBuffer.push(intermediateResult);
    }

    public String convertInfixToPostfix() {
        preProcess();
        while (!operators.empty()) {
            postfix.add(operators.pop());
        }
        return String.join(" ", postfix);
    }

    private void preProcess() {
        for (String current : expression.split(delimiter)) {
            evaluateOperationObject(current);
        }
    }

    private void evaluateOperationObject(String current) {
        if (!Operator.isOperator(current)) {
            postfix.add(current);
            return;
        }
        while (!operators.empty() && Operator.hasLowerPrecedence(current, operators.peek())) {
            postfix.add(operators.pop());
        }
        operators.push(current);
    }
}
