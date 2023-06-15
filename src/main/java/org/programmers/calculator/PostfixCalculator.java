package org.programmers.calculator;

import org.programmers.expression.ExpressionParam;
import org.programmers.expression.ExpressionResult;
import org.programmers.expression.ExpressionValidator;

import java.util.Stack;

public class PostfixCalculator extends Calculator {

    public PostfixCalculator(ExpressionValidator validator) {
        super(validator);
    }

    @Override
    public ExpressionResult calculate(ExpressionParam param) {
        Stack<String> calculateStack = new Stack<>();

        for (String element : param.getPostfix()) {
            if (validator.isOperator(element)) {
                double firstOperand = Double.parseDouble(calculateStack.pop());
                double secondOperand = Double.parseDouble(calculateStack.pop());

                double result = getCalculationResult(element, firstOperand, secondOperand);

                calculateStack.push(String.valueOf(result));
            } else {
                calculateStack.push(element);
            }
        }
        double answer = Double.parseDouble(calculateStack.pop());

        return new ExpressionResult(param.getOriginalExpression(), answer);
    }
}
