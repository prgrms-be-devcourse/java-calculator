package org.example.domain;

public class Calculator {
    private static Calculator instance;

    private ExpressionConvertor expressionConvertor;
    private Processor processor;
    private Memory memory;

    private Calculator() {
        this.expressionConvertor = new ExpressionConvertor();
        this.processor = new Processor();
        this.memory = new Memory();
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public Integer run(String expression) {
        Integer result = processor.calculate(expressionConvertor.convertToPostfix(expression));

        memory.save(expression, result);
        return result;
    }
}
