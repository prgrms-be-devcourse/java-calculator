package org.programmers.calculator;

import org.programmers.expression.ExpressionParam;
import org.programmers.expression.ExpressionResult;

import java.util.Stack;

public class PostfixCalculator extends Calculator {

    public PostfixCalculator() {
        super();
    }

    @Override
    public ExpressionResult calculate(ExpressionParam param) {
        Stack<String> stack = new Stack<>();

        for (String element : param.getFormula()) {
            if (expressionValidator.isOperator(element)) {
                double firstOperand = Double.parseDouble(stack.pop());
                double secondOperand = Double.parseDouble(stack.pop());

                double result = getCalculationResult(element, firstOperand, secondOperand);

                stack.push(String.valueOf(result));
            } else {
                stack.push(element);
            }
        }
        double answer = Double.parseDouble(stack.pop());
        return new ExpressionResult(param.getOriginalExpression(), answer);
    }
}
