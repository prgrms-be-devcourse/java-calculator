package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.converter.ExpressionConverter;
import com.programmers.converter.InfixToPostfixConverter;

public class App {
    public static void main(String[] args) {
        ExpressionConverter expressionConverter = new InfixToPostfixConverter();
        Calculator calculator = new Calculator(expressionConverter);
        calculator.run();
    }
}