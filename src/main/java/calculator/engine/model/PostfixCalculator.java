package calculator.engine.model;

import java.util.List;
import java.util.Stack;

public class PostfixCalculator {
    public int calculate(List<String> postfixExpression) {
        Stack<Integer> operandStack = new Stack<>();

        for (String operand : postfixExpression) {
            if (operand.matches("^?\\d*$")) {
                operandStack.push(Integer.parseInt(operand));
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = 0;

                switch (operand) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Divide by zero!");
                        }
                        result = operand1 / operand2;
                        break;
                }

                operandStack.push(result);
            }
        }
        return operandStack.pop();
    }
}
