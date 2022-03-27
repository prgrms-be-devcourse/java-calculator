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
                if (OPERATOR.PLUS.getValue().equals(element))
                    stack.push(cal.plus(operand1, operand2));
                if (OPERATOR.MINUS.getValue().equals(element))
                    stack.push(cal.minus(operand1, operand2));
                if (OPERATOR.MULTIPLY.getValue().equals(element))
                    stack.push(cal.multiply(operand1, operand2));
                if (OPERATOR.DIVIED.getValue().equals(element))
                    stack.push(cal.divied(operand1, operand2));
                continue;
            }
            stack.push(Double.parseDouble(element));
        }
        return stack.pop();
    }
}
