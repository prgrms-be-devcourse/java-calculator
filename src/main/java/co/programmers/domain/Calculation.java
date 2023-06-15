package co.programmers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculation {

    private static final String DELIMITER = " ";
    private final Stack<String> operators = new Stack<>();
    private final Stack<Double> calculationBuffer = new Stack<>();
    private final List<String> postfix = new ArrayList<>();
    private Expression expression;

    public Calculation(Expression expression) {
        this.expression = expression;
    }

    public static boolean isNumeric(String stringNumber) {
        return stringNumber.chars().allMatch(Character::isDigit);
    }

    public Double calculate() throws ArithmeticException {
        String postfixExpression = convertInfixToPostfix();
        for (String component : postfixExpression.split(DELIMITER)) {
            evaluatePostfixComponent(component);
        }
        return calculationBuffer.pop();
    }

    private void evaluatePostfixComponent(String component) throws ArithmeticException {
        if (isNumeric(component)) {
            calculationBuffer.push(Double.parseDouble(component));
            return;
        }
        Double operand2 = calculationBuffer.pop();
        Double operand1 = calculationBuffer.pop();
        Double intermediateResult = Operator.calculate(component, operand1, operand2);
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
        for (String current : expression.split(DELIMITER)) {
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
