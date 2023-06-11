package calculation;

import validation.Validator;
import java.util.*;

public class Calculator {
    private final String expression;

    public Calculator(String infixExpr) {
        Converter converter = new PostfixConverter(infixExpr);
        expression = converter.convert();
    }

    public int calculate() {
        Stack<Integer> calculationStack = new Stack<>();
        String[] exprArray = expression.split("");

        for (String item : exprArray) {
            if (Validator.isNumber(item)) {
                calculationStack.push(Integer.parseInt(item));
            } else if (Validator.isOperator(item)) {
                Integer operand2 = calculationStack.pop();
                Integer operand1 = calculationStack.pop();

                switch (item) {
                    case "+":
                        calculationStack.push(operand1 + operand2);
                        break;
                    case "-":
                        calculationStack.push(operand1 - operand2);
                        break;
                    case "*":
                        calculationStack.push(operand1 * operand2);
                        break;
                    case "/":
                        calculationStack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return calculationStack.pop();
    }
}
