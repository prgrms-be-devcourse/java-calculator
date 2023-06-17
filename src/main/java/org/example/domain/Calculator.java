package org.example.domain;

import java.util.HashMap;

public class Calculator {

    private ExpressionConvertor expressionConvertor;
    private Processor processor;
    private History history;

    public Calculator() {
        this.expressionConvertor = new ExpressionConvertor();
        this.processor = new Processor();
        this.history = new History();
    }

    public Integer execute(String expression) {
        Integer result = processor.calculate(expressionConvertor.convertToPostfix(expression));

        history.save(expression, result);
        return result;
    }

    public HashMap<String, Integer> getMap() {
        return history.getMap();
    }
}
