package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.component.Converter;
import com.programmers.calculator.domain.component.Evaluator;
import com.programmers.calculator.domain.component.Parser;
import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;

import java.util.List;

public class FourArithmeticCalculator implements Calculator {

    private final Parser parser;
    private final Converter converter;
    private final Evaluator evaluator;

    public FourArithmeticCalculator(Parser parser, Converter converter, Evaluator evaluator) {
        this.parser = parser;
        this.converter = converter;
        this.evaluator = evaluator;
    }

    @Override
    public CalculationResult calculate(Expression expression) {
        List<String> tokens = parser.parseToTokens(expression);
        List<String> postfix = converter.convert(tokens);
        return evaluator.evaluate(postfix);
    }

}
