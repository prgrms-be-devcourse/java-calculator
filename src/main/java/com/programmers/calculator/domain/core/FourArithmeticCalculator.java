package com.programmers.calculator.domain.core;

import com.programmers.calculator.constant.RegexEnum;
import com.programmers.calculator.domain.component.Evaluator;
import com.programmers.calculator.domain.component.NotationConverter;
import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;

import java.util.List;

public class FourArithmeticCalculator implements Calculator {

    private final NotationConverter converter;
    private final Evaluator evaluator;

    public FourArithmeticCalculator(NotationConverter converter, Evaluator evaluator) {
        this.converter = converter;
        this.evaluator = evaluator;
    }

    @Override
    public CalculationResult calculate(Expression expression) {
        List<String> tokens = RegexEnum.parseToTokens(expression);
        List<String> postfix = converter.convert(tokens);
        return evaluator.evaluate(postfix);
    }

}
