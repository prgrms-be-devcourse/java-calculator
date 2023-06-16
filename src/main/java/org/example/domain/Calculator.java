package org.example.domain;

import java.util.HashMap;

public class Calculator {

    private ExpressionConvertor expressionConvertor;
    private Processor processor;
    private Memory memory;

    public Calculator() {
        this.expressionConvertor = new ExpressionConvertor();
        this.processor = new Processor();
        this.memory = new Memory();
    }

    public Integer execute(String expression) {
        Integer result = processor.calculate(expressionConvertor.convertToPostfix(expression));

        memory.save(expression, result);
        return result;
    }

    public HashMap<String, Integer> getMap() {
        return memory.getMap();
    }
}
