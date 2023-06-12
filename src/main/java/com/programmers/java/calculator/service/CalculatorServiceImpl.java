package com.programmers.java.calculator.service;

import com.programmers.java.calculator.converter.Converter;

public class CalculatorServiceImpl implements CalculatorService {

    private final Converter converter;

    public CalculatorServiceImpl(Converter converter) {
        this.converter = converter;
    }

    @Override
    public String calculate(String expression) {
        StringBuilder builder = new StringBuilder(expression);
        builder.append(" = ");
        String result = (String) converter.convert(expression);
        builder.append(result);
        return result;
    }
}
