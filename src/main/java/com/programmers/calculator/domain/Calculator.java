package com.programmers.calculator.domain;

import com.programmers.calculator.domain.component.Converter;
import com.programmers.calculator.domain.component.Parser;

import java.math.BigDecimal;

public class Calculator {
    private final Parser parser;
    private final Converter converter;

    public Calculator(Parser parser, Converter converter) {
        this.parser = parser;
        this.converter = converter;
    }

    public BigDecimal calculate(String expression) {
        parser.parseToTokens(expression);
        converter.convert(expression);
        return BigDecimal.ZERO;
    }
}
