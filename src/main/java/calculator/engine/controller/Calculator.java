package calculator.engine.controller;

import calculator.engine.calculator.ArithmeticCalculator;
import calculator.engine.calculator.PostfixCalculator;
import calculator.engine.converter.Converter;
import calculator.engine.converter.PostfixConverter;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;

public class Calculator {
    private final Converter converter = new PostfixConverter();
    private final ArithmeticCalculator calculator = new PostfixCalculator();

    public CalculationResult calculate(Expression infix) {
        Expression postfix = converter.toPostfix(infix);
        CalculationResult result = calculator.calculate(postfix);
        return new CalculationResult();
    }
}
