package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {
    Calculator cal;
    InputParser parser;
    Deque<Double> stack;

    public StringCalculator() {
        cal = new Calculator();
        parser = new InputParser();
        stack = new ArrayDeque<>();
    }

    public double calculate(String stringFormula) throws Exception {
        String[] postfixFormula = parser.parse(stringFormula);
        for (String element : postfixFormula) {
            if (OPERATOR.isOperator(element)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                stack.push(operation(operand1,operand2,element));
                continue;
            }
            stack.push(Double.parseDouble(element));
        }
        return stack.pop();
    }

    private double operation(double operand1, double operand2, String operator) {
        if (OPERATOR.PLUS.getValue().equals(operator))
            return cal.plus(operand1, operand2);
        if (OPERATOR.MINUS.getValue().equals(operator))
            return cal.minus(operand1, operand2);
        if (OPERATOR.MULTIPLY.getValue().equals(operator))
            return cal.multiply(operand1, operand2);
        if (OPERATOR.DIVIED.getValue().equals(operator))
            return cal.divied(operand1, operand2);
        throw new IllegalArgumentException();
    }
}
