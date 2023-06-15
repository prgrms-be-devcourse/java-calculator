package org.programmers.controller;

import org.programmers.domain.calculator.Calculator;
import org.programmers.domain.converter.Converter;
import org.programmers.domain.expression.ExpressionParam;
import org.programmers.domain.expression.ExpressionResult;

public class CalculatorManagement {

    private final Calculator calculator;

    private final Converter converter;

    public CalculatorManagement(Calculator calculator, Converter converter) {
        this.calculator = calculator;
        this.converter = converter;
    }

    public ExpressionResult runCalculator(String expression) {
        ExpressionParam param = converter.convert(expression);
        ExpressionResult result = calculator.calculate(param);

        return result;
    }
}
