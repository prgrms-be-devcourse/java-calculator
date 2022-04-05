package com.programmers.java.calculator;

import com.programmers.java.calculator.arithmetic.Operator;
import com.programmers.java.calculator.arithmetic.Parser;

public class ArithmeticModule {
    private final Parser parser = new Parser();
    private final Operator operator = new Operator();

    public String execute(String expression) {
        return operator.getResult(parser.parseToToken(expression));
    }

}
