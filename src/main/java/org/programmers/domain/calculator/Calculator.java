package org.programmers.domain.calculator;

import org.programmers.constant.Operator;
import org.programmers.domain.expression.ExpressionParam;
import org.programmers.domain.expression.ExpressionResult;
import org.programmers.domain.expression.ExpressionValidator;

public abstract class Calculator {

    protected final ExpressionValidator validator;

    public Calculator(ExpressionValidator validator) {
        this.validator = validator;
    }

    public abstract ExpressionResult calculate(ExpressionParam param);

    protected double getCalculationResult(String symbol, double operand1, double operand2) {
        return Operator.find(symbol).get().getAnswer(operand1, operand2);
    }
}
